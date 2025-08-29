import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Vehicle } from '../../types';
import { ActivatedRoute, Router } from '@angular/router';
import { Vehicleservice } from '../../service/vehicle-service';
import { FormsModule } from '@angular/forms';
import { vehicleStatus, vehicleType } from '../../enum';

@Component({
  selector: 'app-edit-vehcile',
  imports: [FormsModule],
  templateUrl: './edit-vehicle.html',
  styleUrl: './edit-vehicle.css'
})
export class EditVehicle implements OnInit{
vehicle:Vehicle = {
  vehicleId:0,
  vehicleNumber:'',
  capacity:0,
  vehicleType:vehicleType.CAR,
  vehicleStatus:vehicleStatus.ON_TRIP,
  createdAt:'',
  updatedAt:''
};
id!:number;
 constructor(private route:ActivatedRoute, private vehicleService:Vehicleservice,private router:Router,private cdr: ChangeDetectorRef){}


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']; //get id from the url
    this.loadVehicle();
   
  }
  loadVehicle() {
    console.log(this.id);
    this.vehicleService.getVehicleById(this.id).subscribe({
      next: (data)=>{
        console.log(data);
        this.vehicle = data;
        this.cdr.detectChanges();
      },
      error:(err)=>console.error(err)
    });
  }
  onSubmit() {
    this.vehicleService.updateVehicle(this.id, this.vehicle).subscribe({
      next: () => {
        alert("Vehicle updated successfully");
         this.router.navigate(['/vehicle']);
      },
      error: (err)=>{
        console.error(err);
        alert("Failed to update vehicle !");
      }
    })
}
  
 
}