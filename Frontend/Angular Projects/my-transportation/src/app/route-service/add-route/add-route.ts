import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Routeservice } from '../../service/route-service';
import { Router } from '@angular/router';
import { Route } from '../../types';

@Component({
  selector: 'app-add-route',
  imports: [FormsModule],
  templateUrl: './add-route.html',
  styleUrl: './add-route.css'
})
export class AddRoute {
  route: Route = {
    source: '',
    destination: '',
    distanceKm: 0,
    estimatedDurationMin: 0,
    stops: [],
    createdAt: '',
    updatedAt: ''
  };

  stopsInput: string = ''; // user enters comma-separated stops
  message = '';

  constructor(private routeService: Routeservice, private router: Router) {}

  // format datetime-local into backend expected format
  private formatDateTime(value: string): string {
    return value ? value.replace("T", " ") + ":00" : '';
  }

  onSubmit() {
    console.log("Submitting route:", this.route);

    // Format fields properly before sending
    const routeToSend: Route = {
      ...this.route,
      stops: this.stopsInput
        ? this.stopsInput.split(',').map(stop => stop.trim())
        : [],
      // createdAt: this.formatDateTime(this.route.createdAt),
      // updatedAt: this.formatDateTime(this.route.updatedAt)
    };

    console.log("Formatted payload:", routeToSend);

    this.routeService.addRoute(routeToSend).subscribe({
      next: (response) => {
        console.log("Route saved:", response);
        this.message = "Route added successfully!";
        this.router.navigate(['/route']);
      },
      error: (err) => {
        console.error("Error while saving route:", err);
        this.message = "Error adding route!";
      }
    });
  }
}