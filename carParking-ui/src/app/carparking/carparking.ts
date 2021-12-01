export class Carparking{
    reservationId: number;
    slotId: number;
    registrationNumber: string;
    parkingTime_Hours: number;
    constructor(reservationId: number, slotId: number, registrationNumber: string, parkingTime_Hours: number){
    this.reservationId = reservationId;
    this.slotId = slotId;
    this.registrationNumber = registrationNumber;
    this.parkingTime_Hours = parkingTime_Hours;
    }
    }