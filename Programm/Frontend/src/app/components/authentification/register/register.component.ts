import { Component, OnInit } from '@angular/core';
import { Role } from 'src/app/models/role';
import { User } from 'src/app/models/user';
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

  basic: Role;
 
  constructor(private _userService: UserService, private _roleService: RoleService) { }
  
  ngOnInit(): void {}

  registeration(): void{
    let user = new User();
    user.firstName = this.register.firstName;
    user.username = this.register.username;
    user.lastName = this.register.lastName;
    user.email = this.register.email;
    user.password = this.register.password;
    user.role = this._roleService.getRole[1];
    this._userService.createUser(this.register).subscribe();
  }
}
