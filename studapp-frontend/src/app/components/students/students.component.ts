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

ngOnInit(): void {
  this.getStudents();
  }
  getStudents(): void {
  this.studentService.getStudents()
  .subscribe(students => this.students = students);
  }
  onSelect(student: Student): void {
  this.selectedStudent = student;
  this.selectedEcts = student.numberOfECTS;
  }


}
