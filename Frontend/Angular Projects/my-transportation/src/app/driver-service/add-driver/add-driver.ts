import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Driverservice } from '../../service/driver-service';
import { Router } from '@angular/router';
import { Driver } from '../../types';
import { availabilityStatus } from '../../enum';

@Component({
  selector: 'app-add-driver',
  imports: [FormsModule],
  templateUrl: './add-driver.html',
  styleUrl: './add-driver.css'
})
export class AddDriver {
  driver: Driver = {
    name: '',
    licenseNumber: '',
    phoneNumber: '',
    email: '',
    availabilityStatus: availabilityStatus.AVAILABLE,
    vehicleId: 0,
    createdAt: '',
    updatedAt: ''
  };

  message = '';

  constructor(private driverService: Driverservice, private router: Router) {}

  // utility function
  private formatDateTime(value: string): string {
    // If input is like "2025-08-15T17:30" → "2025-08-15 17:30:00"
    return value ? value.replace("T", " ") + ":00" : '';
  }

  async onSubmit() {
    console.log("Submitting driver:", this.driver);

    // create a copy with formatted dates
    const driverToSend: Driver = {
      ...this.driver,
      createdAt: this.formatDateTime(this.driver.createdAt),
      updatedAt: this.formatDateTime(this.driver.updatedAt)
    };

    this.driverService.addDriver(driverToSend).subscribe({
      next: (response) => {
        console.log("Driver saved:", response);
        this.message = "Driver added successfully!";
        this.router.navigate(['/driver']);
      },
      error: (err) => {
        console.error("Error while saving driver:", err);
        this.message = "Error adding driver!";
      }
    });
  }
}