import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Pages/home/home.component';
import { BoardingMatesComponent } from './Pages/boarding-mates/boarding-mates.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { NavbarComponent } from './Common/navbar/navbar.component';
import { MatBadgeModule } from '@angular/material/badge';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';
import { MatTabsModule } from '@angular/material/tabs';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { PaymentsComponent } from './Pages/payments/payments.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { DatePipe } from '@angular/common';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import { MonthsComponent } from './Pages/months/months.component';
import { ProfilesComponent } from './Pages/profiles/profiles.component';
import { Profile2Component } from './Pages/profile2/profile2.component';
import { LoginComponent } from './Common/login/login.component';
import { RegisterComponent } from './Common/register/register.component';
import { TestComponent } from './Pages/test/test.component';
import { InTheBoardingComponent } from './Pages/in-the-boarding/in-the-boarding.component';
import { KeyAvailableComponent } from './Pages/key-available/key-available.component';
import { Test2Component } from './Pages/test2/test2.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BoardingMatesComponent,
    NavbarComponent,
    PaymentsComponent,
    MonthsComponent,
    ProfilesComponent,
    Profile2Component,
    LoginComponent,
    RegisterComponent,
    TestComponent,
    InTheBoardingComponent,
    KeyAvailableComponent,
    Test2Component,
 
    
  ],
  imports: [
    BrowserModule,
    
    BrowserAnimationsModule,
    MatCardModule,
    MatSlideToggleModule,
    MatBadgeModule,
    MatIconModule,
    MatDividerModule,
    MatButtonModule,
    MatTabsModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    MatDatepickerModule,
    MatAutocompleteModule
    
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }