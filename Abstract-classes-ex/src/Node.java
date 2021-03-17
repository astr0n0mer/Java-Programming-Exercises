public class Node extends ListItem {
    public Node(Object value) {
        super(value);
    }

    @Override
    public ListItem previous() {
        return this.leftLink;
    }

    @Override
    public ListItem setPreviousItem(ListItem item) {
        this.leftLink = item;
        return this.leftLink;
    }

    @Override
    public ListItem next() {
        return this.rightLink;
    }

    @Override
    public ListItem setNextItem(ListItem item) {
        this.rightLink = item;
        return rightLink;
    }

    @Override
    public int compareTo(ListItem itemToCompare) {
        if (itemToCompare != null) {
            return this.getValue().toString().compareTo(itemToCompare.getValue().toString());
        } else {
            return -1;
        }
    }
}
