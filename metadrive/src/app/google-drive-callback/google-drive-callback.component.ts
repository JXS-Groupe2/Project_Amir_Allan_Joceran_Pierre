import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpRequest, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-google-drive-callback',
  templateUrl: './google-drive-callback.component.html',
  styleUrls: ['./google-drive-callback.component.css']
})
export class GoogleDriveCallbackComponent implements OnInit {

  userId: string;
  
  client_id = "291138564912-q6dh8mlriam2s9msgiv8te83iaaja8u1.apps.googleusercontent.com";
  oAuth2Endpoint = "https://www.googleapis.com/oauth2/v3/tokeninfo";
  serverEndpoint = "http://localhost:8080/metadrive";

  constructor(private http: HttpClient, private router: Router) {
    this.userId = localStorage.getItem("userId");
    this.userId = this.userId.substring(1, this.userId.length - 1);
    this.serverEndpoint = this.serverEndpoint += "/users/" + this.userId + "/google";
  }

  ngOnInit() {
    console.log("hash :");
    console.log(location.hash);
    var accessToken = location.hash.substring(location.hash.indexOf("=") + 1, location.hash.indexOf("&"));
    this.http.get(this.oAuth2Endpoint, {params: {access_token: accessToken}}).subscribe(data => {
      if (!data.hasOwnProperty("error") && (data["aud"] == this.client_id)) {
        var tokenTest = "ya29.GlzDBZAPsf1QxdSi_xNQfvDFQN1qK0LDCuQ1w5GncJhPTWMR7yiQybNldfonJFJUgOexgyod1bSIxTzaCcOux3iT87X9_8oLWt0AraKT1dGvrGXs-J28l5dNLwd3Wg";
        console.log("accessToken :", accessToken)
        this.serverEndpoint += "?token=" + accessToken;
        this.http.post(this.serverEndpoint, {observe: "response"}).subscribe(resp => {
          console.log(resp);
          if (resp != null) {
            this.router.navigate(["/metadrive"]);
          } else {
            alert("erreur envoie du token au back-end");
          }
        });
      } else {
        alert("erreur validation token");
      }
    })
  }

}
