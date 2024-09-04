package johnderinger.leetcode;

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
 *   starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 *
 * Return the merged string.
 *
 * Example 1:
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 *
 * Example 2:
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 *
 * Example 3:
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 */
public class MergeStringsAlternately {

    public static void main (String[] args) {
        MergeStringsAlternately m = new MergeStringsAlternately();
//        String word1 = "abc";
//        String word2 = "pqr";
        // Output: "apbqcr"
//        String word1 = "ab";
//        String word2 = "pqrs";
        // Output: "apbqrs"
        String word1 = "abcd";
        String word2 = "pq";
        // Output: "apbqcd"
        System.out.println(m.mergeAlternately(word1, word2));

    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder output = new StringBuilder();
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();
        int maxLength = Math.max(word1.length(), word2.length());
        for (int i = 0; i < maxLength; i++) {
            if (i < word1Chars.length) {
                output.append(word1Chars[i]);
            }
            if (i < word2Chars.length) {
                output.append(word2Chars[i]);
            }
        }

        return output.toString();
    }


}
