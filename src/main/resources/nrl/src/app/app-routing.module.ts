import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './auth/register/register.component';
import { LoginComponent } from './auth/login/login.component';
import { LedgerComponent } from './ledger';
import { PatientsComponent } from './patients';

const routes: Routes = [
    {path: 'signup', component: RegisterComponent},
    {path: 'login', component: LoginComponent},
    {path: 'ledger', component: LedgerComponent},
    {path: 'patients', component: PatientsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
