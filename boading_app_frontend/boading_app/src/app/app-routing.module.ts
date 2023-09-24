import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BoardingMatesComponent } from './Pages/boarding-mates/boarding-mates.component';
import { HomeComponent } from './Pages/home/home.component';
import { NavbarComponent } from './Common/navbar/navbar.component';
import { PaymentsComponent } from './Pages/payments/payments.component';
import { MonthsComponent } from './Pages/months/months.component';
import { ProfilesComponent } from './Pages/profiles/profiles.component';
import { Profile2Component } from './Pages/profile2/profile2.component';
import { LoginComponent } from './Common/login/login.component';
import { RegisterComponent } from './Common/register/register.component';
import { InTheBoardingComponent } from './Pages/in-the-boarding/in-the-boarding.component';
import { KeyAvailableComponent } from './Pages/key-available/key-available.component';
import { Test2Component } from './Pages/test2/test2.component';

const routes: Routes = [

 { path:'boardingmates',component:BoardingMatesComponent},
//  {path:'home',component:HomeComponent},
 {path:'navbar',component:NavbarComponent},
 {path:'payments/:userId',component:PaymentsComponent},
 {path:'months',component:MonthsComponent},
 {path:'p',component:ProfilesComponent},
 {path:'pp',component:Profile2Component},
 {path: '',component: LoginComponent},
 {path:'intheboarding',component:InTheBoardingComponent},
 {path:'keyavailable',component:KeyAvailableComponent},
{path:'a',component:Test2Component},
{path: 'home/:id',component: HomeComponent},
{path: 'register',component: RegisterComponent},
{path:'month/:monthName',component:MonthsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
