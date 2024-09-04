package johnderinger.leetcode;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t
 *     (i.e., t is concatenated with itself one or more times).
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 * Example 1:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 *
 * Example 2:
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 *
 * Example 3:
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 *
 * Input
 * str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX"
 * str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"
 * Expected: "TAUXX"
 */
public class GreatestCommonDivisorOfStrings {

    public static void main (String[] args) {
        GreatestCommonDivisorOfStrings g = new GreatestCommonDivisorOfStrings();
//        String str1 = "ABCABC";
//        String str2 = "ABC";
//        String str1 = "ABABAB";
//        String str2 = "ABAB";
//        String str1 = "LEET";
//        String str2 = "CODE";
//        String str1 = "ABAB";
//        String str2 = "ABABAB";
        String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        // Output: "TAUXX"
        System.out.println("Output: " + g.gcdOfStrings(str1, str2));
    }

//    String origString2 = null;

    public String gcdOfStrings(String string1, String string2) {
        if (string1 == null || string1.isEmpty() || string2 == null || string2.isEmpty()) {
            return "";
        }

        if (string2.length() > string1.length()) {


            return gcdOfStrings(string2, string1);
        } else if (!string1.startsWith(string2)) {
            return "";
        } else if (string1.equals(string2)) {
            return string2;
        }

        int foundIndex = string1.indexOf(string2);
        for (int i = foundIndex + string2.length(); i < string1.length(); i += string2.length()) {
            foundIndex = string1.indexOf(string2, i);
            if (foundIndex == -1 || foundIndex > i) {
                return gcdOfStrings(string1, string2.substring(0, string2.length() - 1));
            }
        }


        return string2;
    }

}
