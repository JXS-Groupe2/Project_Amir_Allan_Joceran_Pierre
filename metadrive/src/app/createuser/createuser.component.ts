import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router'
import { BackendApiService } from '../backend-api.service';

@Component({
  selector: 'app-createuser',
  templateUrl: './createuser.component.html',
  styleUrls: ['./createuser.component.css'],
})
export class CreateUserComponent implements OnInit {

  createUserForm: FormGroup;
  areCredentialsIncorrect = false;

  constructor(private router: Router, private fb: FormBuilder, private backend: BackendApiService) {
    this.createUserForm = fb.group({
      'email': '',
      'password': ''
    });
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
      };

      this.backend.createUser(credentials).subscribe(resp => {
        console.log(resp);
        if (resp != null) {
          this.router.navigate(["/login"]);
        } else {
          this.areCredentialsIncorrect = true;
        }
      });
    }
  }

}
