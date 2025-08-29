import { BookingService } from './booking-service';

describe('BookingService', () => {
  it('should create an instance', () => {
    const directive = new BookingService();
    expect(directive).toBeTruthy();
  });
});
