import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Bookingservice } from '../../service/booking-service';
import { Router } from '@angular/router';
import { Booking } from '../../types';
import { bookingStatus } from '../../enum';

@Component({
  selector: 'app-add-booking',
  imports: [FormsModule],
  templateUrl: './add-booking.html',
  styleUrl: './add-booking.css'
})
export class AddBooking {
bookingStatus = bookingStatus;
booking: Booking = {
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

  message = '';

  constructor(private bookingService: Bookingservice, private router: Router) {}

  // utility function
  private formatDateTime(value: string): string {
    // If input is like "2025-08-15T17:30" → "2025-08-15 17:30:00"
    return value ? value.replace("T", " ") + ":00" : '';
  }

  async onSubmit() {
  console.log("Submitting booking:", this.booking);

  const bookingToSend: Booking = {
    ...this.booking,
    bookingTime: this.formatDateTime(this.booking.bookingTime),
    startTime: this.formatDateTime(this.booking.startTime),
    endTime: this.formatDateTime(this.booking.endTime),
    createdAt: this.formatDateTime(this.booking.createdAt),
    updatedAt: this.formatDateTime(this.booking.updatedAt)
  };

  this.bookingService.addBooking(bookingToSend).subscribe({
    next: (response) => {
      console.log("Booking saved:", response);
      this.message = "Booking added successfully!";
      this.router.navigate(['/booking']);
    },
    error: (err) => {
      console.error("Error while saving booking:", err);
      this.message = "Error adding booking! Check all fields.";
    }
  });
}
}