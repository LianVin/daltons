import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/authentification/login/login.component';
import { AlertNewsComponent } from './components/alert-news/alert-news.component';
import { RegisterComponent } from './components/authentification/register/register.component';
import { MusicComponent } from './components/music/music.component';
import { NewNewsComponent } from './components/new-news/new-news.component';
import { PostDetailViewComponent } from './components/post-detail-view/post-detail-view.component';
import { PostsComponent } from './components/posts/posts.component';
import { HistoryComponent } from './components/history/history.component';
import { MembersComponent } from './components/members/members.component';
import {UserGuard} from "./user-guard.service";
import {AdminGuard} from "./admin.guard";

const routes: Routes = [
  {path:'music', component: MusicComponent, canActivate: [UserGuard]},
  {path:'members', component: MembersComponent, canActivate: [UserGuard]},
  {path:'music', component: MusicComponent, canActivate: [UserGuard]},
  {path:'register', component: RegisterComponent},
  {path:'history', component: HistoryComponent, canActivate: [UserGuard]},
  {path:'login', component: LoginComponent},
  {path:'news', component: PostsComponent, canActivate: [UserGuard]},
  {path:'news/:id', component: PostDetailViewComponent, canActivate: [UserGuard]},
  {path:'new/news', component: NewNewsComponent, canActivate: [UserGuard] },
  {path:'alter/news/:id', component: AlertNewsComponent, canActivate: [UserGuard, AdminGuard]},
  {path:'', component: PostsComponent, canActivate: [UserGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
