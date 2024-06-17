import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: jderinger
 * Date: 11/3/13
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringManipulation {

    public static Character firstNonRepeated(String str) {
        HashMap<Character, Integer> charHash = new HashMap<Character, Integer>();
        int i, length;
        Character c;
        Integer count;

        length = str.length();

        for (i = 0; i < length; i++) {
            c = str.charAt(i);
            count = charHash.get(c);
            if (count == null) {
                charHash.put(c, 1);
            } else {
                charHash.put(c, ++count);
            }
        }

        for (i = 0; i < length; i++) {
            c = str.charAt(i);
            if ((charHash.get(c)) == 1) {
                return c;
            }
        }

        return null;
    }

    public static Character firstNonRepeated2(String str) {
        HashMap<Character, Object> charHash = new HashMap<Character, Object>();
        int i, length;
        Character c;
        Object seenOnce = new Object();
        Object seenTwice = new Object();

        length = str.length();

        for (i = 0; i < length; i++) {
            c = str.charAt(i);
            Object o = charHash.get(c);
            if (o == null) {
                charHash.put(c, seenOnce);
            } else if (o == seenOnce){
                charHash.put(c, seenTwice);
            }
        }

        for (i = 0; i < length; i++) {
            c = str.charAt(i);
            if (charHash.get(c) == seenOnce) {
                return c;
            }
        }

        return null;
    }

    public static String removeChars(String str, String remove) {
        StringBuilder sb = new StringBuilder();
        List<Character> rmvList = new ArrayList<Character>();

        for (char r : remove.toCharArray()) {
            rmvList.add(r);
        }

        for (char s : str.toCharArray()) {
            if (!rmvList.contains(s)) {
                sb.append(s);
            }
        }

        return sb.toString();
    }

    public static String removeChars2(String str, String remove) {
        for (char r : remove.toCharArray()) {
            str = str.replace(r, '\0');
        }

        return str;
    }

    public static String reverseWords(String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static int factorialR(int n) {
        if (n > 1) {
            return factorialR(n - 1) * n;
        } else {
            return 1;
        }
    }

    public static int factorialI(int i) {
        int n, val = 1;
        for (n = i; n > 1; n--) {
            val *= n;
        }
        return val;
    }

    public static int factorial(int i) {
        int v = 1;
        for (;i > 1; i--) {
            v *= i;
        }
        return v;
    }

    public static void main(String[] args) {
//        System.out.println(firstNonRepeated("abcdefgabcde"));
//        System.out.println(firstNonRepeated2("abcdefgabcde"));
//
//        System.out.println(removeChars("abcdefgabcde", "fge"));
//        System.out.println(removeChars2("abcdefgabcde", "fge"));
//
//        System.out.println(reverseWords("Go Home Now"));

        System.out.println(factorialR(4));
        System.out.println(factorialI(4));
        System.out.println(factorial(4));
    }

}
