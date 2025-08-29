import { Routes } from '@angular/router';
import { Menu } from './menu/menu';
import { ViewVehicle } from './vehicle-service/view-vehicle/view-vehicle';
import { AddVehicle } from './vehicle-service/add-vehicle/add-vehicle';
import { EditVehicle } from './vehicle-service/edit-vehicle/edit-vehicle';
import { ViewRoute } from './route-service/view-route/view-route';
import { AddRoute } from './route-service/add-route/add-route';
import { EditRoute } from './route-service/edit-route/edit-route';
import { ViewDriver } from './driver-service/view-driver/view-driver';
import { EditDriver } from './driver-service/edit-driver/edit-driver';
import { AddDriver } from './driver-service/add-driver/add-driver';
import { ViewBooking } from './booking-service/view-booking/view-booking';
import { AddBooking } from './booking-service/add-booking/add-booking';
import { EditBooking } from './booking-service/edit-booking/edit-booking';

export const routes: Routes = [
    {path:'',component:Menu},
    {path:'vehicle', component:ViewVehicle},
    {path:'add-vehicle',component:AddVehicle},
    {path:'edit-vehicle/:id',component:EditVehicle},

    {path:'route', component:ViewRoute},
    {path:'add-route',component:AddRoute},
    {path:'edit-route/:id',component:EditRoute},

    {path:'driver', component:ViewDriver},
    {path:'add-driver',component:AddDriver},
    {path:'edit-driver/:id',component:EditDriver},

    {path:'booking', component:ViewBooking},
    {path:'add-booking',component:AddBooking},
    {path:'edit-booking/:id',component:EditBooking},
]