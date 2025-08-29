import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Bookingservice } from '../../service/booking-service';
import { Booking } from '../../types';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-view-booking',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './view-booking.html',
  styleUrls: ['./view-booking.css']
})
export class ViewBooking implements OnInit {

  message = 'hi';
  bookings: Booking[] = [];
  errorMessage = '';
  isLoading = true;

  constructor(
    private bookingService: Bookingservice,
    private cdr: ChangeDetectorRef,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadBookings();
  }

  loadBookings() {
    console.log("Loading Bookings...");

    this.bookingService.getBookings().subscribe({
      next: (data) => {
        console.log("API Response: ", data, Array.isArray(data));
        this.bookings = Array.isArray(data) ? data : [];
        this.cdr.detectChanges();
        console.log("Assigned bookings length:", this.bookings.length);
      },
      error: (err) => {
        this.errorMessage = 'Failed to fetch data..';
        console.error(err);
      }
    });
  }

  deleteBooking(id: number | undefined) {
    if (confirm('Are you sure to delete this booking?')) {
      this.bookingService.deleteBooking(id).subscribe({
        next: () => {
          alert('Booking deleted successfully');
          this.loadBookings();
        },
        error: (err) => {
          console.error(err);
          alert("Failed to delete a booking");
        }
      });
    }
  }

  editBooking(id: number | undefined) {
    this.router.navigate(['/edit-booking', id]);
  }

  onChange() {
    console.log(this.message);
  }
}
