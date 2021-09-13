import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './auth/register/register.component';
import { HomeComponent } from './home.component';
import { LoginComponent } from './auth/login/login.component';
import { AllUsersComponent } from './users/allusers.component';
import { LedgerComponent } from './ledger';
import { PatientsComponent } from './patients';
import { UserContent } from './users/usercontent.component';
import { AdminContent } from './users/admincontent.component';

const routes: Routes = [
    {path: 'signup', component: RegisterComponent},
    {path: 'login', component: LoginComponent},
    {path: 'home', component: HomeComponent},
    {path: 'allusers', component: AllUsersComponent},
    {path: 'ledger', component: LedgerComponent},
    {path: 'patients', component: PatientsComponent},
    {path: 'usercontent', component: UserContent},
    {path: 'admincontent', component: AdminContent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
