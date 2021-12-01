import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CarparkingListComponent } from './carparking-list/carparking-list.component';
const routes: Routes = [
{path: 'api/carparking', component: CarparkingListComponent},
];
@NgModule({
imports: [RouterModule.forChild(routes)],
exports: [RouterModule]
})
export class CarparkingRoutingModule { }