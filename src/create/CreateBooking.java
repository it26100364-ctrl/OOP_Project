package create;

import model.Booking;
import model.BookingList;
import model.Couple;
import model.Vendor;

public class CreateBooking {
    private BookingList bookingList;
    private int nextBookingId;

    public CreateBooking(BookingList bookingList) {
        this.bookingList = bookingList;
        this.nextBookingId = 1;
    }

    // Creates a new booking that links a couple to a vendor
    public Booking createBooking(Couple couple, Vendor vendor, String eventDate) {
        Booking booking = new Booking(nextBookingId, couple, vendor, eventDate);
        bookingList.addBooking(booking);
        nextBookingId++;
        System.out.println("Booking created successfully. Booking ID: " + booking.getBookingId());
        return booking;
    }
}
