public class Main {

    public static void main(String[] args) {
//        MyLinkedList johnsList = new MyLinkedList(null);
//        johnsList.traverse(johnsList.getRoot());
//        System.out.println("No of nodes: " + johnsList.getNoOfNodes());
//
//        String testString = "The quick brown fox jumps over the lazy over dog"; // "over" is present twice
//        String[] testStringArray = testString.split(" ");
//        for (String chunk : testStringArray) {
//            johnsList.addItem(new Node(chunk));
//        }
//        johnsList.traverse(johnsList.getRoot());
//        System.out.println("No of nodes: " + johnsList.getNoOfNodes());
//
//        johnsList.removeItem(new Node("jumps"));
//        johnsList.removeItem(new Node("over"));
//        johnsList.traverse(johnsList.getRoot());
//        System.out.println("No of nodes: " + johnsList.getNoOfNodes());
//        -------------------------------------------------------------------------------
//        Implementing Binary Search Tree
        BinarySearchTree myBST = new BinarySearchTree(null);
        int[] testArray = {3, 6, 1, 9, 0, 2, 8, 7, 4, 2, 5}; // '2' is present twice
        for (int i : testArray) {
            myBST.addItem(new Node(i));
        }
        myBST.traverse(myBST.getRoot());
        System.out.println("No. of nodes: " + myBST.getNoOfNodes());

        myBST.removeItem(new Node(4));
        myBST.removeItem(new Node(2));
        myBST.traverse(myBST.getRoot());

        myBST.removeItem(new Node(9));
        myBST.removeItem(new Node(6));
        myBST.removeItem(new Node(1));
        myBST.traverse(myBST.getRoot());

        for (int i : testArray) { // Adding elements back to the BST
            myBST.addItem(new Node(i));
        }
        myBST.traverse(myBST.getRoot());
    }
}
