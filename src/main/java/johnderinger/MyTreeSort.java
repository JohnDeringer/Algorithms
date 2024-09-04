package johnderinger;

/**
 * Tree sort is a sorting algorithm that is based on Binary Search Tree data structure.
 * It first creates a binary search tree from the elements of the input list or array and then
 * performs an in-order traversal on the created binary search tree to get the elements in sorted order.
 * Complexity Analysis:
 *  Average Case Time Complexity: O(n log n) Adding one item to a Binary Search tree on average takes O(log n) time.
 *  Worst Case Time Complexity: O(n2). The worst case time complexity of Tree Sort can be improved by using a
 *   self-balancing binary search tree like Red Black Tree, AVL Tree. Using self-balancing binary tree Tree Sort
 *   will take O(n log n) time to sort the array in worst case.
 */
public class MyTreeSort {

    // Class containing left and
    // right child of current
    // node and key value
    class Node
    {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    MyTreeSort()
    {
        root = null;
    }

    // This method mainly
    // calls insertRec()
    void insert(int key)
    {
        root = insertRec(root, key);
    }

    /* A recursive function to
    insert a new key in BST */
    Node insertRec(Node root, int key)
    {

        /* If the tree is empty,
        return a new node */
        if (root == null)
        {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur
        down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the root */
        return root;
    }

    // A function to do
    // inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null)
        {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
    void treeins(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
            insert(arr[i]);
        }

    }

    // Driver Code
    public static void main(String[] args)
    {
        MyTreeSort tree = new MyTreeSort();
        int arr[] = {5, 4, 7, 2, 11};
        tree.treeins(arr);
        tree.inorderRec(tree.root);
    }

}
