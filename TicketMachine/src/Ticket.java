// The Ticket class represents a ticket with a number and a price
public class Ticket {
    private int number;
    private double price;

    public Ticket(int number, double price) {
        this.number = number;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return " Ticket TM 00" + number + "\n " + "Seat Number #" + number + "\n " + "Price: $" + price + "\n";
    }
}