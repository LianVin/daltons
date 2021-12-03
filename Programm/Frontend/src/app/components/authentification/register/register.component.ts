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
  newUser: FormGroup;
  public users: User[] = [];
  public user = <User>{};
  public e: any = {};
  
  constructor(private _userService: UserService, private _roleService: RoleService) { }
  
  ngOnInit(): void {}

  registeration(): void{
    let user = new User();
    this._userService.getUser().subscribe(result => {
      this.users = result;
    })
    try{this.users.forEach(userInLoop => {
      if(userInLoop.username === user.username){
        console.log("Username Vorhanden");
      }  
      else{
        user.firstName = this.newUser.get('username').value;
        user.username = this.newUser.get('firstName').value;
        user.lastName = this.newUser.get('lastName').value;
        user.email = this.newUser.get('email').value;
        user.password = this.newUser.get('password').value;
        this._roleService.getRolebyId(2).subscribe((result) => {
          user.roleId = result;
        });
        throw this.e;
      }  
    });}
    catch(e){
      this._userService.createUser(user);
    }
  }
}
