package org.learning.misc;

import java.util.concurrent.locks.StampedLock;

public class BookingSystem {
    private boolean[] seats;  // Array representing available (false) or booked (true) seats
    private final StampedLock lock = new StampedLock(); // StampedLock

    public BookingSystem(int totalSeats) {
        seats = new boolean[totalSeats]; // All seats start as available (false)
    }

    // View available seats (Optimistic Read)
    public void viewAvailableSeats() {
        long stamp = lock.tryOptimisticRead(); // Optimistic read lock
        try {
            int availableSeats = 0;
            for (boolean seat : seats) {
                if (!seat) availableSeats++;
            }

            // Validate that no write happened while reading
            if (!lock.validate(stamp)) {
                // Fallback to a pessimistic read if validation fails
                stamp = lock.readLock();
                try {
                    availableSeats = 0;
                    for (boolean seat : seats) {
                        if (!seat) availableSeats++;
                    }
                } finally {
                    lock.unlockRead(stamp); // Release the read lock
                }
            }
            System.out.println("Available seats: " + availableSeats);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Book a seat (Write Lock)
    public boolean bookSeat(int seatNumber) {
        long stamp = lock.writeLock(); // Acquire the write lock
        try {
            if (seatNumber < 0 || seatNumber >= seats.length) {
                System.out.println("Invalid seat number");
                return false;
            }
            if (!seats[seatNumber]) {
                seats[seatNumber] = true; // Mark seat as booked
                System.out.println("Seat " + seatNumber + " successfully booked.");
                return true;
            } else {
                System.out.println("Seat " + seatNumber + " is already booked.");
                return false;
            }
        } finally {
            lock.unlockWrite(stamp); // Release the write lock
        }
    }

    // Cancel a booking (Write Lock)
    public boolean cancelBooking(int seatNumber) {
        long stamp = lock.writeLock(); // Acquire the write lock
        try {
            if (seatNumber < 0 || seatNumber >= seats.length) {
                System.out.println("Invalid seat number");
                return false;
            }
            if (seats[seatNumber]) {
                seats[seatNumber] = false; // Mark seat as available
                System.out.println("Booking for seat " + seatNumber + " has been canceled.");
                return true;
            } else {
                System.out.println("Seat " + seatNumber + " is not booked yet.");
                return false;
            }
        } finally {
            lock.unlockWrite(stamp); // Release the write lock
        }
    }
}
