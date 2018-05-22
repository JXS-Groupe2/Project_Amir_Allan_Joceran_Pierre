import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { MainComponent } from './main/main.component';
import { GoogleDriveCallbackComponent } from './google-drive-callback/google-drive-callback.component';

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
    path: 'metadrive',
    component: MainComponent
  },
  {
    path: 'googledrivecallback',
    component: GoogleDriveCallbackComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule {
}
