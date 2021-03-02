package flowers;

public class FlowersAmountException extends NumberFormatException {
    public FlowersAmountException() {
        super("Amount of flowers cannot be less than one");
    }
}
