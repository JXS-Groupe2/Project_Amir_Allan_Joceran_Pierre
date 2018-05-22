import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Injectable()
export class BackendApiService {

  serverEndpoint = "http://localhost:8080/metadrive";

  constructor(private http: HttpClient) { }

  logInUser(credentials) {
    var url = this.serverEndpoint + "/users/user"
              + "?email=" + credentials["email"]
              + "&password=" + credentials["password"];

    return this.http.get(url, {observe: "response"});
  }

  createUser(credentials) {
    var url = this.serverEndpoint + "/users/create"
              + "?email=" + credentials["email"]
              + "&password=" + credentials["password"];

    return this.http.post(url, {observe: "response"});
  }

  getFiles() {
    var userId = localStorage.getItem("userId");
    userId = userId.substring(1, userId.length - 1);
    var url = this.serverEndpoint + "/files/" + userId + "/";

    return this.http.get(url, {observe: "response"});
  }

  removeFile(filePath) {
    var userId = localStorage.getItem("userId");
    var url = this.serverEndpoint + "/" + userId + "/files/" + filePath + "/remove";

    return this.http.get(url, {observe: "response"});
  }

}
