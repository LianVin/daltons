import { role } from "./role";

export interface user {
    userId: number;
    userName: string;
    firstName: string;
    lastName: string;
    email: string;
    password: string;
    role: role;
  }