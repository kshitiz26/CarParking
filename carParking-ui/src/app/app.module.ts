import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CarparkingQueueComponent } from './carparking/carparking-queue/carparking-queue.component';
import { CarparkingListComponent } from './carparking/carparking-list/carparking-list.component';
import { CarparkingModule } from './carparking/carparking.module';

@NgModule({
  declarations: [
    AppComponent,
    CarparkingQueueComponent,
    CarparkingListComponent,
    CarparkingModule
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
