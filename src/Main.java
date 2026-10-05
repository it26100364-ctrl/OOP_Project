import java.util.Scanner;

import model.BookingList;
import model.Couple;
import model.Vendor;
import create.CreateBooking;
import view.ViewBooking;
import update.UpdateBooking;
import cancel.CancelBooking;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // One shared list of bookings used by all 4 categories
        BookingList bookingList = new BookingList();
        CreateBooking create = new CreateBooking(bookingList);
        ViewBooking view = new ViewBooking(bookingList);
        UpdateBooking update = new UpdateBooking(bookingList);
        CancelBooking cancel = new CancelBooking(bookingList);

        // Sample vendors (in the full system these come from Vendor Management)
        Vendor[] vendors = new Vendor[3];
        vendors[0] = new Vendor(1, "Lens Studio", "Photography", 75000);
        vendors[1] = new Vendor(2, "Royal Caterers", "Catering", 250000);
        vendors[2] = new Vendor(3, "Bloom Decor", "Decoration", 120000);

        int coupleCount = 0;
        int choice = 0;

        while (choice != 5) {
            System.out.println();
            System.out.println("===== Booking Management =====");
            System.out.println("1. Create booking");
            System.out.println("2. View bookings");
            System.out.println("3. Update booking");
            System.out.println("4. Cancel booking");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Bride's name: ");
                String bride = input.nextLine();
                System.out.print("Groom's name: ");
                String groom = input.nextLine();
                System.out.print("Phone number: ");
                String phone = input.nextLine();
                coupleCount++;
                Couple couple = new Couple(coupleCount, bride, groom, phone);

                System.out.println("Available vendors:");
                for (int i = 0; i < vendors.length; i++) {
                    System.out.println((i + 1) + ". " + vendors[i].getVendorName()
                            + " - " + vendors[i].getServiceType()
                            + " - Rs." + vendors[i].getPrice());
                }
                System.out.print("Choose a vendor (1-" + vendors.length + "): ");
                int v = input.nextInt();
                input.nextLine();
                if (v < 1 || v > vendors.length) {
                    System.out.println("Invalid vendor.");
                    continue;
                }

                System.out.print("Event date (YYYY-MM-DD): ");
                String date = input.nextLine();

                create.createBooking(couple, vendors[v - 1], date);

            } else if (choice == 2) {
                System.out.print("Enter booking ID (0 to view all): ");
                int id = input.nextInt();
                input.nextLine();
                if (id == 0) {
                    view.viewBooking();
                } else {
                    view.viewBooking(id);
                }

            } else if (choice == 3) {
                System.out.print("Enter booking ID: ");
                int id = input.nextInt();
                input.nextLine();
                System.out.println("1. Change event date");
                System.out.println("2. Change vendor");
                System.out.print("Enter your choice: ");
                int option = input.nextInt();
                input.nextLine();

                if (option == 1) {
                    System.out.print("New event date (YYYY-MM-DD): ");
                    String date = input.nextLine();
                    update.updateBooking(id, date);
                } else if (option == 2) {
                    System.out.print("Choose a new vendor (1-" + vendors.length + "): ");
                    int v = input.nextInt();
                    input.nextLine();
                    if (v >= 1 && v <= vendors.length) {
                        update.updateBooking(id, vendors[v - 1]);
                    } else {
                        System.out.println("Invalid vendor.");
                    }
                } else {
                    System.out.println("Invalid option.");
                }

            } else if (choice == 4) {
                System.out.print("Enter booking ID to cancel: ");
                int id = input.nextInt();
                input.nextLine();
                cancel.cancelBooking(id);

            } else if (choice == 5) {
                System.out.println("Goodbye!");

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        input.close();
    }
}
