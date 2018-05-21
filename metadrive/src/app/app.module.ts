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
import { ExplorerComponent } from './explorer/explorer.component';
import { UserInfoComponent } from './user-info/user-info.component';
import { FileDetailsComponent } from './file-details/file-details.component';
import { StorageInfoComponent } from './storage-info/storage-info.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    MainComponent,
    ServicesAuthComponent,
    ExplorerComponent,
    UserInfoComponent,
    FileDetailsComponent,
    StorageInfoComponent,
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
