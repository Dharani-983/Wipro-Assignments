import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, Input, OnInit } from '@angular/core';
import { Routeservice } from '../../service/route-service';
import { Route } from '../../types';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-view-route',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './view-route.html',   // ✅ Angular CLI convention
  styleUrls: ['./view-route.css']     // ✅ Angular CLI convention
})
export class ViewRoute implements OnInit {

  message='hi';

  routes: Route[] = [];
  errorMessage = '';
  isLoading = true;

  // @Input() vehicle!: Vehicle;

  constructor(private routeService: Routeservice,private cdr: ChangeDetectorRef,private router:Router) {}

  ngOnInit(): void {
    this.loadRoutes();
  }

  loadRoutes() {
  console.log("Loading Routes...");

  this.routeService.getRoutes().subscribe({
    next: (data) => {
      console.log(data)
      console.log("API Response: ", data, Array.isArray(data));
      
      this.routes = [];
      if (Array.isArray(data)) {
        console.log("inside if")
        data.forEach(item => {this.routes.push(item); console.log("pushing ")});
        this.cdr.detectChanges();

      }

      console.log("Assigned vehicles length:", this.routes.length);
    },
    error: (err) => {
      this.errorMessage = 'Failed to fetch data..';
      console.error(err);
    }
  });
}

deleteRoute(id: number | undefined) {
    if (confirm('Are you sure to delete this route?')) {
      this.routeService.deleteRoute(id).subscribe({
        next: () => {
          alert('Route deleted successfully');
          this.loadRoutes();
        },
        error: (err) => {
          console.error(err);
          alert("Failed to delete a route");
        }
      });
    }
  }
editRoute(id: number|undefined) {
  console.log(" inside edit route")
  this.router.navigate(['/edit-route',id]);
}
onChange() {
  console.log(this.message);
}
}