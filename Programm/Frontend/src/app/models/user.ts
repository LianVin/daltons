import { role } from "./role";

export interface user {
    userId: number;
    username: string;
    firstName: string;
    lastName: string;
    email: string;
    password: string;
    roleId: role;
  }