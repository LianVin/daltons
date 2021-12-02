import { Component, OnInit } from '@angular/core';
import { throwSbbDuplicatedSidebarError } from '@sbb-esta/angular-business';
import { Router } from '@angular/router'
import { user } from 'src/app/models/user';
import { UserService } from 'src/app/service/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  public user: user;
  logins: any = {
    userName: null,
    password: null
  };

  constructor(private _userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  login(): void{
    this._userService.getUserByName(this.logins.userName).subscribe(
      result=>{
        this.user = result;
      }
    );   
    if(this.user.username === this.logins.userName && this.user.password === this.logins.password){
      this.router.navigateByUrl(""); 
    }
    else(
      console.log("nicht richtige informationen")
    )
  }
}
