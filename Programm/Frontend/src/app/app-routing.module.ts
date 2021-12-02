import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/authentification/login/login.component';
import { RegisterComponent } from './components/authentification/register/register.component';
import { MusicComponent } from './components/music/music.component';

const routes: Routes = [
  {path:'music', component: MusicComponent},
  {path:'register', component: RegisterComponent},
  {path:'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
