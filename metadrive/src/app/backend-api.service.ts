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

  getFiles() {
    var userId = localStorage.getItem("userId");
    var url = this.serverEndpoint + "/" + userId + "/files";

    return this.http.get(url, {observe: "response"});
  }

  removeFile(filePath) {
    var userId = localStorage.getItem("userId");
    var url = this.serverEndpoint + "/" + userId + "/files/" + filePath + "/remove";

    return this.http.get(url, {observe: "response"});
  }

}
