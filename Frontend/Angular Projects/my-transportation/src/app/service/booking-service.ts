import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../types';

@Injectable({
  providedIn: 'root'
})
export class Bookingservice {
  
   private apiUrl:string = "http://localhost:1115/api/bookings";

   constructor(private http:HttpClient){}

   
  addBooking(booking:any) : Observable<any> {
    return this.http.post(`${this.apiUrl}`, booking);
  }

  getBookings(): Observable<Booking[]> {
  return this.http.get<Booking[]>(this.apiUrl);
  }
  deleteBooking(id:number|undefined):Observable<string>{
  return this.http.delete(`${this.apiUrl}/${id}`, { responseType: 'text' });
}
  getBookingById(id:number):Observable<any>{
    return this.http.get(`${this.apiUrl}/${id}`);
  }
  updateBooking(id:number,booking:Booking):Observable<any>{
    return this.http.put(`${this.apiUrl}/${id}`,booking);
  }

}