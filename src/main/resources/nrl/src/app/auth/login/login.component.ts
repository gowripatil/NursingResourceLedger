import {Component, OnInit} from "@angular/core";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthService} from "src/app/services/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ["../../app.component.css"]
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor(private authService: AuthService, private router: Router) {
  }

  submitted = false;
  errorMessage = '';
  isLoggedin = false;
  isLoginFailed = false;

  ngOnInit() {
    this.loginForm = new FormGroup({
      userName: new FormControl(null, Validators.required),
      password: new FormControl(null, Validators.required),
    });
  }

  onSubmit() {
    this.submitted = true;
    this.authService.login(this.loginForm.value.userName, this.loginForm.value.password).subscribe(
      data => {
        this.isLoggedin = true
        this.router.navigate(['']);
      },
      error => {
        console.log(error);
        this.errorMessage = error;
        this.isLoggedin = false;
        this.isLoginFailed = true;
      }
    );
  }

  userNameError(): string {
    if (this.loginForm.get("userName").errors.required)
      return "User name is required";
    return "";
  }

  passwordError(): string {
    if (this.loginForm.get("password").errors.required)
      return "Password is required";
    return "";
  }
}
