import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Vehicleservice } from '../../service/vehicle-service';
import { Router } from '@angular/router';
import { Vehicle } from '../../types';
import { vehicleStatus, vehicleType } from '../../enum';

@Component({
  selector: 'app-add-vehicle',
  imports: [FormsModule],
  templateUrl: './add-vehicle.html',
  styleUrl: './add-vehicle.css'
})
export class AddVehicle {
  vehicle:Vehicle = {
    vehicleNumber:'',
    capacity:0,
    vehicleType:vehicleType.CAR,
    vehicleStatus:vehicleStatus.ON_TRIP,
    createdAt:'',
    updatedAt:''
  };
  message='';
  
  constructor(private vehicleService:Vehicleservice,private router:Router){}

  async onSubmit() {
    console.log("Submitting vehicle:", this.vehicle);

    this.vehicleService.addVehicle(this.vehicle).subscribe({
      next: (response) => {
        console.log("Vehicle saved:", response);
        this.message = "Vehicle added successfully!";
        this.router.navigate(['/vehicle']);
      },
      error: (err) => {
        console.error("Error while saving vehicle:", err);
        this.message = "Error adding vehicle!";
      }
    });
  }
}