import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router'
import { BackendApiService } from '../backend-api.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'],
})
export class AuthComponent implements OnInit {
  
  serverEndpoint = "http://localhost:8080/users";
  authForm: FormGroup;
  areCredentialsIncorrect = false;

  constructor(private router: Router, private fb: FormBuilder, private backend: BackendApiService) {
    this.authForm = fb.group({
      'email': '',
      'password': ''
    })
  }

  ngOnInit() {
  }

  submitForm(value: any) {
    if ((value["email"] == "") || (value["password"] == "")) {
      this.areCredentialsIncorrect = true;
    } else {
      var credentials = {
        email: value["email"],
        password: value["password"]
      }

      this.backend.logInUser(credentials).subscribe(resp => {
        if (resp.status == 200) {
          localStorage.setItem("userEmail", resp.body.toString());
          this.router.navigate(["/metadrive"]);
        } else {
          this.areCredentialsIncorrect = true;
        }
      });
    }
  }

}
