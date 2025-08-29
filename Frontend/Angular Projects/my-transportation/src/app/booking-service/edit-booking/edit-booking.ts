import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Booking } from '../../types';
import { ActivatedRoute, Router } from '@angular/router';
import { Bookingservice } from '../../service/booking-service';
import { FormsModule } from '@angular/forms';
import { bookingStatus } from '../../enum';

@Component({
  selector: 'app-edit-booking',
  imports: [FormsModule],
  templateUrl: './edit-booking.html',
  styleUrl: './edit-booking.css'
})
export class EditBooking implements OnInit{
booking:Booking= {
  bookingId:0,
  customerName:'',
  contactNumber:'',
  routeId:0,
  vehicleId:0,
  driverId:0,
  bookingStatus:bookingStatus.CONFIRMED,
  bookingTime:'',
  startTime:'',
  endTime:'',
  createdAt:'',
  updatedAt:''
};
id!:number;
 constructor(private route:ActivatedRoute, private bookingService:Bookingservice,private router:Router,private cdr: ChangeDetectorRef){}


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']; //get id from the url
    this.loadBooking();
   
  }
  loadBooking() {
    console.log(this.id);
    this.bookingService.getBookingById(this.id).subscribe({
      next: (data)=>{
        console.log(data);
        this.booking = data;
        this.cdr.detectChanges();
      },
      error:(err)=>console.error(err)
    });
  }
  onSubmit() {
    this.bookingService.updateBooking(this.id, this.booking).subscribe({
      next: () => {
        alert("Booking updated successfully");
         this.router.navigate(['/booking']);
      },
      error: (err)=>{
        console.error(err);
        alert("Failed to update booking!");
      }
    })
}
}