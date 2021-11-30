import { Component, OnInit } from '@angular/core';
import { role } from 'src/app/models/role';
import { user } from 'src/app/models/user';
import { RoleService } from 'src/app/service/role/role.service';
import { UserService } from 'src/app/service/user/user.service'

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})

export class RegisterComponent implements OnInit {
  register: any = {
    userName: null,
    firstName: null,
    lastName: null,
    email: null,
    password: null
  };

  user = <user>{};
  users: user[] = [];
 
  constructor(private _userService: UserService) { }
  
  ngOnInit(): void {}

  registeration(): void{
    this.user.firstName = this.register.firstName;
    this.user.username = this.register.userName;
    this.user.lastName = this.register.lastName;
    this.user.email = this.register.email;
    this.user.password = this.register.password;
    this._userService.createUser(this.user);
  }
}
