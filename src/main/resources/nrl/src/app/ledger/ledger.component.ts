import {Component} from '@angular/core';
import {formatDate } from '@angular/common';
import { LedgerService } from '../services/ledger.service';

@Component({
  templateUrl: 'ledger.component.html',
  styleUrls:["../app.component.css"]
})
export class LedgerComponent {
  
  displayedColumns: string[] = ["arrivalDate", "arrivalRoom", "purposeOfVisit", "readmission", "patientName",
    "sex", "patientOrigin", "isVentilatorSupport", "lifeSavingDevices", "transferLocation"];
  dataSource;
  formatDate = formatDate;

  constructor(ledgerService: LedgerService) {
    ledgerService.getAllRecords().subscribe(
      response => {
        this.dataSource = JSON.parse(response);
      },
      error => {
        console.error(error);
      }
    )
  }
}
