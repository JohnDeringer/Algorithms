package johnderinger;

public class Kth_Smallest_Element_in_a_BST {
    int countElement = 0;

    public static void main(String[] args) {
        Kth_Smallest_Element_in_a_BST a = new Kth_Smallest_Element_in_a_BST();
        BstNode root = null;
/*
         8
        / \
       6   15
      / \   \
     2   7   20

     data[8]
     data[6]
     data[15]
     data[2]
     data[7]
     data[20]
*/
//        root = a.insert(root, 15);
        root = a.insert(root, 8);
        root = a.insert(root, 15);
        root = a.insert(root, 6);
        root = a.insert(root, 2);
        root = a.insert(root, 7); // Kth Smallest
        root = a.insert(root, 20);

        System.out.println("The ordered tree [" + root + "]");

        BstNode kthSmallest = a.getKthSmallestElementBST(root, 3);

        if (kthSmallest != null) {
            System.out.println("kthSmallest [" + kthSmallest.data + "]");
        } else {
            System.out.println("They're more values than given value");
        }
    }

    private BstNode insert(BstNode node, int val) {
        if (node == null) {
            System.out.println("insert node[null], create createNewNode val[" + val + "]");
            return createNewNode(val);
        } else {
            System.out.println("insert node data[" + node.data + "] left[" + node.left + "] right[" + node.right + "]");
        }

        if (val < node.data) {
            node.left = insert(node.left, val);
        } else if (val > node.data) {
            node.right = insert(node.right, val);
        }

        return node;
    }

    private BstNode getKthSmallestElementBST(BstNode node, int k) {
        if (node == null) {
            return null;
        }

        BstNode left = getKthSmallestElementBST(node.left, k);

        if (left != null) {
            return left;
        }

        countElement++;
        if (countElement == k) {
            return node;
        }

        return getKthSmallestElementBST(node.right, k);
    }

    private BstNode createNewNode(int k) {
        BstNode a = new BstNode();
        a.data = k;
        a.left = null;
        a.right = null;
        return a;
    }

}

class BstNode {
    BstNode left;
    BstNode right;
    int data;

    @Override
    public String toString() {
        return "BstNode{" +
                "data[" + data + "] " +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

//    public String nodeData(BstNode node) {
//        StringBuilder sb = new StringBuilder();
//        for (int n : node.data) {
//            sb.append(n);
//
//        }
//
//        return "BstNode{" +
//                "data=" + data +
//                '}';
//    }

}
