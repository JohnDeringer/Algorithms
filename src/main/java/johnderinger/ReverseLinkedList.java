package johnderinger;

public class ReverseLinkedList {

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Print the original linked list
        System.out.print("Given Linked list:");
        printList(head);

        // Function call to return the reversed list
        head = reverseList(head);

        // Print the reversed linked list
        System.out.print("\nReversed Linked List:");
        printList(head);
    }

    public static Node reverseList(Node headNode) {

        // Initialize three pointers: curr, prev and next
        Node currNode = headNode, prevNode = null, nextNode;

        // Traverse all the nodes of Linked List
        while (currNode != null) {

            // Store next
            nextNode = currNode.next;

            // Reverse current node's next pointer
            currNode.next = prevNode;

            // Move pointers one position ahead
            prevNode = currNode;
            currNode = nextNode;
        }

        // Return the head of reversed linked list
        return prevNode;
    }

    // This function prints the contents
    // of the linked list starting from the head
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
    }

}

class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

