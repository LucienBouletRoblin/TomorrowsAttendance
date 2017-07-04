import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { HttpModule }    from '@angular/http';

import { AppComponent }         from './app.component';
import { DashboardComponent }   from './dashboard/dashboard.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {DropdownModule} from 'primeng/primeng';
import {RadioButtonModule} from 'primeng/primeng';
import {SpinnerModule} from 'primeng/primeng';
import {CalendarModule} from 'primeng/primeng';

import { ServiceService} from './services/service.service'

import { AppRoutingModule } from './app-routing.module';

@NgModule({
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    RadioButtonModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    SpinnerModule,
    CalendarModule
  ],
  declarations: [
    AppComponent,
    DashboardComponent
  ],
  providers: [ ServiceService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
