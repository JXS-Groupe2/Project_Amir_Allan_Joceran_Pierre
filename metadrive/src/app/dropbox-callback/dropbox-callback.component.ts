import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpRequest, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dropbox-callback',
  templateUrl: './dropbox-callback.component.html',
  styleUrls: ['./dropbox-callback.component.css']
})
export class DropboxCallbackComponent implements OnInit {

  userId = localStorage.getItem("userId");
  client_id = "zzqpivcahceisr2";
  oAuth2Endpoint = "https://api.dropboxapi.com/oauth2/token";
  serverEndpoint = "http://localhost:8080/users/" + this.userId + "/dropbox";

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
    var accessToken = location.hash.substring(location.hash.indexOf("=") + 1, location.hash.indexOf("&"));
    
    this.http.get(this.oAuth2Endpoint, {params: {access_token: accessToken}}).subscribe(data => {
      if (!data.hasOwnProperty("error") && (data["aud"] == this.client_id)) {
        this.http.post(this.serverEndpoint, accessToken);
        this.router.navigate(["/metadrive"]);
      } else {
        alert("erreur validation token");
      }
    })
  }

}
