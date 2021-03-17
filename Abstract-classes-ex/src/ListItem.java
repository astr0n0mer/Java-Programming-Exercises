public abstract class ListItem {
    protected Object value;
    protected ListItem leftLink = null;
    protected ListItem rightLink = null;

    public ListItem(Object value) {
        this.value = value;
    }

    public abstract ListItem previous();

    public abstract ListItem setPreviousItem(ListItem item);

    public abstract ListItem next();

    public abstract ListItem setNextItem(ListItem item);

    public abstract int compareTo(ListItem itemToCompare);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
