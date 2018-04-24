import { Component, OnInit } from '@angular/core';
import { GoogleApiService } from '../google-api.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  constructor(private googleApi: GoogleApiService) { }

  ngOnInit() {
  }

  logInGoogle() {
    this.googleApi.auth();
  }

  logInDropbox() {
    // TODO
  }

  logInOneDrive() {
    // TODO
  }

}
