import {Component, OnInit} from "@angular/core";
import {FormArray, FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "src/app/services/auth.service";
import {User} from "../user.model";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ["../../app.component.css"]
})
export class RegisterComponent implements OnInit {
  registrationForm: FormGroup;
  user = new User('', '', '', '', '', []);
  isRegistered = false;
  submitted = false;
  errorMessage = '';
  roles: any = [
    {name: 'Nurse', id: 1},
    {name: 'Admin', id: 2},
  ]

  constructor(private authService: AuthService) {
  }

  ngOnInit() {
    this.registrationForm = new FormGroup({
      userName: new FormControl(null, [Validators.required, Validators.minLength(5), Validators.maxLength(20)]),
      email: new FormControl(null, [Validators.required, Validators.email]),
      password: new FormControl(null, [Validators.required, Validators.minLength(8), Validators.maxLength(50)]),
      firstName: new FormControl(null, [Validators.required, Validators.maxLength(50)]),
      lastName: new FormControl(null, [Validators.required, Validators.maxLength(50)]),
      selectedRole: new FormControl(null, [Validators.required])
    });
  }

  onSubmit() {
    this.submitted = true;
    this.user.userName = this.registrationForm.value.userName;
    this.user.email = this.registrationForm.value.email;
    this.user.password = this.registrationForm.value.password;
    //TODO: find out if this needs to be an array
    this.user.roles = [this.registrationForm.value.selectedRole];
    this.registerUser()
  }

  registerUser() {
    this.authService.signup(this.user)
      .subscribe(user => {
        console.log(user);
        this.isRegistered = true;
      }, error => {
        console.log(error);
        this.errorMessage = error;
        this.isRegistered = false;
      });
  }

  userNameError(): string {
    const errors = this.registrationForm.get("userName").errors;
    if (errors.required)
      return "User name is required";
    if (errors.minlength)
      return "User name must be at least 5 characters long";
    if (errors.maxlength)
      return "User name should not be more than 20 characters long";
    return "";
  }

  passwordError(): string {
    const errors = this.registrationForm.get("password").errors;
    if (errors.required)
      return "Password is required";
    if (errors.minlength)
      return "Password must be at least 8 characters long";
    if (errors.maxlength)
      return "Password should not be more than 50 characters long";
    return "";
  }

  firstNameError(): string {
    const errors = this.registrationForm.get("firstName").errors;
    if (errors.required)
      return "First name is required";
    if (errors.maxlength)
      return "First name should not be more than 50 characters long";
    return "";
  }

  lastNameError(): string {
    const errors = this.registrationForm.get("firstName").errors;
    if (errors.required)
      return "Last name is required";
    if (errors.maxlength)
      return "Last name should not be more than 50 characters long";
    return "";
  }
}
