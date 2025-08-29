import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vehicle } from '../types';

@Injectable({
  providedIn: 'root'
})
export class Vehicleservice {
  
   private apiUrl:string = "http://localhost:1112/api/vehicles";

   constructor(private http:HttpClient){}

   
  addVehicle(vehicle:any) : Observable<any> {
    return this.http.post(`${this.apiUrl}`, vehicle);
  }

  getVehicles(): Observable<Vehicle[]> {
  return this.http.get<Vehicle[]>(this.apiUrl);
  }
  deleteVehicle(id:number|undefined):Observable<any>{
    return this.http.delete(`${this.apiUrl}/${id}`, { responseType: 'text' });
  }
  getVehicleById(id:number):Observable<any>{
    return this.http.get(`${this.apiUrl}/${id}`);
  }
  updateVehicle(id:number,vehicle:Vehicle):Observable<any>{
    return this.http.put(`${this.apiUrl}/${id}`,vehicle);
  }

}