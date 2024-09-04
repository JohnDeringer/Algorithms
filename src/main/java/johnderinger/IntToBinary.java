package johnderinger;

public class IntToBinary {


    public static void main (String[] args) {
        // 233 : 11101001
        System.out.println(findBinary(233, ""));
    }

    private static String findBinary(int number, String result) {
        if (number == 0) {
            return result;
        }

        // The first digit is at the far right, while the eighth digit is at the far left
        // 233 = 11101001
        // findBinary(233, "")
        //   233 % 2 = 1 : result = 1
        // findBinary(233 / 2, 1)
        //   116 % 2 = 0, result = 0->1
        // findBinary(116 / 2, 01)
        //   58 % 2 = 0, result = 0->01
        // findBinary(58 / 2, 001)
        //   29 % 2 = 1, result = 1->001
        // findBinary(29 / 2, 1001)
        //   14 % 2 = 0, result = 0->1001
        // findBinary(14 / 2, 01001)
        //   7 % 2 = 1, result = 1->01001
        // findBinary(7 / 2, 101001)
        //   3 % 2 = 1, result = 1->101001
        // findBinary(3 / 2, 1101001)
        //   1 % 2 = 1, result = 1->1101001
        // findBinary(1 / 2, 11101001)
        //   number == 0, return 11101001
        result = number % 2 + result;
        return findBinary(number / 2, result);
    }

}
