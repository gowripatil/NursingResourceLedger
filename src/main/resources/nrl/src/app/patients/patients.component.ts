import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  templateUrl: 'patients.component.html',
  styleUrls:["../app.component.css"]
})
export class PatientsComponent implements OnInit{
  patients_form: FormGroup;

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
  onSubmit() {
    //TODO: fill later, and remember to combine date with time and first name with last name
  }
}
