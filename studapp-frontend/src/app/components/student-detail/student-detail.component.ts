import { Component, OnInit, Input } from '@angular/core';
import { Student } from '../../interfaces/student';
import { ActivatedRoute } from '@angular/router';
import { StudentService} from "../../services/student.service";
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
selector: 'app-student-detail',
templateUrl: './student-detail.component.html',
styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

   student: Student;
   jmbag : string;
   edit : boolean;

  constructor(private route: ActivatedRoute,private studentService: StudentService,private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.jmbag = this.route.snapshot.paramMap.get('jmbag');
    this.studentService.getStudentByJmbag(this.jmbag).subscribe(s =>this.student=s)
    this.edit=false;
  }

  updateStudentECTS(ects: number)
  {
    if(!ects) return;
    this.studentService.updateStudentECTS(this.student.jmbag,/*this.student.numberOfECTS+*/ects*1)
    this.student.numberOfECTS+=ects*1;
    this.edit=!this.edit;
  }

  openSnackBar(message: string) {
    this._snackBar.open(message, 'OK', {
      duration: 2000,
    });
  }


}
