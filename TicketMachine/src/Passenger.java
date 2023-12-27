import java.util.*;
// The Passenger class represents a passenger purchasing and printing tickets
public class Passenger implements Runnable {
    // The ticket machine that the passenger uses
    private TicketMachine ticketMachine;
    // The number of tickets that the passenger wants to print
    private int ticketCount;
    // The random number generator for sleep intervals
    private Random random;

    public Passenger(TicketMachine ticketMachine, int ticketCount) {
        this.ticketMachine = ticketMachine;
        this.ticketCount = ticketCount;
        this.random = new Random();
    }

    // The run method of the Runnable interface
    public void run() {
        // Loop for the number of tickets that the passenger wants to print
        for (int i = 0; i < ticketCount; i++) {
            // Generate a random ticket number and price
            int number = random.nextInt(5) ;
            double price = random.nextInt(50);
            // Print the ticket using the ticket machine
            ticketMachine.printTicket(number, price);
            // Sleep for a random interval between 0 and 5 seconds
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
