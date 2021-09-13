import {Component} from '@angular/core';
import {formatDate } from '@angular/common';

export interface PatientDetails{
  arrival_date_time: Date;
  arrival_room: string;
  purpose_of_visit: string;
  readmission: boolean;
  patient_name: string;
  sex: string;
  origin_of_patient: string;
  ventilator: boolean;
  life_saving_device: string;
  transfer_location: string;
}

const TEST_DATA: PatientDetails[] = [
  {
    arrival_date_time: new Date(),
    arrival_room: "MICU 6",
    purpose_of_visit: "Medical",
    readmission: false,
    patient_name: "John Doe",
    sex: "Male",
    origin_of_patient: "Emergency Room",
    ventilator: true,
    life_saving_device: "Balloon Pump",
    transfer_location: "I.M.C.U."
  }
]

@Component({
  templateUrl: 'ledger.component.html',
  styleUrls:["../app.component.css"]
})
export class LedgerComponent {
  displayedColumns: string[] = ["arrival_date_time", "arrival_room", "purpose_of_visit", "readmission", "patient_name",
    "sex", "origin_of_patient", "ventilator", "life_saving_device", "transfer_location"];
  dataSource = TEST_DATA;
  formatDate = formatDate;
}
