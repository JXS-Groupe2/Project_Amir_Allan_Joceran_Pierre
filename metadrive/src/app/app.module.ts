import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { AuthComponent } from './auth/auth.component';
import { GoogleApiService } from './google-api.service';
<<<<<<< HEAD
import { AppRoutingModule } from './app-routing.module';
import { MainComponent } from './main/main.component';
import { ServicesAuthComponent } from './services-auth/services-auth.component';
import { GoogleDriveCallbackComponent } from './google-drive-callback/google-drive-callback.component';
import { ExplorerComponent } from './explorer/explorer.component';
import { UserInfoComponent } from './user-info/user-info.component';
import { FileDetailsComponent } from './file-details/file-details.component';
import { StorageInfoComponent } from './storage-info/storage-info.component';
import { BackendApiService } from './backend-api.service';
import { ShortNamePipe } from './short-name.pipe';
import { SelectedFileDetailsService } from './selected-file-details.service';
import { DropboxCallbackComponent } from './dropbox-callback/dropbox-callback.component';
import { CreateUserComponent } from './createuser/createuser.component';
import { DropboxApiService } from './dropbox-api.service';
=======

>>>>>>> 4a508cfaef71a105538e0d038332e8a63fc956bc

@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
    AuthComponent,
    CreateUserComponent,
    MainComponent,
    ServicesAuthComponent,
    GoogleDriveCallbackComponent,
    DropboxCallbackComponent,
    ExplorerComponent,
    UserInfoComponent,
    FileDetailsComponent,
    StorageInfoComponent,
    ShortNamePipe,
=======
    AuthComponent
>>>>>>> 4a508cfaef71a105538e0d038332e8a63fc956bc
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
<<<<<<< HEAD
    AppRoutingModule
  ],
  providers: [
    GoogleApiService,
    DropboxApiService,
    BackendApiService,
    SelectedFileDetailsService
=======
>>>>>>> 4a508cfaef71a105538e0d038332e8a63fc956bc
  ],
  providers: [GoogleApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
