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

  constructor(
    fb: FormBuilder,
    private _userService: UserService,
    private _roleService: RoleService,
    private router: Router
  ) {
    this.newUser = fb.group({
      username: '',
      firstName: '',
      lastName: '',
      email: '',
      password: '',
    });
  }

  ngOnInit(): void {}

  registeration(): void {
    let user = new User();
    user.firstName = this.newUser.get('username').value;
    user.username = this.newUser.get('firstName').value;
    user.lastName = this.newUser.get('lastName').value;
    user.email = this.newUser.get('email').value;
    user.password = this.newUser.get('password').value;
    this._roleService.getRolebyId(1).subscribe((result) => {
      user.roleId = result;
      this._userService.createUser(user).subscribe(() => {
        this.router.navigate(['/']);
      });
    });
  }
}
