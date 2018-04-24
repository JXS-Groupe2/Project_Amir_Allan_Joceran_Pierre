import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpParams } from '@angular/common/http';

@Injectable()
export class GoogleApiService {

  oAuth2Endpoint = "https://accounts.google.com/o/oauth2/v2/auth";
  authParams = {
    // TODO extraire les informations d'un fichier non versionné
    client_id: "291138564912-q6dh8mlriam2s9msgiv8te83iaaja8u1.apps.googleusercontent.com",
    scope: "https://www.googleapis.com/auth/drive",
    redirect_uri: "http://localhost:4200/oauth2callback",
    response_type: "token"
  }

  constructor(private http: HttpClient) { }

  auth() {
    var request = new HttpRequest("GET", this.oAuth2Endpoint, {params: new HttpParams({fromObject: this.authParams})});
    window.location.href = request.urlWithParams;
  }
  
}
