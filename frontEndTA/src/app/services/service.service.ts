import { Injectable } from '@angular/core';
import { Headers, Http, RequestOptions } from '@angular/http';
import { Service } from '../model/Service'

@Injectable()
export class ServiceService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers: this.headers});

  private url = 'http://localhost:9090/TomorrowsAttendance/rs/service/';


  constructor(private http: Http) { }

    createService(service: Service): Promise<Service> {
    return this.http
      .post(this.url, JSON.stringify(service), {headers: this.headers})
      .toPromise()
      .then(res=>this.http.get(res.url).toPromise().then(response => response.json() as Service))
      .catch(this.handleError);
  } 

  getServiceList(): Promise<Service[]> {
    return this.http.get(this.url+"allservices/", this.options)
               .toPromise()
               .then(response => response.json() as Service[])
               .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
