import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Router }            from '@angular/router';
import { Http, Headers, RequestOptions } from '@angular/http';


import 'rxjs/add/operator/toPromise';

@Component({
  selector: 'my-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: [ './dashboard.component.css' ]
})
export class DashboardComponent implements OnInit {

  ngOnInit() {
    
  }
}
