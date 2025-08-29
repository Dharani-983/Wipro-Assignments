import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Driverservice } from '../../service/driver-service';
import { Driver } from '../../types';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-view-driver',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './view-driver.html',
  styleUrls: ['./view-driver.css']
})
export class ViewDriver implements OnInit {

  message = 'hi';
  drivers: Driver[] = [];
  errorMessage = '';
  isLoading = true;

  constructor(
    private driverService: Driverservice,
    private cdr: ChangeDetectorRef,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadDrivers();
  }

  loadDrivers() {
    console.log("Loading Drivers...");

    this.driverService.getDrivers().subscribe({
      next: (data) => {
        console.log("API Response: ", data, Array.isArray(data));
        this.drivers = Array.isArray(data) ? data : [];
        this.cdr.detectChanges();
        console.log("Assigned drivers length:", this.drivers.length);
      },
      error: (err) => {
        this.errorMessage = 'Failed to fetch data..';
        console.error(err);
      }
    });
  }

  deleteDriver(id: number | undefined) {
    if (confirm('Are you sure to delete this driver?')) {
      this.driverService.deleteDriver(id).subscribe({
        next: () => {
          alert('Driver deleted successfully');
          this.loadDrivers();
        },
        error: (err) => {
          console.error(err);
          alert("Failed to delete a driver");
        }
      });
    }
  }

  editDriver(id: number | undefined) {
    this.router.navigate(['/edit-driver', id]);
  }

  onChange() {
    console.log(this.message);
  }
}
