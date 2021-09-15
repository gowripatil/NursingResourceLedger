import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { User } from '../auth/user.model';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { catchError, map } from 'rxjs/operators';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';

const headers = new HttpHeaders().set('Content-Type', 'application/json');
@Injectable({
    providedIn: 'root'
})
export class AuthService implements CanActivate {
    private baseUrl = 'http://localhost:8080/auth/';

    constructor(private http: HttpClient, private router: Router) { }

    signup(user: User): Observable<any> {
        return this.http.post(this.baseUrl + 'signup', user, { headers, responseType: 'text' })
            .pipe(catchError(this.handleError));;
    }

    login(user: string, password: string) {
        return this.http.post<any>(this.baseUrl + 'login',
            { userName: user, password: password }, { headers })
            .pipe(catchError(this.handleError),
                map(userData => {
                    sessionStorage.setItem("username", user);
                    let tokenStr = "Bearer " + userData.token;
                    console.log("Token---  " + tokenStr);
                    sessionStorage.setItem("token", tokenStr);
                    sessionStorage.setItem("roles", JSON.stringify(userData.roles));
                    return userData;
                })
            );
    }

    logout() {
        sessionStorage.clear()
        this.router.navigate(['/login']);
    }

    isLoggedIn(): boolean {
        return sessionStorage.getItem('username') !== null;
    }

    isAdministrator(): boolean {
        return sessionStorage.getItem('roles').includes("ROLE_ADMIN");
    }

    private handleError(httpError: HttpErrorResponse) {
        let message: string = '';

        if (httpError.error instanceof ProgressEvent) {
            console.log('in progrss event')
            message = "Network error";
        }
        // else if (httpError.error instanceof ErrorEvent) {
        //   // A client-side or network error occurred. Handle it accordingly.
        //   message = httpError.error.message;
        //   console.error('An error occurred:', httpError.error.message);
        // } 
        else {
            message = httpError.error.message;
            // The backend returned an unsuccessful response code.
            // The response body may contain clues as to what went wrong.
            console.error(
                `Backend returned code ${httpError.status}, ` +
                `body was: ${httpError.error}`);
        }
        // Return an observable with a user-facing error message.
        return throwError(message);
    }

    canActivate(route: ActivatedRouteSnapshot): boolean {
        switch (route.routeConfig.path) {
            case "createuser": {
                if (this.isLoggedIn() && this.isAdministrator()) {
                    return true;
                } else {
                    this.router.navigate(['login']);
                    return false;
                }
            }
            case "ledger":
            case "patients": {
                if (this.isLoggedIn()) {
                    return true;
                } else {
                    this.router.navigate(['login']);
                    return false;
                }
            }
        }
        return false;
    }
}
