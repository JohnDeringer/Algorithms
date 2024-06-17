/**
 * Created with IntelliJ IDEA.
 * User: jderinger
 * Date: 11/25/12
 * Time: 7:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class Node {
    private String name;
    private Node left;
    private Node right;

    public Node(String name) {
        this.name = name;
    }

    public void printValue() {
        System.out.println("Printing value [" + name + "]");
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
