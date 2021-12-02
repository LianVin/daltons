import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Role } from 'src/app/models/role';
import { User } from 'src/app/models/user';
import { RoleService } from 'src/app/service/role/role.service';
import { UserService } from 'src/app/service/user/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent implements OnInit {
  register: any = {
    userName: null,
    firstName: null,
    lastName: null,
    email: null,
    password: null
  };
  public users: user[] = [];
  public user = <user>{};
  public e: any = {};
  
  constructor(private _userService: UserService, private _roleService: RoleService) { }
  
  ngOnInit(): void {}

  registeration(): void{
    this._userService.getUser().subscribe(result => {
      this.users = result;
    })
    try{this.users.forEach(userInLoop => {
      if(userInLoop.username === this.user.username){
        console.log("Username Vorhanden");
      }  
      else{
        this.user.firstName = this.register.firstName;
        this.user.username = this.register.userName;
        this.user.lastName = this.register.lastName;
        this.user.email = this.register.email;
        this.user.password = this.register.password;
        this._roleService.getRolebyId(2).subscribe((result) => {
          this.user.roleId = result;
        });
        throw this.e;
      }  
    });}
    catch(e){
      this._userService.createUser(this.user);
    }
}
