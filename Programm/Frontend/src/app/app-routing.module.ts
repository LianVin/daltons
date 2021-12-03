import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/authentification/login/login.component';
import { AlertNewsComponent } from './components/alert-news/alert-news.component';
import { RegisterComponent } from './components/authentification/register/register.component';
import { MusicComponent } from './components/music/music.component';
import { NewNewsComponent } from './components/new-news/new-news.component';
import { PostDetailViewComponent } from './components/post-detail-view/post-detail-view.component';
import { PostsComponent } from './components/posts/posts.component';

const routes: Routes = [
  {path:'music', component: MusicComponent},
  {path:'register', component: RegisterComponent},
  {path:'login', component: LoginComponent},
  {path:'news', component: PostsComponent},
  {path:'news/:id', component: PostDetailViewComponent},
  {path:'new/news', component: NewNewsComponent },
  {path:'alter/news/:id', component: AlertNewsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
