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

  user: user;
  basic: role;
 
  constructor(private _userService: UserService, private _roleService: RoleService) { }
  
  ngOnInit(): void {}

  registeration(): void{
    this.user.firstName = this.register.firstName;
    this.user.userName = this.register.userName;
    this.user.lastName = this.register.lastName;
    this.user.email = this.register.email;
    this.user.password = this.register.password;
    this.user.role = this._roleService.getRole[1];
    this._userService.createUser(this.register);
  }
}
