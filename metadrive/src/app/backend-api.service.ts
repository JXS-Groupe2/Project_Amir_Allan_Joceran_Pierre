import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Injectable()
export class BackendApiService {

  serverEndpoint = "http://localhost:8080/metadrive";

  constructor(private http: HttpClient) { }

  logInUser(credentials) {
    var url = this.serverEndpoint + "/users/user"
              + "?email=" + credentials["email"];

    return this.http.get(url, {observe: "response"});
  }

}
