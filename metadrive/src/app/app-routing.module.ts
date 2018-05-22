import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { MainComponent } from './main/main.component';
import { GoogleDriveCallbackComponent } from './google-drive-callback/google-drive-callback.component';
import { CreateUserComponent } from './createuser/createuser.component';
import { DropboxCallbackComponent } from './dropbox-callback/dropbox-callback.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'login'
  },
  {
    path: 'login',
    component: AuthComponent
  },
  {
    path: 'createUser',
    component: CreateUserComponent
  },
  {
    path: 'metadrive',
    component: MainComponent
  },
  {
    path: 'googledrivecallback',
    component: GoogleDriveCallbackComponent
  },
  {
    path: 'dropboxcallback',
    component: DropboxCallbackComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule {
}
