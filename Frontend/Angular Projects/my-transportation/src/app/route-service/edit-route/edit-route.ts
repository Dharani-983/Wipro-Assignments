import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Route } from '../../types';
import { ActivatedRoute, Router } from '@angular/router';
import { Routeservice } from '../../service/route-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-route',
  imports: [FormsModule],
  templateUrl: './edit-route.html',
  styleUrl: './edit-route.css'
})
export class EditRoute implements OnInit{
routeModel: Route = {
    routeId: 0,
    source: '',
    destination: '',
    distanceKm: 0,
    estimatedDurationMin: 0,
    stops: [], 
    createdAt: '',
    updatedAt: ''
  };

id!:number;
 constructor(private activatedRoute:ActivatedRoute, private routeService:Routeservice,private router:Router,private cdr: ChangeDetectorRef){}


  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['id']; //get id from the url
    this.loadRoute();
   
  }
  loadRoute() {
    console.log(this.id);
    this.routeService.getRouteById(this.id).subscribe({
      next: (data)=>{
        console.log(data);
        this.routeModel = data;
        this.cdr.detectChanges();
      },
      error:(err)=>console.error(err)
    });
  }
  onSubmit() {
    this.routeService.updateRoute(this.id, this.routeModel).subscribe({
      next: () => {
        alert("Route updated successfully");
         this.router.navigate(['/route']);
      },
      error: (err)=>{
        console.error(err);
        alert("Failed to update route !");
      }
    })
}
}