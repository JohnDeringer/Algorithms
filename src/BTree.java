/*************************************************************************
 *  Compilation:  javac BTree.java
 *  Execution:    java BTree
 *
 *  B-tree.
 *
 *  Limitations
 *  -----------
 *   -  Assumes M is even and M >= 4
 *   -  should b be an array of children or list (it would help with
 *      casting to make it a list)
 *
 *************************************************************************/
public class BTree<Key extends Comparable<Key>, Value> {

    private static final int MAX_CHILDREN_PER_TREE = 4;    // max children per B-tree node = M-1

    private Node root;             // root of the B-tree
    private int HEIGHT;                // height of the B-tree
    private int NUMBER_OF_ITEMS;                 // number of key-value pairs in the B-tree

    // helper B-tree node data type
    private static final class Node {
        private int numberOfChildren;                             // number of children
        private Entry[] children = new Entry[MAX_CHILDREN_PER_TREE];   // the array of children

        private Node(int k) {
            numberOfChildren = k;
        }             // create a node with k children
    }

    // internal nodes: only use key and next
    // external nodes: only use key and value
    private static class Entry {
        private Comparable key;
        private Object value;
        private Node next;     // helper field to iterate over array entries

        public Entry(Comparable key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // constructor
    public BTree() {
        root = new Node(0);
    }

    // return number of key-value pairs in the B-tree
    public int size() {
        return NUMBER_OF_ITEMS;
    }

    // return height of B-tree
    public int height() {
        return HEIGHT;
    }


    // search for given key, return associated value; return null if no such key
    public Value get(Key key) {
        return search(root, key, HEIGHT);
    }

    private Value search(Node node, Key key, int height) {
        Entry[] children = node.children;

        // external node
        if (height == 0) {
            for (int j = 0; j < node.numberOfChildren; j++) {
                if (eq(key, children[j].key)) {
                    return (Value) children[j].value;
                }
            }
        }

        // internal node
        else {
            for (int j = 0; j < node.numberOfChildren; j++) {
                if (j + 1 == node.numberOfChildren || less(key, children[j + 1].key)) {
                    return search(children[j].next, key, height - 1);
                }
            }
        }
        return null;
    }


    // insert key-value pair
    // add code to check for duplicate keys
    public void put(Key key, Value value) {
        Node node = insert(root, key, value, HEIGHT);
        NUMBER_OF_ITEMS++;
        if (node == null) {
            return;
        }

        // need to split root
        Node newRootNode = new Node(2);
        newRootNode.children[0] = new Entry(root.children[0].key, null, root);
        newRootNode.children[1] = new Entry(node.children[0].key, null, node);
        root = newRootNode;
        HEIGHT++;
    }


    private Node insert(Node node, Key key, Value value, int height) {
        int j;
        Entry entry = new Entry(key, value, null);

        // external node
        if (height == 0) {
            for (j = 0; j < node.numberOfChildren; j++) {
                if (less(key, node.children[j].key)) {
                    break;
                }
            }
        }

        // internal node
        else {
            for (j = 0; j < node.numberOfChildren; j++) {
                if ((j + 1 == node.numberOfChildren) || less(key, node.children[j + 1].key)) {
                    Node u = insert(node.children[j++].next, key, value, height - 1);
                    if (u == null) {
                        return null;
                    }
                    entry.key = u.children[0].key;
                    entry.next = u;
                    break;
                }
            }
        }

        for (int i = node.numberOfChildren; i > j; i--) {
            node.children[i] = node.children[i - 1];
        }

        node.children[j] = entry;
        node.numberOfChildren++;

        if (node.numberOfChildren < MAX_CHILDREN_PER_TREE) {
            return null;
        } else {
            return split(node);
        }
    }

    // split node in half
    private Node split(Node existingNode) {
        Node newNode = new Node(MAX_CHILDREN_PER_TREE / 2);
        existingNode.numberOfChildren = MAX_CHILDREN_PER_TREE / 2;
        for (int j = 0; j < MAX_CHILDREN_PER_TREE / 2; j++) {
            newNode.children[j] = existingNode.children[MAX_CHILDREN_PER_TREE / 2 + j];
        }
        return newNode;
    }

    // for debugging
    public String toString() {
        return toString(root, HEIGHT, "") + "\n";
    }

    private String toString(Node node, int ht, String indent) {
        String s = "";
        Entry[] children = node.children;

        if (ht == 0) {
            for (int j = 0; j < node.numberOfChildren; j++) {
                s += indent + children[j].key + " " + children[j].value + "\n";
            }
        } else {
            for (int j = 0; j < node.numberOfChildren; j++) {
                if (j > 0) s += indent + "(" + children[j].key + ")\n";
                s += toString(children[j].next, ht - 1, indent + "     ");
            }
        }
        return s;
    }


    // comparison functions - make Comparable instead of Key to avoid casts
    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }

    private boolean eq(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }


    /**
     * **********************************************************************
     * test client
     * ***********************************************************************
     */
    public static void main(String[] args) {
        BTree<String, String> st = new BTree<String, String>();

//      st.put("www.cs.princeton.edu", "128.112.136.12");
        st.put("www.cs.princeton.edu", "128.112.136.11");
        st.put("www.princeton.edu", "128.112.128.15");
        st.put("www.yale.edu", "130.132.143.21");
        st.put("www.simpsons.com", "209.052.165.60");
        st.put("www.apple.com", "17.112.152.32");
        st.put("www.amazon.com", "207.171.182.16");
        st.put("www.ebay.com", "66.135.192.87");
        st.put("www.cnn.com", "64.236.16.20");
        st.put("www.google.com", "216.239.41.99");
        st.put("www.nytimes.com", "199.239.136.200");
        st.put("www.microsoft.com", "207.126.99.140");
        st.put("www.dell.com", "143.166.224.230");
        st.put("www.slashdot.org", "66.35.250.151");
        st.put("www.espn.com", "199.181.135.201");
        st.put("www.weather.com", "63.111.66.11");
        st.put("www.yahoo.com", "216.109.118.65");


        StdOut.println("cs.princeton.edu:  " + st.get("www.cs.princeton.edu"));
        StdOut.println("hardvardsucks.com: " + st.get("www.harvardsucks.com"));
        StdOut.println("simpsons.com:      " + st.get("www.simpsons.com"));
        StdOut.println("apple.com:         " + st.get("www.apple.com"));
        StdOut.println("ebay.com:          " + st.get("www.ebay.com"));
        StdOut.println("dell.com:          " + st.get("www.dell.com"));
        StdOut.println();

        StdOut.println("size:    " + st.size());
        StdOut.println("height:  " + st.height());
        StdOut.println(st);
        StdOut.println();
    }

}
