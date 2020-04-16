import { Injectable } from '@angular/core';
import { Lecturer } from '../interfaces/lecturer';
import { Observable, of } from "rxjs";
import http from "../http-common";
import { map, catchError, tap } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class LecturerService {

  private lecturerURL = 'http://localhost:8080/lecturer';
  httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(
  private http: HttpClient
  ) { }

  getLecturers(): Observable<Lecturer[]> {
    console.log("tu sam")
    return this.http.get<Lecturer[]>(this.lecturerURL,this.httpOptions).pipe(
      tap(_ => console.log('fetched lecturers')),
      catchError(this.handleError<Lecturer[]>('getLecturers', []))
      );

    }

  getLecturerById(id): Observable<Lecturer>{
    const url = `${this.lecturerURL}/${id}`;
    return this.http.get<Lecturer>(url,this.httpOptions).pipe(
      tap(_ => console.log(`fetched lecturer with id:`+id)),
      catchError(this.handleError<Lecturer>('get lecturer')))
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
    console.error(operation);
    console.error(error);
    return of(result as T);
    };
    }

}
