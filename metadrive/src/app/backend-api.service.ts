import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Injectable()
export class BackendApiService {

  serverEndpoint = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  logInUser(credentials) {
    var url = this.serverEndpoint + "/users/user";

    this.http.post(url, credentials, {observe: "response"}).subscribe(resp => {
      console.log("-- RESP --");
      console.log(resp);
    });

    return "TODO";
  }

}
