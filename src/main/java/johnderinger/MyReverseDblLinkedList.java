package johnderinger;

public class MyReverseDblLinkedList {

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5
        MyDblNode head = new MyDblNode(1);
        MyDblNode node2 = new MyDblNode(2);
        MyDblNode node3 = new MyDblNode(3);
        MyDblNode node4 = new MyDblNode(4);
        MyDblNode node5 = new MyDblNode(5);

        head.nextNode = node2;
        node2.prevNode = head;
        node2.nextNode = node3;
        node3.prevNode = node2;
        node3.nextNode = node4;
        node4.prevNode = node3;
        node4.nextNode = node5;
        node5.prevNode = node4;

        printList(head);

//        printDblList(node5);
//
        head = reverseList(head);
//
        printList(head);

//        printDblList(head);
    }

    // Start
    // 1 -> 2 -> 3 -> 4 -> 5
    //   head = 1
    // Reverse
    //   null <- 1 <- 2 <- 3 <- 4 <- 5
    //   5 -> 4 -> 3 -> 2 -> 1 -> null
    //   head = 5
    static MyDblNode reverseList(MyDblNode head) {
        MyDblNode currNode = head;
        MyDblNode prevNode = null; // Store prevNode to update currNode in reverse order
        MyDblNode nextNode = null;
        while (true) {
            // Get the next node for the next iteration
            nextNode = currNode.nextNode;
            prevNode = currNode.prevNode;
            // Set the nextNode with the previous node, to reversing pointer
            // The last node should have a null nextNode. First iteration will set the last node, nextNode to null
            currNode.nextNode = prevNode;
            currNode.prevNode = nextNode;
            // Set the previous node with the current node, store for next iteration
            // null <- 1 <- 2 <- 3 <- 4 <- 5
            // Update the currNode to the next node in the iteration
            // If nextNode is null, then we are at the end
            if (nextNode == null) {
                return currNode;
            } else {
                currNode = nextNode;
            }
        }
    }

    public static void printList(MyDblNode node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.nextNode;
        }
        System.out.print("\n");
    }
    //   5 -> 4 -> 3 -> 2 -> 1 -> null
    public static void printDblList(MyDblNode node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.prevNode;
        }
        System.out.print("\n");
    }

    @Override
    public String toString() {
        return "MyReverseLinkedList{}";
    }
}

class MyDblNode {

    int data;
    MyDblNode nextNode;
    MyDblNode prevNode;

    public MyDblNode(int data) {
        this.data = data;
        this.nextNode = null;
        this.prevNode = null;
    }



}
