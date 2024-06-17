/**
 * The load factor is a measure of how full the hash table is allowed to get before its
 * capacity is automatically increased. When the number of entries in the hashtable
 * exceeds the product of the load factor and the current capacity, the capacity is
 * increased by calling the rehash method.
 *
 * This is my HashTable implementation using only arrays. It does not accept 'null' keys
 *  Does it accept 'null' values?
 */
public class MyHashTable {

    private Object[] keys;
    private Object[] values;
    int initialCapacity;
    double loadFactor;

    public MyHashTable() {
        this(11);
    }

    public MyHashTable(int initialCapacity) {
        this(initialCapacity, .75);
    }

    public MyHashTable(int initialCapacity, double loadFactor) {
        this.initialCapacity = initialCapacity;
        this.loadFactor = loadFactor;
        keys = new Object[initialCapacity];
        values = new Object[initialCapacity];
    }

    public boolean containsValue(Object value) {
        boolean contains = false;
        for (Object v : values) {
            if (v != null && v.equals(value)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public boolean containsKey(Object key) {
        boolean contains = false;
        for (Object k : keys) {
            if (k != null && k.equals(key)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public Object get(Object key) {
        Object value = null;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null && keys[i].equals(key)) {
                value = values[i];
                break;
            }
        }
        return value;
    }

    public void put(Object key, Object value) {
        if (key != null) {
            int nextAvailableIndex = getNextAvailableIndex();
            keys[nextAvailableIndex] = key;
            values[nextAvailableIndex] = value;
            if (size() > (keys.length * loadFactor)) {
                rehash();
            }
        }
    }

    public Object remove(Object key) {
        Object value = null;
        if (key != null) {
            for (int i = 0; i < keys.length; i++) {
                if (keys[i] != null && keys[i].equals(key)) {
                    value = values[i];
                    // null the values of key and value arrays
                    keys[i] = null;
                    values[i] = null;
                    break;
                }
            }
        }
        return value;
    }

    public void clear() {
        for (int i = 0; i < keys.length; i++) {
            keys[i] = null;
            values[i] = null;
        }
    }

    public Object[] keys() {
        Object[] rtnKeys = new Object[size()];
        int i = 0;
        for (Object key : keys) {
            if (key != null) {
                rtnKeys[i] = key;
                i++;
            }
        }
        return rtnKeys;
    }

    public Object[] values() {
        Object[] rtnValues = new Object[size()];
        int i = 0;
        for (Object value : values) {
            if (value != null) {
                rtnValues[i] = value;
                i++;
            }
        }
        return rtnValues;
    }

    public int size() {
        int count = 0;
        for (Object key : keys) {
            if (key != null) {
                count++;
            }
        }
        return count;
    }

    public String toString() {
        int size = size();
        Object[] keys = keys();
        Object[] values = values();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("[");
            sb.append(keys[i]);
            sb.append("=");
            sb.append(values[i]);
            sb.append("]");
            if (i < size - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    protected void rehash() {
        // Create tmp arrays
        int size = size();
        Object[] tmp_keys = new Object[size];
        Object[] tmp_values = new Object[size];

        // Copy keys and values into tmp arrays
        Object[] keys = keys();
        Object[] values = values();
        System.arraycopy(keys, 0, tmp_keys, 0, keys.length);
        System.arraycopy(values, 0, tmp_values, 0, values.length);

        // Increase size of global key and value arrays
        this.keys = new Object[tmp_keys.length + initialCapacity];
        this.values = new Object[tmp_values.length + initialCapacity];

        // Copy tmp arrays into global key and value arrays
        System.arraycopy(tmp_keys, 0, this.keys, 0, tmp_keys.length);
        System.arraycopy(tmp_values, 0, this.values, 0, tmp_keys.length);
    }

    private int getNextAvailableIndex() {
        int nextAvailableIndex = 0;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null) {
                nextAvailableIndex = i;
                break;
            }
        }
        return nextAvailableIndex;
    }


}
