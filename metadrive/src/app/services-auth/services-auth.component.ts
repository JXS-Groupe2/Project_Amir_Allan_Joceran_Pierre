import { Component, OnInit } from '@angular/core';
import { GoogleApiService } from '../google-api.service';
import { DropboxApiService } from '../dropbox-api.service';

@Component({
  selector: 'app-services-auth',
  templateUrl: './services-auth.component.html',
  styleUrls: ['./services-auth.component.css']
})
export class ServicesAuthComponent implements OnInit {

  constructor(private googleApi: GoogleApiService, private dropboxApi: DropboxApiService) { }

  ngOnInit() {
  }

  logInGoogle() {
    this.googleApi.auth();
  }

  logInDropbox() {
    this.dropboxApi.auth();
  }

  logInOneDrive() {
    // TODO
  }

}
