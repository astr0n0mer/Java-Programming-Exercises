public class BinarySearchTree implements NodeList {
    private ListItem root = null;
    private int noOfNodes = 0;

    public BinarySearchTree(ListItem root) {
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
        if (this.root == null) { // Implies tree is empty
            this.root = newItem;
            this.noOfNodes = 1;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) { // while (true) is a better statement to use here
            // as return true or false are the ones that will terminate the loop(& method) and not the while condition
            int difference = currentItem.compareTo(newItem);

            if (difference < 0) { // Implies currentItem.value < newItem.value
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNextItem(newItem);
                    noOfNodes++;
                    return true;
                }
            } else if (difference > 0) { // Implies currentItem.value > newItem.value
                if (currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else {
                    currentItem.setPreviousItem(newItem);
                    noOfNodes++;
                    return true;
                }
            } else {
                System.out.println(newItem.getValue() + " is already present in the Binary Search Tree.");
                return false;
            }
        }
        return false; // This statement is kinda redundant I feel, but it was necessary to complete the method body
    }

    @Override
    public boolean removeItem(ListItem itemToDelete) {
        // This method finds the node to be deleted and passes that node and its parent to performRemoval()
        if (itemToDelete != null) {
            System.out.println("Deleting item: " + itemToDelete.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null) {
            int difference = (currentItem.compareTo(itemToDelete));
            if (difference < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (difference > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                // equal: we've found the item so remove it
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    private void performRemoval(ListItem itemToDelete, ListItem parent) {
        // remove item from the tree
        if (itemToDelete.next() == null) {
            // no right tree, so make parent point to left tree (which may be null)
            if (parent.next() == itemToDelete) {
                // item is right child of its parent
                parent.setNextItem(itemToDelete.previous());
            } else if (parent.previous() == itemToDelete) {
                // item is left child of its parent
                parent.setPreviousItem(itemToDelete.previous());
            } else {
                // parent must be item, which means we were looking at the root of the tree
                this.root = itemToDelete.previous();
            }
        } else if (itemToDelete.previous() == null) {
            // no left tree, so make parent point to right tree (which may be null)
            if (parent.next() == itemToDelete) {
                // item is right child of its parent
                parent.setNextItem(itemToDelete.next());
            } else if (parent.previous() == itemToDelete) {
                // item is left child of its parent
                parent.setPreviousItem(itemToDelete.next());
            } else {
                // again, we are deleting the root
                this.root = itemToDelete.next();
            }
        } else {
            // neither left nor right are null, deletion is now a lot trickier!
            // From the right sub-tree, find the smallest value (i.e., the leftmost).
            ListItem current = itemToDelete.next();
            ListItem leftmostParent = itemToDelete;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            // Now put the smallest value into our node to be deleted
            itemToDelete.setValue(current.getValue());
            // and delete the smallest
            if (leftmostParent == itemToDelete) {
                // there was no leftmost node, so 'current' points to the smallest
                // node (the one that must now be deleted).
                itemToDelete.setNextItem(current.next());
            } else {
                // set the smallest node's parent to point to
                // the smallest node's right child (which may be null).
                leftmostParent.setPreviousItem(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            return;
        }
        traverse(root.previous());
        System.out.println(" " + root.getValue());
        traverse(root.next());
    }
}
