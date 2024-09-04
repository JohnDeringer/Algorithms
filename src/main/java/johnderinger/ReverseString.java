package johnderinger;

public class ReverseString {

    public static void main(String[] args) {
//        String input = "The Man Ran Up The hill";

        System.out.println(reverseString("The Man Ran Up The hill"));
    }

    public static String reverseString(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        System.out.println("subString [" + input.substring(1) + "] input.charAt(0) [" + input.charAt(0) + "]");

        return reverseString(input.substring(1)) + input.charAt(0);
    }

}
