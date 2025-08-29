import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Driver } from '../../types';
import { ActivatedRoute, Router } from '@angular/router';
import { Driverservice } from '../../service/driver-service';
import { FormsModule } from '@angular/forms';
import { availabilityStatus } from '../../enum';

@Component({
  selector: 'app-edit-driver',
  imports: [FormsModule],
  templateUrl: './edit-driver.html',
  styleUrl: './edit-driver.css'
})
export class EditDriver implements OnInit{
driver:Driver= {
  driverId:0,
  name:'',
  licenseNumber:'',
  phoneNumber:'',
  email:'',
  availabilityStatus:availabilityStatus.AVAILABLE,
  vehicleId:0,
  createdAt:'',
  updatedAt:''
};
id!:number;
 constructor(private route:ActivatedRoute, private driverService:Driverservice,private router:Router,private cdr: ChangeDetectorRef){}


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']; //get id from the url
    this.loadDriver();
   
  }
  loadDriver() {
    console.log(this.id);
    this.driverService.getDriverById(this.id).subscribe({
      next: (data)=>{
        console.log(data);
        this.driver = data;
        this.cdr.detectChanges();
      },
      error:(err)=>console.error(err)
    });
  }
  onSubmit() {
    this.driverService.updateDriver(this.id, this.driver).subscribe({
      next: () => {
        alert("Driver updated successfully");
         this.router.navigate(['/driver']);
      },
      error: (err)=>{
        console.error(err);
        alert("Failed to update driver!");
      }
    })
}
}