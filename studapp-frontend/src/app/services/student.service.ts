import { Injectable } from '@angular/core';
import { Student } from '../interfaces/student';
import { STUDENTS } from '../mock-students';
import { Observable, of } from "rxjs";

@Injectable({
  providedIn: 'root'
})
@Injectable({
  providedIn: 'root'
  })
  export class StudentService {
  constructor() { }
  getStudents(): Observable<Student[]> {
  return of(STUDENTS);
  }
  }