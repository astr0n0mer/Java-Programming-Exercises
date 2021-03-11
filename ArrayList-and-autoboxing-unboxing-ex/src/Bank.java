import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    private int getBranchIndex(String name) {
        for (int i = 0; i < this.branches.size(); i++) {
            if (this.branches.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addBranch(String name) {
        if (getBranchIndex(name) >= 0) { // Implies branch with given name already exists
            return false;
        }
        this.branches.add(Branch.getBranchObject(name));
        return true;
    }

    public boolean addCustomer(String customerName, double initialTransactionAmount, String branchName) {
        int branchIndex = getBranchIndex(branchName);
        if (branchIndex == -1) { // Implies branch with name=branchName does not exist
            System.out.println("Branch with name=" + branchName + " does not exist");
            return false;
        } else {
            if (this.branches.get(branchIndex).addCustomer(customerName, initialTransactionAmount)) {
                System.out.println("Account with name=" + customerName + " added successfully in branch " + branchName);
                return true;
            } else {
                System.out.println("Account with name=" + customerName + " already exists in branch " + branchName);
                return false;
            }
        }
    }

    public boolean newTransaction(String name, double transactionAmount, String branchName) {
        int branchIndex = getBranchIndex(branchName);
        if (branchIndex == -1) { // Implies branch with name=branchName does not exist
            System.out.println("Branch with name=" + branchName + " does not exist");
            return false;
        } else {
            return this.branches.get(branchIndex).newTransaction(name, transactionAmount);
        }
    }

    public void getCustomerDetails(String branchName, boolean showTransactions) {
        int branchIndex = getBranchIndex(branchName);
        if (branchIndex == -1) { // Implies branch with name=branchName does not exist
            System.out.println("Branch with name=" + branchName + " does not exist");
        } else {
            System.out.println("Printing details of customers from " + branchName + " branch");
            this.branches.get(branchIndex).getCustomerDetails(showTransactions);
        }
    }
}
