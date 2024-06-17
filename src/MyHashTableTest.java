/**
 * Created with IntelliJ IDEA.
 * User: jderinger
 * Date: 10/27/12
 * Time: 9:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyHashTableTest {

    public static void main(String[] args) {

        // Test default constructor (initialCapacity = 11, loadFactor = .75)
        MyHashTable myHashTable = new MyHashTable();
        int numberOfItems = 7;
        for (int i = 0; i < numberOfItems; i++) {
            myHashTable.put("item:" + i, "value:" + i);
        }

        // Test size
        if (myHashTable.size() != numberOfItems) {
            System.err.print("Expected size [" + numberOfItems +
                    "] but received [" + myHashTable.size() + "]");
            System.exit(0);
        }

        // Test contains
        for (int i = 0; i < numberOfItems; i++) {
            if (!myHashTable.containsValue("value:" + i)) {
                System.err.print("Expected contains [true] but received [" +
                        myHashTable.containsValue("value:" + i) + "]");
                System.exit(0);
            }
        }

        // Test containsKey
        for (int i = 0; i < numberOfItems; i++) {
            if (!myHashTable.containsKey("item:" + i)) {
                System.err.print("Expected containsKey [true] but received [" +
                        myHashTable.containsKey("item:" + i) + "]");
                System.exit(0);
            }
        }

        // Test get operation
        for (int i = 0; i < numberOfItems; i++) {
            if (!myHashTable.get("item:" + i).equals("value:" + i)) {
                System.err.print("Expected value [" + "value:" + i +
                        "] but received [" + myHashTable.get("item:" + i) + "]");
                System.exit(0);
            }
        }

        // Add an item
        myHashTable.put("item:7", "value:7");

        // Retrieve the item
        Object item7 = myHashTable.get("item:7");
        if (item7 == null || !item7.equals("value:7")) {
            System.err.print("Expected value [value:7] but received [" +
                    myHashTable.get("item:7") + "]");
            System.exit(0);
        }

        // Test size
        if (myHashTable.size() != numberOfItems + 1) {
            System.err.print("Expected size [" + (numberOfItems+ 1) +
                    "] but received [" + myHashTable.size() + "]");
            System.exit(0);
        }

        // Test contains
        if (!myHashTable.containsValue("value:7")) {
            System.err.print("Expected contains [true] but received [" +
                    myHashTable.containsValue("value:7") + "]");
            System.exit(0);
        }

        // Test containsKey
        if (!myHashTable.containsKey("item:7")) {
            System.err.print("Expected containsKey [true] but received [" +
                    myHashTable.containsKey("item:7") + "]");
            System.exit(0);
        }

        // Remove an item
        myHashTable.remove("item:5");

        // Retrieve the item
        if (myHashTable.get("item:5") != null) {
            System.err.print("Expected value [null] but received [" +
                    myHashTable.get("item:5") + "]");
            System.exit(0);
        }

        // Test size
        if (myHashTable.size() != numberOfItems) {
            System.err.print("Expected size [" + numberOfItems +
                    "] but received [" + myHashTable.size() + "]");
            System.exit(0);
        }

        // Test contains
        if (myHashTable.containsValue("value:5")) {
            System.err.print("Expected contains [false] but received [" +
                    myHashTable.containsValue("value:5") + "]");
            System.exit(0);
        }

        // Test containsKey
        if (myHashTable.containsKey("item:5")) {
            System.err.print("Expected containsKey [false] but received [" +
                    myHashTable.containsKey("item:5") + "]");
            System.exit(0);
        }

        // Add 5 more items to test rehash
        int numberOfNewItems = 7;
        for (int i = 8; i < (8 + numberOfNewItems); i++) {
            myHashTable.put("item:" + i, "value:" + i);
        }

        // Test contains
        for (int i = 0; i < (8 + numberOfNewItems); i++) {
            if (i != 5 && !myHashTable.containsValue("value:" + i)) {
                System.err.print("Expected contains [true] but received [" +
                        myHashTable.containsValue("value:" + i) + "]");
                System.err.println();
                System.exit(0);
            }
        }

        // Test containsKey
        for (int i = 0; i < (8 + numberOfNewItems); i++) {
            if (i != 5 && !myHashTable.containsKey("item:" + i)) {
                System.err.print("Expected containsKey [true] but received [" +
                        myHashTable.containsKey("item:" + i) + "]");
                System.err.println();
                System.exit(0);
            }
        }

        // Test size
        if (myHashTable.size() != (8-1 + numberOfNewItems)) {
            System.err.print("Expected size [" + (8-1 + numberOfNewItems) +
                    "] but received [" + myHashTable.size() + "]");
            System.exit(0);
        }

        // Test get operation
        for (int i = 0; i < (8 + numberOfNewItems); i++) {
            if (i != 5 && !myHashTable.get("item:" + i).equals("value:" + i)) {
                System.err.print("Expected value [" + "value:" + i +
                        "] but received [" + myHashTable.get("item:" + i) + "]");
                System.exit(0);
            }
        }

        // Test values operation
        Object[] values = myHashTable.values();
        System.out.print("values:");
        for (Object value : values) {
            System.out.print("[" + value + "]");
        }
        System.out.println();

        // Test keys operation
        Object[] keys = myHashTable.keys();
        System.out.print("keys:");
        for (Object key : keys) {
            System.out.print("[" + key + "]");
        }
        System.out.println();

        System.out.println("values.length [" + values.length + "]");
        // Remove an item
        myHashTable.remove("item:11");
        System.out.println("Removed - item:11");

        // Test values operation
        values = myHashTable.values();
        System.out.println("values.length [" + values.length + "]");
        System.out.print("values:");
        for (Object value : values) {
            System.out.print("[" + value + "]");
        }
        System.out.println();

        // Test keys operation
        keys = myHashTable.keys();
        System.out.print("keys:");
        for (Object key : keys) {
            System.out.print("[" + key + "]");
        }
        System.out.println();

        System.out.println("toString()-" + myHashTable.toString());

        // Test Clear
        myHashTable.clear();
        if (myHashTable.size() != 0) {
            System.err.print("Expected size [0] but received [" +
                    myHashTable.size() + "]");
            System.exit(0);
        }

        System.out.println("Success...");
    }
}
