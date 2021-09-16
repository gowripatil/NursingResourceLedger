import { Ledger } from '../ledger/ledger.model';
import { LedgerService } from '../services/ledger.service';
import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {formatDate} from "@angular/common";

@Component({
  templateUrl: 'patients.component.html',
  styleUrls:["../app.component.css"]
})
export class PatientsComponent implements OnInit{

  _ledgerService;
  patients_form: FormGroup;

  constructor(ledgerService: LedgerService) {
    this._ledgerService = ledgerService;
  }

  ngOnInit(): void {
    this.patients_form = new FormGroup({
      arrival_date: new FormControl(null, [Validators.required]),
      arrival_time: new FormControl(null, [Validators.required]),
      arrival_room: new FormControl(null, [Validators.required]),
      purpose_of_visit: new FormControl(null, [Validators.required]),
      readmission: new FormControl(),
      first_name: new FormControl(null, [Validators.required]),
      last_name: new FormControl(null, [Validators.required]),
      sex: new FormControl(null, [Validators.required]),
      origin_of_patient: new FormControl(null, [Validators.required]),
      ventilator: new FormControl(),
      life_saving_device: new FormControl(null, [Validators.required]),
      transfer_location: new FormControl(null, [Validators.required])
    });
  }

  onSubmit(): void {
    debugger;
    const date = this.patients_form.get("arrival_date").value;
    const time = this.patients_form.get("arrival_time").value;
    const time_arr = time.split(":")
    const arrivalDate = new Date(Number(date.getFullYear()), Number(date.getMonth()), Number(date.getDate()), Number(time_arr[0]), Number(time_arr[1]));
    const patientName = this.patients_form.get("first_name").value + " " + this.patients_form.get("last_name").value;
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
