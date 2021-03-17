public interface NodeList {
    ListItem getRoot();

    boolean addItem(ListItem newItem);

    boolean removeItem(ListItem itemToDelete);

    void traverse(ListItem root);
}
