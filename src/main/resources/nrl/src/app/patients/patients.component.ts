import {Component} from '@angular/core';
import { Ledger } from '../ledger/ledger.model';
import { LedgerService } from '../services/ledger.service';

@Component({
  templateUrl: 'patients.component.html',
  styleUrls:["../app.component.css"]
})
export class PatientsComponent {

  _ledgerService;

  constructor(ledgerService: LedgerService) { 
    this._ledgerService = ledgerService;
  }

  onSubmit(): void {
    // need to pull data from page
    let record = new Ledger((new Date), "A3", "Chest pains", false, "John Doe", "Male", "Jamaica", false, "none", "");
    this._ledgerService.addRecord(record).subscribe(
      response => {
        // success case - show success message
        // console.log(response);
      },
      error => {
        // failure case - show failure message
        console.error(error);
      }
    )
  }

}
