export class User {
  userName: string;
  email: string;
  password: string;
  firstName: string;
  lastName: string;
  roles: string[];
  constructor(userName: string,
    email: string,
    password: string,
    firstName: string,
    lastName: string,
    roles: string[]) {
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.roles = roles;
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
