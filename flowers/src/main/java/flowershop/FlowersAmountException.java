package flowershop;

public class FlowersAmountException extends NumberFormatException {
    public FlowersAmountException() {
        super("Amount of flowershop.flowers cannot be less than one");
    }
}
