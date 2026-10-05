package update;

import model.Booking;
import model.BookingList;
import model.Vendor;

public class UpdateBooking {
    private BookingList bookingList;

    public UpdateBooking(BookingList bookingList) {
        this.bookingList = bookingList;
    }

    // Change the event date of a booking
    public void updateBooking(int bookingId, String newEventDate) {
        Booking booking = bookingList.findBooking(bookingId);
        if (booking == null) {
            System.out.println("Booking " + bookingId + " not found.");
        } else if (booking.getStatus().equals("Cancelled")) {
            System.out.println("Booking " + bookingId + " is cancelled and cannot be updated.");
        } else {
            booking.setEventDate(newEventDate);
            System.out.println("Booking " + bookingId + " date updated to " + newEventDate);
        }
    }

    // Change the vendor of a booking (method overloading)
    public void updateBooking(int bookingId, Vendor newVendor) {
        Booking booking = bookingList.findBooking(bookingId);
        if (booking == null) {
            System.out.println("Booking " + bookingId + " not found.");
        } else if (booking.getStatus().equals("Cancelled")) {
            System.out.println("Booking " + bookingId + " is cancelled and cannot be updated.");
        } else {
            booking.setVendor(newVendor);
            System.out.println("Booking " + bookingId + " vendor updated to " + newVendor.getVendorName());
        }
    }
}
