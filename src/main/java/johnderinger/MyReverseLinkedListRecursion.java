package johnderinger;

public class MyReverseLinkedListRecursion {

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Given Linked List:");
        printList(head);

        // Function call to return the reversed list
        head = reverseList(head);

        System.out.print("\nReversed Linked List:");
        printList(head);
    }

    // Given the head of a list, reverse the list and return the
    // head of reversed list
    // 1 -> 2 -> 3 -> 4 -> 5
    // 1 <- 2 <- 3 <- 4 <- 5
    static Node prevNode = null;
    static Node reverseList(Node currNode) {

        // If the nextNode is null, we have reached the end
        // Set the new head with the previous pointer
        if (currNode.next == null) {
            currNode.next = prevNode;
            return currNode;
        }

        // Store the nextNode for the next iteration
        Node nextNode = currNode.next;
        // Reverse pointer order
        currNode.next = prevNode;
        // New prevNode is currNode
        prevNode = currNode;

        // Return the reversed linked list
        return reverseList(nextNode);
    }

    // This function prints the contents
    // of the linked list starting from the head
    static void printList(Node node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
    }

}

