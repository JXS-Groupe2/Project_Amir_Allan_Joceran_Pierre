import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router'

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'],
})
export class AuthComponent implements OnInit {

  authForm: FormGroup;

  constructor(private router: Router, fb: FormBuilder) {
    this.authForm = fb.group({
      'email': '',
      'password': ''
    })
  }

  ngOnInit() {
  }

  submitForm(value: any) {
    console.log("Form value:");
    console.log(value);
    // TODO: check credentials from server
    this.router.navigate(['/metadrive']);
  }

}
