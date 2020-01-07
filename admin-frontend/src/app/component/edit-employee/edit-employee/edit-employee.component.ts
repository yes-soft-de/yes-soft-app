import {Component, Input, OnInit} from '@angular/core';
import {EmployeeModel} from '../../../model/employee-model';
import {FormControl, FormGroup} from '@angular/forms';
import {MatDialogRef} from '@angular/material';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.scss']
})
export class EditEmployeeComponent implements OnInit {

  @Input() id: number;
  employee: EmployeeModel = {
    id: 4,
    name: 'Mujeeba Haj Najeeb',
    age: '24',
    quote: 'Dream big & work hard',
    position: 'Scrum Master',
    image: 'https://res.cloudinary.com/micksawy3r/image/upload/v1576944667/Mujeeba_Haj_Najeeb.jpg',
    linkedin: 'https://www.linkedin.com/in/mujeeba-haj-najeeb-327228161/',
    facebook: null,
    twitter: null,
    github: null,
    email: null,
    createdAt: '2019-12-21T16:38:27.654Z',
    updatedAt: '2019-12-21T16:38:27.654Z'
  };

  editEmployeeFrom = new FormGroup({
    image: new FormControl({value: this.employee.image, disabled: false}),
    name: new FormControl({value: this.employee.name, disabled: false}),
    position: new FormControl({value: this.employee.position, disabled: false}),
    facebook: new FormControl({value: this.employee.facebook, disabled: false}),
    twitter: new FormControl({value: this.employee.twitter, disabled: false}),
    linkedin: new FormControl({value: this.employee.linkedin, disabled: false}),
    github: new FormControl({value: this.employee.github, disabled: false}),
  });


  constructor(public dialogRef: MatDialogRef<EditEmployeeComponent>) {
  }

  ngOnInit() {
  }

  closeDialog() {
    this.dialogRef.close();
  }

  saveChanges() {
    // TODO Send to API
  }
}
