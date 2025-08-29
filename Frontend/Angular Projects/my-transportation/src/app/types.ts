import { availabilityStatus, bookingStatus, vehicleStatus, vehicleType } from "./enum";

export interface Vehicle{
    vehicleId?:number,
    vehicleNumber:string,
    capacity:number,
    vehicleType:vehicleType,
    vehicleStatus:vehicleStatus,
    createdAt:string,
    updatedAt:string
}

export enum VehicleType {
  TRUCK = 'TRUCK',
  BUS = 'BUS',
  CAR = 'CAR',
  VAN = 'VAN'
}

export enum VehicleStatus {
  ACTIVE = 'ACTIVE',
  INACTIVE = 'INACTIVE',
  ON_TRIP = 'ON_TRIP'
}

export interface Route{
  routeId?:number,
  source:string,
  destination:string,
  distanceKm:number,
  estimatedDurationMin:number,
  stops:string[],
  createdAt:string,
  updatedAt:string
}

export interface Driver{
  driverId?:number,
  name:string,
  licenseNumber:string,
  phoneNumber:string,
  email:string,
  availabilityStatus:availabilityStatus,
  vehicleId:number,
  createdAt:string,
  updatedAt:string
}

export enum AvailabilityStatus {
  AVAILABLE = 'AVAILABLE',
  ON_DUTY = 'ON_DUTY',
  OFF_DUTY = 'OFF_DUTY'
}

export interface Booking{
  bookingId?:number,
  customerName:string,
  contactNumber:string,
  routeId:number,
  vehicleId:number,
  driverId:number,
  bookingStatus:bookingStatus,
  bookingTime: string;  
  startTime: string;
  endTime: string;      
  createdAt: string;
  updatedAt: string; 
}

export enum BookingStatus {
  PENDING = 'PENDING',
  CONFIRMED = 'CONFIRMED',
  CANCELLED = 'CANCELLED',
  COMPLETED = 'COMPLETED'
}
