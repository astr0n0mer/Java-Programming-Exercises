import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Branch(String name) {
        this.name = name;
    }

    // Factory method
    public static Branch getBranchObject(String name) {
        return new Branch(name);
    }

    private int getCustomerIndex(String name) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addCustomer(String name, double initialTransactionAmount) {
        // Check if customer already exists
        if (getCustomerIndex(name) >= 0) { // Implies customer with given name already exists
            return false;
        }
        this.customers.add(Customer.getCustomerObject(name, initialTransactionAmount));
        return true;
    }

    public boolean newTransaction(String name, double transactionAmount) {
        int customerIndex = getCustomerIndex(name);
        if (customerIndex == -1) { // Implies customer with given name does not exist
            System.out.println("Account with name=" + name + " was not found in branch " + this.name);
            System.out.println("Transaction failed.");
            return false;
        } else {
            if (this.customers.get(customerIndex).newTransaction(transactionAmount)) {
                System.out.println("Transaction of $" + transactionAmount + " in branch " + this.name + " was successful.");
                return true;
            } else {
                System.out.println("Transaction of $" + transactionAmount + " was unsuccessful.");
                return false;
            }
        }
    }

    public String getTransactionList(String name) {
        int customerIndex = getCustomerIndex(name);
        if (customerIndex == -1) { // Implies customer with given name does not exist
            System.out.println("Account with name=" + name + " was not found in branch " + this.name);
            return null;
        } else {
            return this.customers.get(customerIndex).getTransactionList();
        }
    }

    public void getCustomerDetails(boolean showTransactions) {
        if (showTransactions) {
            for (int i = 0; i < this.customers.size(); i++) {
                System.out.println(this.customers.get(i).getTransactionList());
            }
        } else {
            for (int i = 0; i < this.customers.size(); i++) {
                System.out.println("Name: " + this.customers.get(i).getName());
            }
        }
    }

    public String getName() {
        return name;
    }
}
