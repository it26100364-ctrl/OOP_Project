package model;

// A Booking links one Couple to one Vendor.
// The Couple and Vendor are created outside and passed in (Aggregation).
public class Booking {
    private int bookingId;
    private Couple couple;
    private Vendor vendor;
    private String eventDate;
    private String status;   // "Confirmed" or "Cancelled"

    // Default constructor
    public Booking() {
        bookingId = 0;
        couple = null;
        vendor = null;
        eventDate = "";
        status = "Confirmed";
    }

    // Parameterized constructor
    public Booking(int bookingId, Couple couple, Vendor vendor, String eventDate) {
        setBookingId(bookingId);
        this.couple = couple;
        this.vendor = vendor;
        this.eventDate = eventDate;
        this.status = "Confirmed";
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        if (bookingId > 0) {
            this.bookingId = bookingId;
        } else {
            System.out.println("Booking ID must be greater than 0");
        }
    }

    public Couple getCouple() {
        return couple;
    }

    public void setCouple(Couple couple) {
        this.couple = couple;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayDetails() {
        System.out.println("----------------------------------");
        System.out.println("Booking ID  : " + bookingId);
        System.out.println("Event Date  : " + eventDate);
        System.out.println("Status      : " + status);
        couple.displayDetails();
        vendor.displayDetails();
        System.out.println("----------------------------------");
    }
}
