import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpRequest, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-google-drive-callback',
  templateUrl: './google-drive-callback.component.html',
  styleUrls: ['./google-drive-callback.component.css']
})
export class GoogleDriveCallbackComponent implements OnInit {

  userId = localStorage.getItem("userId");
  client_id = "291138564912-q6dh8mlriam2s9msgiv8te83iaaja8u1.apps.googleusercontent.com";
  oAuth2Endpoint = "https://www.googleapis.com/oauth2/v3/tokeninfo";
  serverEndpoint = "http://localhost:8080/users/" + this.userId + "/google";

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
