import java.util.ArrayList;
import java.util.Scanner;

class Booking {
    int bookingId;
    String customerName;
    int roomNumber;
    int days;
    double totalCost;

    Booking(int bookingId, String customerName,
            int roomNumber, int days) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.days = days;
        this.totalCost = days * 1500.0;
    }

    void display() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Customer: " + customerName);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Days: " + days);
        System.out.println("Total Cost: Rs. " + totalCost);
        System.out.println("-------------------------");
    }
}

public class HotelBooking {
    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextBookingId = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== HOTEL BOOKING SYSTEM =====");
            System.out.println("1. Book Room");
            System.out.println("2. View Bookings");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        bookRoom();
                        break;
                    case 2:
                        viewBookings();
                        break;
                    case 3:
                        cancelBooking();
                        break;
                    case 4:
                        System.out.println("Thank you!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    static void bookRoom() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter room number (1-10): ");
        int room = Integer.parseInt(sc.nextLine());

        if (room < 1 || room > 10) {
            System.out.println("Invalid room number!");
            return;
        }

        for (Booking b : bookings) {
            if (b.roomNumber == room) {
                System.out.println("Room is already booked!");
                return;
            }
        }

        System.out.print("Enter number of days: ");
        int days = Integer.parseInt(sc.nextLine());

        if (days <= 0) {
            System.out.println("Days must be greater than zero!");
            return;
        }

        Booking booking = new Booking(nextBookingId++, name, room, days);
        bookings.add(booking);

        System.out.println("Room booked successfully!");
        booking.display();
    }

    static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Booking b : bookings) {
            b.display();
        }
    }

    static void cancelBooking() {
        System.out.print("Enter booking ID to cancel: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Booking b : bookings) {
            if (b.bookingId == id) {
                bookings.remove(b);
                System.out.println("Booking cancelled successfully!");
                return;
            }
        }

        System.out.println("Booking ID not found.");
    }
}