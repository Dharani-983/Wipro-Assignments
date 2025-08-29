import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, Input, OnInit } from '@angular/core';
import { Vehicleservice } from '../../service/vehicle-service';
import { Vehicle } from '../../types';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-view-vehicle',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './view-vehicle.html',   // ✅ Angular CLI convention
  styleUrls: ['./view-vehicle.css']     // ✅ Angular CLI convention
})
export class ViewVehicle implements OnInit {

  message='hi';

  vehicles: Vehicle[] = [];
  errorMessage = '';
  isLoading = true;

  @Input() vehicle!: Vehicle;

  constructor(private vehicleService: Vehicleservice,private cdr: ChangeDetectorRef,private router:Router) {}

  ngOnInit(): void {
    this.loadVehicles();
  }

  loadVehicles() {
  console.log("Loading Vehicles...");

  this.vehicleService.getVehicles().subscribe({
    next: (data) => {
      console.log(data)
      console.log("API Response: ", data, Array.isArray(data));
      
      this.vehicles = [];
      if (Array.isArray(data)) {
        console.log("inside if")
        data.forEach(item => {this.vehicles.push(item); console.log("pushing ")});
        this.cdr.detectChanges();

      }

      console.log("Assigned vehicles length:", this.vehicles.length);
    },
    error: (err) => {
      this.errorMessage = 'Failed to fetch data..';
      console.error(err);
    }
  });
}

deleteVehicle(id: number|undefined) {
  if(confirm('Are you sure to delete this vehicle?')){
    this.vehicleService.deleteVehicle(id).subscribe({
      next: () =>{
        alert('Vehicle deleted successfully');
        this.loadVehicles();
      },
      error:(err) =>{
        console.error(err);
        alert("Failed to delete a vehicle");
      }
    })
  }
}
editVehicle(id: number|undefined) {
  console.log(" inside edit vehicle")
  this.router.navigate(['/edit-vehicle',id]);
}
onChange() {
  console.log(this.message);
}
}