import { Component, OnInit } from '@angular/core';
import { Lecturer } from '../../interfaces/lecturer';
import { LecturerService} from "../../services/lecturer.service";
import AOS from 'aos';

@Component({
  selector: 'app-lecturer',
  templateUrl: './lecturer.component.html',
  styleUrls: ['./lecturer.component.css']
})
export class LecturerComponent implements OnInit {
  lecturers: Lecturer[];

  constructor(private lecturerService: LecturerService) { }

  ngOnInit(): void {
    this.getLecturers();

    AOS.init({
      duration: 400,
    })
   
  }

  getLecturers() {
    this.lecturerService.getLecturers().subscribe(l => this.lecturers=l);
  }

}
