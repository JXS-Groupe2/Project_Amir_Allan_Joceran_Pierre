import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

  userEmail: string;

  constructor() {
    this.userEmail = localStorage.getItem("userEmail");
  }

  ngOnInit() {
  }

}
