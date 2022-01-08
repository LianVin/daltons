import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/service/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  public user: User;
  logins: any = {
    username: null,
    password: null
  };

  constructor(private _userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  login(): void{
    this._userService.getUserByName(this.logins.username).subscribe(
      result=>{
        this.user = result;
        //TODO password
        if(this.user.username === this.logins.username && this.user.password === this.logins.password){
          this.router.navigateByUrl("news"); 
        }
        else(
          console.log("nicht richtige informationen")
        )
      }
    );   
  }
}
