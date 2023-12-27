// The ServiceTicketMachine interface defines the methods that a ticket machine should implement
public interface ServiceTicketMachine {
    // Print a ticket with a given number and price
    public void printTicket(int number, double price);
    // Refill the paper level by a given amount
    public void refillPaper(int amount);
    // Replace the toner cartridge
    public void replaceToner();
    // Get the current paper level
    public int getPaperLevel();
    // Get the current toner level
    public int getTonerLevel();
}

