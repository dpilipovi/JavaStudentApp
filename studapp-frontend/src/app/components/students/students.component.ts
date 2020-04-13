import { Component, OnInit } from '@angular/core';
import { Student } from '../../interfaces/student';
import { StudentService} from "../../services/student.service";

@Component({
selector: 'app-students',
templateUrl: './students.component.html',
styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {
students: Student[];
selectedStudent: Student;
selectedEcts: number;

constructor(private studentService: StudentService) { }

ngOnInit() {
  this.getStudents();
  }

  getStudents() {
  this.studentService.getStudents().subscribe(s => this.students=s);

  }

  onSelect(student: Student) {
  this.selectedStudent = student;
  this.selectedEcts = student.numberOfECTS;
  }

  addStudent(firstName: string, lastName: string, jmbag: string, numberOfECTS: number, dateOfBirth: string){

    console.log(firstName +" "+ lastName +" "+ jmbag +" "+ numberOfECTS +" "+ dateOfBirth)

    if (!firstName || ! lastName || !jmbag || !numberOfECTS || !dateOfBirth)  return;

    var day=dateOfBirth.slice(8,10)
    var month=dateOfBirth.slice(5,7)
    var year=dateOfBirth.slice(0,4)

    dateOfBirth=day+"."+month+"."+year+"."
    //console.log(dateOfBirth)


  this.studentService.addStudent({ firstName, lastName, jmbag, numberOfECTS, dateOfBirth } as Student)
  .subscribe(student => {
  this.students.push(student);
  });

  }

  deleteStudent(jmbag){
    this.studentService.deleteStudent(jmbag)
    this.students = this.students.filter(s => s.jmbag != jmbag)
  }



}
