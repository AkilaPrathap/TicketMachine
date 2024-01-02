// The TicketMachine class implements the ServiceTicketMachine interface and manages the paper and toner levels

public class TicketMachine implements ServiceTicketMachine {
     
    private static final int MAX_PAPER_LEVEL = 5; // The maximum paper level that the machine can hold
    
    private static final int MAX_TONER_LEVEL = 5; // The maximum toner level that the machine can have
    
    private static final int PAPER_PER_TICKET = 1; // The amount of paper consumed per ticket
    
    private static final int TONER_PER_TICKET = 1; // The amount of toner consumed per ticket

    private final Object lock = new Object();     // The lock object for synchronization
    
    private int paperLevel; // The current paper level
    
    private int tonerLevel; // The current toner level

    public TicketMachine() {
        // Initialize the paper and toner levels to the maximum
        paperLevel = MAX_PAPER_LEVEL;
        tonerLevel = MAX_TONER_LEVEL;
    }

    // Print a ticket with a given number and price
    public void printTicket(int number, double price) {
        // Synchronize on the lock object to ensure mutual exclusion
        synchronized (lock) {
            // Try to print the ticket
            try {
                // Check if there is enough paper and toner to print the ticket
                if (paperLevel < PAPER_PER_TICKET || tonerLevel < TONER_PER_TICKET) {
                    // If there is not enough paper or toner, throw an exception
                    refillPaper(MAX_PAPER_LEVEL);
                    replaceToner();
                    throw new IllegalArgumentException("Paper and Tonner Refilled ");
                    
                }
                // Create a new ticket object
                Ticket ticket = new Ticket(number, price);
                // Simulate the printing of the ticket
                System.out.println("Printing " + ticket +"$");
                // Reduce the paper and toner levels by the amount consumed
                paperLevel -= PAPER_PER_TICKET;
                tonerLevel -= TONER_PER_TICKET;
            } catch (IllegalArgumentException e) {
                // Catch the exception and print the error message
                System.out.println(e.getMessage());
            }
        }
    }

    // Refill the paper level by a given amount
    public void refillPaper(int amount) {
        // Synchronize on the lock object to ensure mutual exclusion
        synchronized (lock) {
            // Try to refill the paper
            try {
                // Check if the amount is positive and does not exceed the maximum paper level
                if (amount <= 0 || paperLevel + amount > MAX_PAPER_LEVEL) {
                    // If the amount is invalid, throw an exception
                    throw new IllegalArgumentException("Invalid paper refill amount");
                }
                // Increase the paper level by the amount
                paperLevel += amount;
                // Print a message indicating the new paper level
                System.out.println("Refilled paper by " + amount + ", new paper level is " + paperLevel);
            } catch (IllegalArgumentException e) {
                // Catch the exception and print the error message
                System.out.println(e.getMessage());
            }
        }
    }

    // Replace the toner cartridge
    public void replaceToner() {
        // Synchronize on the lock object to ensure mutual exclusion
        synchronized (lock) {
            // Set the toner level to the maximum
            tonerLevel = MAX_TONER_LEVEL;
            // Print a message indicating the toner replacement
            System.out.println("Replaced toner, new toner level is " + tonerLevel);
        }
    }

    // Get the current paper level
    public int getPaperLevel() {
        // Synchronize on the lock object to ensure mutual exclusion
        synchronized (lock) {
            // Return the paper level
            return paperLevel;
        }
    }

    // Get the current toner level
    public int getTonerLevel() {
        // Synchronize on the lock object to ensure mutual exclusion
        synchronized (lock) {
            // Return the toner level
            return tonerLevel;
        }
    }
}
