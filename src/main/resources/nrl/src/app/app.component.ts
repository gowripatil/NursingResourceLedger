import { Component, OnInit } from '@angular/core';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
/**
 * Interacts with the auth service and session
 * session storage to show correct header tabs
 */
export class AppComponent implements OnInit {

  constructor(private authService: AuthService) { }

  ngOnInit(): void { }

  getUserName(): string {
    return sessionStorage.getItem("username");
  }

  onLogOut(): void {
    this.authService.logout();
  }

  isAdministrator(): boolean {
    return this.authService.isAdministrator();
  }

  loggedIn(): boolean {
    return this.authService.isLoggedIn();
  }
}
