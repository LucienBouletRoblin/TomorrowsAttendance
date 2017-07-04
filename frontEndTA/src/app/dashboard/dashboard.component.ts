import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Router } from '@angular/router';
import { Http, Headers, RequestOptions } from '@angular/http';
import { Service } from '../model/Service';
import {SpinnerModule} from 'primeng/primeng';
import {CalendarModule} from 'primeng/primeng';
import { BrowserModule } from '@angular/platform-browser';

import { ServiceService } from '../services/service.service'


import 'rxjs/add/operator/toPromise';

@Component({
  selector: 'my-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: [ './dashboard.component.css' ]
})
export class DashboardComponent implements OnInit {

  serviceEntry = new Service();

   constructor(private http: Http,
    private serviceService : ServiceService) { }

  ngOnInit() {

  }

  onSubmit(){
    alert('submit');

    this.serviceService.createService(this.serviceEntry);

  }
}
