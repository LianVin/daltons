import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { role } from 'src/app/models/role';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  private url = environment.backendUrl + "/role/"

  constructor(private httpClient: HttpClient) { }

  getRole() {
    return this.httpClient.get<role []>(this.url);
  }

  getRolebyId(id: number) {
    return this.httpClient.get<role>(this.url + id);
  }

  deleteRole(id: number) {
    return this.httpClient.delete(this.url + id);
  }

  updateRole(role: role) {
    return this.httpClient.put<role>(this.url + role.roleId, role);
  }

  createRole(role: role) {
    return this.httpClient.post(this.url, role);
  }
}
