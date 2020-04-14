import { Component, OnInit } from '@angular/core';
import { Student } from '../../interfaces/student';
import { StudentService} from "../../services/student.service";
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import { DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE } from '@angular/material/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import AOS from 'aos';

export const MY_FORMATS = {
  parse: {
    dateInput: 'DD.MM.YYYY.',
  },
  display: {
    dateInput: 'DD.MM.YYYY.',
    monthYearLabel: 'MMM YYYY.',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY.',
  },
};


@Component({
selector: 'app-students',
templateUrl: './students.component.html',
styleUrls: ['./students.component.css'],
providers: [
  {provide: MAT_DATE_LOCALE, useValue: 'hr'},
  {
    provide: DateAdapter,
    useClass: MomentDateAdapter,
    deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]
  },
  {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS}
]
})


export class StudentsComponent implements OnInit {
students: Student[];
selectedStudent: Student;
selectedEcts: number;

constructor(private studentService: StudentService,private _adapter: DateAdapter<any>,private _snackBar: MatSnackBar) { }

/*croatia() {
  this._adapter.setLocale('hr');
}*/

ngOnInit() {
    this.getStudents();
      AOS.init({
      duration: 400,
      })
  }

  getStudents() {
    this.studentService.getStudents().subscribe(s => this.students=s);
    console.log(this.students);
  }

  onSelect(student: Student) {
    this.selectedStudent = student;
    this.selectedEcts = student.numberOfECTS;
  }

  addStudent(firstName: string, lastName: string, jmbag: string, numberOfECTS: number, dateOfBirth: String){
    if (!firstName || ! lastName || !jmbag || !numberOfECTS || !dateOfBirth)  return;

    let datum = dateOfBirth.split('.');
    if(datum[0].length<2) datum[0]=this._to2digit(datum[0])
    if(datum[1].length<2) datum[1]=this._to2digit(datum[1])
    dateOfBirth=datum[0]+'.'+datum[1]+'.'+datum[2]+'.';

    this.studentService.addStudent({ firstName, lastName, jmbag, numberOfECTS, dateOfBirth } as Student)
    .subscribe(student => {
    this.students.push(student);
  });

  }

  deleteStudent(jmbag){
    this.studentService.deleteStudent(jmbag)
    this.students = this.students.filter(s => s.jmbag != jmbag)
  }

  private _to2digit(n: String) {
    return ('00' + n).slice(-2);
  }

  openSnackBar(message: string) {
    this._snackBar.open(message, 'OK', {
      duration: 2000,
    });
  }

}
