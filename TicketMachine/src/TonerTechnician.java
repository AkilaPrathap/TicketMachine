import java.util.*;
// The TicketTonerTechnician class represents a toner technician replacing the ticket machine's toner cartridge
public class TonerTechnician implements Runnable {
    // The ticket machine that the technician replaces toner
    private TicketMachine ticketMachine;
    // The number of attempts that the technician tries to replace toner
    private int attemptCount;
    // The random number generator for sleep intervals
    private Random random;

    public TonerTechnician(TicketMachine ticketMachine, int attemptCount) {
        this.ticketMachine = ticketMachine;
        this.attemptCount = attemptCount;
        this.random = new Random();
    }

    // The run method of the Runnable interface
    public void run() {
        // Loop for the number of attempts that the technician tries to replace toner
        for (int i = 0; i < attemptCount; i++) {
            // Replace the toner using the ticket machine
            ticketMachine.replaceToner();
            // Sleep for a random interval between 0 and 5 seconds
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

