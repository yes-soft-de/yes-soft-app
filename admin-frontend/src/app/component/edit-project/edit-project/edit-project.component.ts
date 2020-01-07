import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-edit-project',
  templateUrl: './edit-project.component.html',
  styleUrls: ['./edit-project.component.scss']
})
export class EditProjectComponent implements OnInit {
  addProjectForm = new FormGroup({
    name: new FormControl(''),
    link: new FormControl(''),
    startDate: new FormControl(''),
    endDate: new FormControl('')
  });
  constructor() { }

  ngOnInit() {
  }

}
