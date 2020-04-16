import { Component, OnInit, Input } from '@angular/core';
import { Lecturer } from '../../interfaces/lecturer';
import { ActivatedRoute } from '@angular/router';
import { LecturerService } from "../../services/lecturer.service";

@Component({
  selector: 'app-lecturer-detail',
  templateUrl: './lecturer-detail.component.html',
  styleUrls: ['./lecturer-detail.component.css']
})
export class LecturerDetailComponent implements OnInit {

  lecturer: Lecturer;
  id : string;

  constructor(private route: ActivatedRoute,private lecturerService: LecturerService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.lecturerService.getLecturerById(this.id).subscribe(l =>this.lecturer=l)
  }

}
