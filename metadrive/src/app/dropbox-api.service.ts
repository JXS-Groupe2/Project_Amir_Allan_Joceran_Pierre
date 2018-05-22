import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpParams } from '@angular/common/http';

@Injectable()
export class DropboxApiService {

  oAuth2Endpoint = 'https://www.dropbox.com/oauth2/authorize';
  authParams = {
    // TODO extraire les informations d'un fichier non versionné
    client_id: 'zzqpivcahceisr2',
    scope: 'https://www.googleapis.com/auth/drive',
    redirect_uri: 'http://localhost:4200/dropboxcallback',
    response_type: 'token'
  };

  constructor(private http: HttpClient) { }

  auth() {
    const request = new HttpRequest("GET", this.oAuth2Endpoint, {params: new HttpParams({fromObject: this.authParams})});
    window.location.href = request.urlWithParams;
  }

}
