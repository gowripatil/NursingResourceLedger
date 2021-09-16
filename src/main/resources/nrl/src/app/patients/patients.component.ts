import { Ledger } from '../ledger/ledger.model';
import { LedgerService } from '../services/ledger.service';
import {Component, Input, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  templateUrl: 'patients.component.html',
  styleUrls:["../app.component.css"]
})
export class PatientsComponent implements OnInit{
  
  _ledgerService;
  patients_form: FormGroup;
  selectedArrivalRoom: string;
  selectedPurpose: string;
  selectedSex: string;
  selectedOrigin: string;
  selectedLSD: string;
  selectedTransferLocation: string;
  isVentilator: boolean;
  isReadmission: boolean;

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
    this.isReadmission = this.patients_form.value['readmission'] ?? false;
    this.isVentilator = this.patients_form.value['ventilator'] ?? false;
    // need to pull data from page
    let record = new Ledger((new Date), this.selectedArrivalRoom, this.selectedPurpose, 
                            this.isReadmission, "John Doe", this.selectedSex, 
                            this.selectedOrigin, this.isVentilator, this.selectedLSD, 
                            this.selectedTransferLocation);
    console.log(record);
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
