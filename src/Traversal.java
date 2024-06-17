import java.util.Stack;

public class Traversal {
    static void preorderTraversal(Node root) {
        System.out.println("Node [" + root + "]");
        if (root == null) return;
        root.printValue();
        preorderTraversal(root.getLeft());
        preorderTraversal(root.getRight());
    }

    public static void main(String[] args) {
        Node root = new Node("root");
        Node left = new Node("left");
        Node right = new Node("right");

        root.setLeft(left);
        root.setRight(right);

        // Recursion
        boolean recursion = false;
        if (recursion) {
            preorderTraversal(root);
        } else {
            Stack<Node> stack = new Stack<Node>();
            stack.push(root);
            while (true) {
                Node curr = null;
                try {
                    curr = (Node) stack.pop();
                } catch (Exception e) {
                }
                if (curr == null) {
                    break;
                }

                curr.printValue();
                Node n = curr.getRight();
                if (n != null) {
                    stack.push(n);
                }

                n = curr.getLeft();
                if (n != null) {
                    stack.push(n);
                }
            }
        }

    }
}
