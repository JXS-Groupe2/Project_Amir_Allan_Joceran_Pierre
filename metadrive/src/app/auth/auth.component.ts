import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router'
import { BackendApiService } from '../backend-api.service';
=======
import { GoogleApiService } from '../google-api.service';
>>>>>>> 4a508cfaef71a105538e0d038332e8a63fc956bc

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
<<<<<<< HEAD
  
  authForm: FormGroup;
  areCredentialsIncorrect = false;

  constructor(private router: Router, private fb: FormBuilder, private backend: BackendApiService) {
    this.authForm = fb.group({
      'email': '',
      'password': ''
    })
=======

  constructor(private googleApi: GoogleApiService) { }

  ngOnInit() {
>>>>>>> 4a508cfaef71a105538e0d038332e8a63fc956bc
  }

  logInGoogle() {
    this.googleApi.auth();
  }

  logInDropbox() {
    
  }

<<<<<<< HEAD
  submitForm(value: any) {
    if ((value["email"] == "") || (value["password"] == "")) {
      this.areCredentialsIncorrect = true;
    } else {
      var credentials = {
        email: value["email"],
        password: value["password"]
      }

      this.backend.logInUser(credentials).subscribe(resp => {
        console.log(resp);
        console.log(resp.body);
        if (resp.status == 200 && resp.ok) {
          localStorage.setItem("userId", JSON.stringify(resp.body));
          localStorage.setItem("userEmail", value["email"]);
          this.router.navigate(["/metadrive"]);
        } else {
          this.areCredentialsIncorrect = true;
        }
      });
    }
  }

  createUser() {
    this.router.navigate(["/createUser"]);
=======
  logInOneDrive() {
    
>>>>>>> 4a508cfaef71a105538e0d038332e8a63fc956bc
  }

}
