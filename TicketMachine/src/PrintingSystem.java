// The TicketPrintingSystem class coordinates all the components, including the ticket machine, passengers, and technicians

public class PrintingSystem {
    public static void main(String[] args) {
        // Create a new ticket machine object
        TicketMachine ticketMachine = new TicketMachine();
        // Create a thread group for the passengers
        ThreadGroup passengerGroup = new ThreadGroup("Passengers");
        // Create an array of passengers with different ticket counts
        Passenger[] passengers = {
                new Passenger(ticketMachine, 5),
                new Passenger(ticketMachine, 3),
                new Passenger(ticketMachine, 4),
                new Passenger(ticketMachine, 2),
                new Passenger(ticketMachine, 6)
        };

        // Create an array of threads
        Thread[] threads = new Thread[passengers.length];
        // Loop over the passengers array
        for (int i = 0; i < passengers.length; i++) {
            // Create a new thread for each passenger and assign it to the threads array
            threads[i] = new Thread(passengerGroup, passengers[i]);
            // Start the thread
            threads[i].start();
        }
        // Loop over the threads array
        for (int i = 0; i < threads.length; i++) {
            // Join the thread and wait for it to finish
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Remaining paper level " + ticketMachine.getPaperLevel() +
                " Remaining toner level " + ticketMachine.getTonerLevel());

    }

}