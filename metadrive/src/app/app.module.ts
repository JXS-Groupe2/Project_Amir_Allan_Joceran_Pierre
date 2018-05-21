import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AuthComponent } from './auth/auth.component';
import { GoogleApiService } from './google-api.service';
import { AppRoutingModule } from './app-routing.module';
import { MainComponent } from './main/main.component';
import { ServicesAuthComponent } from './services-auth/services-auth.component';
import { GoogleDriveCallbackComponent } from './google-drive-callback/google-drive-callback.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    MainComponent,
    ServicesAuthComponent,
    GoogleDriveCallbackComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    GoogleApiService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
