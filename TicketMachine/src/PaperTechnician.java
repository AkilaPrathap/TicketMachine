// The TicketPaperTechnician class represents a paper technician refilling the ticket machine

import java.util.*;

public class PaperTechnician implements Runnable {
    // The ticket machine that the technician refills
    private TicketMachine ticketMachine;
    // The number of attempts that the technician tries to refill paper
    private int attemptCount;
    // The random number generator for sleep intervals and refill amounts
    private Random random;

    public PaperTechnician(TicketMachine ticketMachine, int attemptCount) {
        this.ticketMachine = ticketMachine;
        this.attemptCount = attemptCount;
        this.random = new Random();
    }

    // The run method of the Runnable interface
    public void run() {
        // Loop for the number of attempts that the technician tries to refill paper
        for (int i = 0; i < attemptCount; i++) {
            // Generate a random refill amount between 1 and 10
            int amount = random.nextInt(10) + 1;
            // Refill the paper using the ticket machine
            ticketMachine.refillPaper(amount);
            // Sleep for a random interval between 0 and 5 seconds
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
