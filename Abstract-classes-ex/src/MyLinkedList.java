public class MyLinkedList implements NodeList {
    private ListItem root = null; // Could also use Node as the type, for variable "root"
    private int noOfNodes = 0;

    public MyLinkedList(ListItem root) {
        if (root != null) {
            this.root = root;
            noOfNodes++;
        }
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    public int getNoOfNodes() {
        return this.noOfNodes;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) { // Implies list is empty
            this.root = newItem;
            this.noOfNodes = 1;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int difference = currentItem.compareTo(newItem);

            if (difference < 0) { // Implies currentItem.value < newItem.value
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNextItem(newItem);
                    newItem.setPreviousItem(currentItem);
                    // You can combine the above 2 lines by using
                    // currentItem.setNextItem(newItem).setPreviousItem(currentItem);
                    noOfNodes++;
                    return true;
                }
            } else if (difference > 0) { // Implies currentItem.value > newItem.value
                if (currentItem.previous() == null) {
                    this.root = newItem;
                } else {
                    currentItem.previous().setNextItem(newItem);
                    newItem.setPreviousItem(currentItem.previous());
                    // You can combine the above 2 lines by using
                    // currentItem.previous().setNextItem(newItem).setPreviousItem(currentItem.previous());
                }
                currentItem.setPreviousItem(newItem);
                newItem.setNextItem(currentItem);
                // currentItem.setPreviousItem(newItem).setNextItem(currentItem);
                noOfNodes++;
                return true;
            } else {
                System.out.println(newItem.getValue() + " is already present in the list. Not added.");
                return false;
            }
        }
        return false; // This statement is kinda redundant I feel, but it was necessary to complete the method body
    }

    @Override
    public boolean removeItem(ListItem itemToDelete) {
        if (itemToDelete == null) return false;

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int difference = currentItem.compareTo(itemToDelete);
            if (difference == 0) {              // match found
                if (currentItem == this.root) { // node to be deleted is the root(head) node
                    this.root = this.root.next();
                    this.root.setPreviousItem(null);
                } else if (currentItem.next() == null) { // node to be deleted is the last node
                    currentItem.previous().setNextItem(null);
                } else {                                // node to be deleted is somewhere in between the list
                    // this block can be optimized but it will heavily reduce the readability
                    currentItem.previous().setNextItem(currentItem.next());
                    currentItem.next().setPreviousItem(currentItem.previous());
                }
                System.out.println("Removed " + itemToDelete.value.toString() + " successfully");
                noOfNodes--;
                return true;
            } else if (difference > 0) { // implies that we've crossed the point at which itemToDelete would've been
                // found if it was present in the list, as we sorted the list lexicographically while adding any new
                // items. So no need to search any further
                return false;
            } else {
                currentItem = currentItem.next();
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            System.out.println("Printing contents of the list:");
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
