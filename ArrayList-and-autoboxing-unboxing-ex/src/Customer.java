import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactionList = new ArrayList<>();
//    private final double INITIAL_TRANSACTION_AMOUNT = 100.0;

    public Customer(String name, double transactionAmount) {
        this.name = name;
        this.transactionList.add(transactionAmount);
    }

    // Factory method
    public static Customer getCustomerObject(String name, double initialTransactionAmount) {
        return new Customer(name, initialTransactionAmount);
    }

    public boolean newTransaction(double transactionAmount) {
        if (transactionAmount == 0) {
            return false;
        }
        this.transactionList.add(transactionAmount);
        return true;
    }

    public String getTransactionList() {
        String formattedTransactionList = "Transactions of customer with name=" + this.name + "\n";
        for (int i = 0; i < this.transactionList.size(); i++) {
            formattedTransactionList += "\tTxn #" + (i + 1) + ": ";

            if (this.transactionList.get(i) > 0) {
                formattedTransactionList += "+";
            }

            formattedTransactionList += this.transactionList.get(i) + "\n";
        }
        return formattedTransactionList;
    }

    public String getName() {
        return this.name;
    }
}
