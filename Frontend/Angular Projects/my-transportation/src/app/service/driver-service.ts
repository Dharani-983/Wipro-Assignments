import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Driver } from '../types';

@Injectable({
  providedIn: 'root'
})
export class Driverservice {
  
   private apiUrl:string = "http://localhost:1114/api/drivers";

   constructor(private http:HttpClient){}

   
  addDriver(driver:any) : Observable<any> {
    return this.http.post(`${this.apiUrl}`, driver);
  }

  getDrivers(): Observable<Driver[]> {
  return this.http.get<Driver[]>(this.apiUrl);
  }
  deleteDriver(id:number|undefined):Observable<string>{
  return this.http.delete(`${this.apiUrl}/${id}`, { responseType: 'text' });
}
  getDriverById(id:number):Observable<any>{
    return this.http.get(`${this.apiUrl}/${id}`);
  }
  updateDriver(id:number,driver:Driver):Observable<any>{
    return this.http.put(`${this.apiUrl}/${id}`,driver);
  }

}