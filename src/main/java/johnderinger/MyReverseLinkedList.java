package johnderinger;

public class MyReverseLinkedList {

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5
        MyNode head = new MyNode(1);
        head.nextNode = new MyNode(2);
        head.nextNode.nextNode = new MyNode(3);
        head.nextNode.nextNode.nextNode = new MyNode(4);
        head.nextNode.nextNode.nextNode.nextNode = new MyNode(5);

        printList(head);

        head = reverseList(head);

        printList(head);
    }

    // Start
    // 1 -> 2 -> 3 -> 4 -> 5
    //   head = 1
    // Reverse
    //   null <- 1 <- 2 <- 3 <- 4 <- 5
    //   5 -> 4 -> 3 -> 2 -> 1 -> null
    //   head = 5
    static MyNode reverseList(MyNode head) {
        MyNode currNode = head;
        MyNode prevNode = null; // Store prevNode to update currNode in reverse order
        while (currNode != null) {
            // Get the next node for the next iteration
            MyNode nextNode = currNode.nextNode;
            // Set the nextNode with the previous node, to reversing pointer
            // The last node should have a null nextNode. First iteration will set the last node, nextNode to null
            currNode.nextNode = prevNode;
            // Set the previous node with the current node, store for next iteration
            // null <- 1 <- 2 <- 3 <- 4 <- 5
            prevNode = currNode;
            // Update the currNode to the next node in the iteration
            currNode = nextNode;
        }

        // Return the new head, last node in the list, the last node will not have a nextNode
        return prevNode;
    }

    public static void printList(MyNode node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.nextNode;
        }
        System.out.print("\n");
    }

    public static void printX(MyNode node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.nextNode;
        }
    }

    @Override
    public String toString() {
        return "MyReverseLinkedList{}";
    }
}

class MyNode {

    int data;
    MyNode nextNode;

    public MyNode(int data) {
        this.data = data;
        this.nextNode = null;
    }



}
