import { Role } from "./role";

export class User {
    userId: number;
    username: string;
    firstName: string;
    lastName: string;
    email: string;
    password: string;
    role: Role;
  }