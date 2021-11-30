import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { NavHeaderComponent } from './components/nav-header/nav-header.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatTabsModule } from '@angular/material/tabs';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { LoginComponent } from './components/authentification/login/login.component';
import { RegisterComponent } from './components/authentification/register/register.component';
import { FooterComponent } from './components/footer/footer.component';
import { MusicComponent } from './components/music/music.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { PostsComponent } from './components/posts/posts.component';
import { PostDetailViewComponent } from './components/post-detail-view/post-detail-view.component';
import {MatCardModule} from '@angular/material/card';
import { NewNewsComponent } from './components/new-news/new-news.component';
import {MatInputModule} from '@angular/material/input';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { AlertNewsComponent } from './components/alert-news/alert-news.component';

@NgModule({
  declarations: [
    AppComponent,
    NavHeaderComponent,
    LoginComponent,
    RegisterComponent,
    FooterComponent,
    MusicComponent,
    PostsComponent,
    PostDetailViewComponent,
    NewNewsComponent,
    AlertNewsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatTabsModule,
    NoopAnimationsModule,
    FlexLayoutModule, 
    MatFormFieldModule,
    MatIconModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    MatSidenavModule,
    MatButtonModule,
    HttpClientModule,
    MatInputModule,
    MatCardModule,
    MatCheckboxModule,
    ReactiveFormsModule,
    BrowserAnimationsModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
