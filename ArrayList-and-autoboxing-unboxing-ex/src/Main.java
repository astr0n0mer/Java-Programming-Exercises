import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] branches = {"Mumbai", "Delhi", "Kolkata"};
        String[] customers = {"John Smith", "Jennifer Bolt", "William Kent"};

        Bank axisBank = new Bank("Axis Bank");

        axisBank.addBranch(branches[0]);
        axisBank.addBranch(branches[1]);
        axisBank.addBranch(branches[2]);

        axisBank.addCustomer(customers[0], 100, branches[0]);
        axisBank.addCustomer(customers[1], 200, branches[0]);
        axisBank.addCustomer(customers[2], 300, branches[1]);

        axisBank.newTransaction(customers[0], 15, branches[0]);
        axisBank.newTransaction(customers[0], -80, branches[0]);
        axisBank.newTransaction(customers[0], 70, branches[0]);

        axisBank.newTransaction(customers[1], -50, branches[0]);
        axisBank.newTransaction(customers[1], -80, branches[0]);
        axisBank.newTransaction(customers[1], 100, branches[0]);

        axisBank.getCustomerDetails(branches[0], true);
        axisBank.getCustomerDetails(branches[1], true);
        axisBank.getCustomerDetails(branches[2], false);
    }
}
