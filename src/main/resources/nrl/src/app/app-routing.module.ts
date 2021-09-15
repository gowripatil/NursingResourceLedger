import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './auth/register/register.component';
import { LoginComponent } from './auth/login/login.component';
import { LedgerComponent } from './ledger';
import { PatientsComponent } from './patients';
import { AuthService } from './services/auth.service';

const routes: Routes = [
    {path: '', redirectTo: 'ledger', pathMatch: 'full'},
    {path: 'login', component: LoginComponent},
    {path: 'createuser', component: RegisterComponent, canActivate: [AuthService]},
    {path: 'ledger', component: LedgerComponent, canActivate: [AuthService]},
    {path: 'patients', component: PatientsComponent, canActivate: [AuthService]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
