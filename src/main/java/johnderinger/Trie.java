package johnderinger;

import java.util.Arrays;

/*
TrieNode:
Each TrieNode holds an array of 26 child nodes, one for each lowercase letter.
It also has a boolean flag isEnd to indicate if a word ends at this node.

Trie:
The Trie class has a root node that is initialized as an empty TrieNode.

insert(word):
It iterates through the characters in the word.
For each character, it checks if there's a corresponding child node in the current node.
If not, it creates a new child node.
It moves to the child node and repeats until the end of the word.
Finally, it marks the last node as the end of a word.

search(word):
It iterates through the characters in the word.
For each character, it checks if there's a corresponding child node.
If not, the word does not exist.
If it reaches the end of the word, it checks if the last node is marked as the end of a word.

startsWith(prefix):
It's similar to search, but only checks if the prefix exists in the Trie, not if it's a complete word.

Complexity:

Time complexity:
insert, search, and startsWith are all O(n), where n is the length of the input string.

Space complexity:
O(n * k), where n is the number of words inserted and k is the maximum length of a word.
 */
class Trie {
    private TrieNode root;

    public static void main (String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("search(\"apple\") [" + trie.search("apple") + "]");   // return True
        System.out.println("search(\"app\") [" + trie.search("app") + "]");     // return False
        System.out.println("startsWith(\"app\") [" + trie.startsWith("app") + "]"); // return True
        trie.insert("app");
        System.out.println("search(\"app\") [" + trie.search("app") + "]");    // return True
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.containsKey(ch)) {
                return null;
            }
            node = node.get(ch);
        }
        return node;
    }

    private class TrieNode {
        private TrieNode[] children;
        private boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }

        public boolean containsKey(char ch) {
            return children[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return children[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            // Subtract 1 from ch
            System.out.println("put index [" + (ch - 'a') + "] value [" + ch + "]");
            children[ch - 'a'] = node;
//            System.out.println("put children [" + Arrays.toString(children) + "]");
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

        @Override
        public String toString() {
//            return Arrays.toString(children);
            return "TrieNode{" +
                    "children=" + Arrays.toString(children) +
                    ", isEnd=" + isEnd +
                    '}';
        }
    }
}
