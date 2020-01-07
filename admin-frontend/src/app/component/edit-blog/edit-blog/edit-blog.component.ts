import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-edit-blog',
  templateUrl: './edit-blog.component.html',
  styleUrls: ['./edit-blog.component.scss']
})
export class EditBlogComponent implements OnInit {
  addBlogForm = new FormGroup({
    name: new FormControl(''),
    link: new FormControl(''),
    date: new FormControl('')
  });
  constructor() { }

  ngOnInit() {
  }

}
