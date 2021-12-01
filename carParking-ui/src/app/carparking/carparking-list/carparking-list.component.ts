import { Component, OnInit, Input } from '@angular/core';
import { Carparking } from "../carparking";
import { CarparkingService } from "../carparking.service";
import { Router } from '@angular/router';
@Component({
 selector: 'app-carparking-list',
 templateUrl: './carparking-list.component.html',
 styleUrls: ['./carparking-list.component.css'],
 providers: [CarparkingService]
})
export class EmployeeListComponent implements OnInit {
private carparkings: Carparking[];
constructor(private router: Router,
 private carparkingService: CarparkingService) { }
ngOnInit() {
 this.getAllCarparking();
 }
getAllCarparking() {
 this.carparkingService.findAll().then(
 carparkings => {
 this.carparkings = carparkings;
 },
 err => {
 console.log(err);
 }
);
 }
createCarparking() {
 let slotId = (<HTMLInputElement>document.getElementById('slotId')).value;
 let registrationNumber = (<HTMLInputElement>document.getElementById('registrationNumber')).value;
 let parkingTime_Hours = (<HTMLInputElement>document.getElementById('parkingTime_Hours')).value;
 let carparking = new Carparking(0, Number(slotId), registrationNumber, Number(parkingTime_Hours));
 this.carparkingService.createCarparking(carparking).then(
 carparkings => {
    this.carparkings = carparkings;
  },
 err => {
 console.log(err);
 }
 );
 }
deleteCarparking(carparking: Carparking) {
 this.carparkingService.deleteCarparkingBySlotId(carparking.slotId).then(
 carparkings => {
    this.carparkings = carparkings;
  },
 err => {
 console.log(err);
 }
 );
 }
}
