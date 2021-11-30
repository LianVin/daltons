import { Component, OnInit } from '@angular/core';
import { role } from 'src/app/models/role';
import { user } from 'src/app/models/user';
import { UserService } from 'src/app/service/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  logins: any = {
    userName: null,
    password: null
  };

  user = <user>{};

  constructor(private _userService: UserService) { }

  ngOnInit(): void {
  }

  login(): void{
  }
}
