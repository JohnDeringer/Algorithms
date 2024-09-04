package johnderinger;

public class RunLengthEncoding {

    public static void main (String[] args) {
        System.out.println(encode("aahhhhhgtttxjjwwwabb"));
    }

    public static String encode(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        char[] inputChars = input.toCharArray();
        char prevChar = 0;
        int counter = 1;
        StringBuilder outputSB = new StringBuilder();

        for (char inputChar : inputChars) {
            if (inputChar == prevChar) {
                counter++;
            } else if (prevChar != 0) {
                outputSB.append(counter).append(prevChar);
                counter = 1;
            }
            prevChar = inputChar;
        }
        outputSB.append(counter).append(prevChar);

        return outputSB.toString();
    }

}
