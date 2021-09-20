import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Ledger } from '../ledger/ledger.model';

const headers = new HttpHeaders().set('Content-Type', 'application/json');

@Injectable({
  providedIn: 'root',
})
/**
 * Interacts with the ledger api to handle ledger
 *  record add and retrieve functionality
 */
export class LedgerService {

  private baseUrl = 'http://localhost:8080/ledger/';

  constructor(private http: HttpClient) { }

  getAllRecords(): Observable<any> {
    return this.http.get(this.baseUrl + 'all', { responseType: 'text' })
      .pipe(catchError(this.handleError));
  }

  addRecord(record: Ledger): Observable<any> {
    return this.http.post(this.baseUrl + 'add',
      record, { headers, responseType: 'text' })
      .pipe(catchError(this.handleError));
  }

  private handleError(httpError: HttpErrorResponse) {
    let message: string = '';
    if (httpError.error instanceof ProgressEvent) {
      console.log('in progress event');
      message = "Network error";
    } else {
      message = JSON.parse(httpError.error).message;
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${httpError.status}, ` +
        `body was: ${httpError.error}`);
    }
    // Return an observable with a user-facing error message.
    return throwError('Something bad happened; please try again later. Error Message- ' + message);
  }
}
