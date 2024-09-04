package johnderinger;

import java.util.ArrayList;
import java.util.List;

/**
 * Have the function BracketCombinations(num) read num which will be an integer greater than or equal to zero,
 * and return the number of valid combinations that can be formed with num pairs of parentheses.
 * For example, if the input is 3, then the possible combinations of 3 pairs of parenthesis,
 * namely: ()()(), are ()()(), ()(()), (())(), ((())), and (()()). There are 5 total combinations when the input is 3,
 * so your program should return 5.
 */
public class BracketCombinations {
    public static List<String> generateParenthesis(int n) {
        // Initializes a list result to store the valid combinations.
        List<String> result = new ArrayList<>();
        // Calls the backtracking function backtrack to generate the combinations.
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: If the length of the current string equals max * 2 (i.e., all parentheses are used),
        // add the current string to the result list and return.
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Add open parenthesis: If the number of open parentheses (open) is less than max,
        // add an open parenthesis to the current string and recursively call backtrack with open incremented by 1.
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Add close parenthesis: If the number of close parentheses (close) is less than the number of
        // open parentheses (open), add a close parenthesis to the current string and recursively call
        // backtrack with close incremented by 1.
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> combinations = generateParenthesis(n);
        System.out.println(combinations);
    }
}
