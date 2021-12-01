import { Injectable } from '@angular/core';
import { Carparking } from "./carparking";
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable()
export class CarparkingService {
private apiUrl = '/api/carParking';
constructor(private http: Http) {
 }
findAll(): Promise<Array<Carparking>> {
 return this.http.get(this.apiUrl)
 .toPromise()
 .then(response => response.json() as Carparking[])
 .catch(this.handleError);
 }
createCarparking(carparking: Carparking): Promise<Array<Carparking>> {
 let carHeaders = new Headers({ 'Content-Type': 'application/json' });
 return this.http.post(this.apiUrl, JSON.stringify(carparking), { headers: carHeaders })
 .toPromise()
 .then(response => response.json() as Carparking[])
 .catch(this.handleError);
 }
deleteCarparkingBySlotId(slotId: number): Promise<Array<Carparking>> {
 const url = `${this.apiUrl}/${slotId}`;
 return this.http.delete(url)
 .toPromise()
 .then(response => response.json() as Carparking[])
 .catch(this.handleError);
 }
private handleError(error: any): Promise<Array<any>> {
 console.error('An error occurred', error);
 return Promise.reject(error.message || error);
 }
}
