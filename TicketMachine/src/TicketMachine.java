
// The TicketMachine class implements the ServiceTicketMachine interface and manages the paper and toner levels
// Import the ReentrantLock class
import java.util.concurrent.locks.ReentrantLock;

public class TicketMachine implements ServiceTicketMachine {

    private static final int MAX_PAPER_LEVEL = 5; // The maximum paper level that the machine can hold

    private static final int MAX_TONER_LEVEL = 5; // The maximum toner level that the machine can have

    private static final int PAPER_PER_TICKET = 1; // The amount of paper consumed per ticket

    private static final int TONER_PER_TICKET = 1; // The amount of toner consumed per ticket

    private final ReentrantLock lock = new ReentrantLock(); // The reentrant lock object for synchronization

    private int paperLevel; // The current paper level

    private int tonerLevel; // The current toner level

    public TicketMachine() {
        // Initialize the paper and toner levels to the maximum
        paperLevel = MAX_PAPER_LEVEL;
        tonerLevel = MAX_TONER_LEVEL;
    }

    // Print a ticket with a given number and price
    public void printTicket(int number, double price) {
        // Acquire the lock
        lock.lock();
        // Try to print the ticket
        try {
            // Check if there is enough paper and toner to print the ticket
            if (paperLevel < PAPER_PER_TICKET || tonerLevel < TONER_PER_TICKET) {
                // If there is not enough paper or toner, throw an exception
                refillPaper(10);
                replaceToner();
            }

            // Create a new ticket object
            Ticket ticket = new Ticket(number, price);
            // Simulate the printing of the ticket
            System.out.println(ticket);
            // Reduce the paper and toner levels by the amount consumed
            paperLevel -= PAPER_PER_TICKET;
            tonerLevel -= TONER_PER_TICKET;
        } catch (IllegalArgumentException e) {
            // Catch the exception and print the error message
            System.out.println(e.getMessage());
        } finally {
            // Release the lock
            lock.unlock();
        }
    }

    // Refill the paper level by a given amount
    public void refillPaper(int amount) {
        // Acquire the lock
        lock.lock();
        // Try to refill the paper
        try {
            // Check if the amount is positive and does not exceed the maximum paper level
            if (amount <= 0 || paperLevel + amount > MAX_PAPER_LEVEL) {
                // If the amount is invalid, throw an exception
                System.out.println(amount + " Papers cannot be added to the printer.");
                paperLevel = MAX_PAPER_LEVEL;
                throw new IllegalArgumentException("paper refiles to max amout of " + MAX_PAPER_LEVEL + "\n");

            }
            // Increase the paper level by the amount
            paperLevel += amount;
            // Print a message indicating the new paper level
            System.out.println("Refilled paper by " + amount + ", new paper level is " + paperLevel + "\n");
        } catch (IllegalArgumentException e) {
            // Catch the exception and print the error message
            System.out.println(e.getMessage());
        } finally {
            // Release the lock
            lock.unlock();
        }
    }

    // Replace the toner cartridge
    // Acquire the lock
    public void replaceToner() {
        lock.lock();
        // Try to replace the toner
        try {
            tonerLevel = MAX_TONER_LEVEL; // Set the toner level to the maximum
            // Print a message indicating the toner replacement
            System.out.println("Replaced toner, new toner level is " + tonerLevel + "\n");
        } finally {
            // Release the lock
            lock.unlock();
        }
    }

    // Get the current paper level
    // Synchronize on the lock object to ensure mutual exclusion
    public int getPaperLevel() {

        synchronized (lock) {
            return paperLevel; // Return the paper level
        }
    }

    // Get the current toner level
    // Synchronize on the lock object to ensure mutual exclusion
    public int getTonerLevel() {

        synchronized (lock) {
            return tonerLevel; // Return the toner level
        }
    }
}
