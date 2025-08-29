import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Route } from '../types';

@Injectable({
  providedIn: 'root'
})
export class Routeservice {
  
   private apiUrl:string = "http://localhost:1113/api/routes";

   constructor(private http:HttpClient){}

   
  addRoute(route:any) : Observable<any> {
    return this.http.post(`${this.apiUrl}`, route);
  }

  getRoutes(): Observable<Route[]> {
  return this.http.get<Route[]>(this.apiUrl);
  }
  deleteRoute(id:number|undefined):Observable<string>{
  return this.http.delete(`${this.apiUrl}/${id}`, { responseType: 'text' });
}
  getRouteById(id:number):Observable<any>{
    return this.http.get(`${this.apiUrl}/${id}`);
  }
  updateRoute(id:number,route:Route):Observable<any>{
    return this.http.put(`${this.apiUrl}/${id}`,route);
  }

}