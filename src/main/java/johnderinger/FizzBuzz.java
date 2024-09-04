package johnderinger;

public class FizzBuzz {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
//            doWork(i);
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void doWork(int value) {

        if (value % 3 == 0 && value % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (value % 3 == 0) {
            System.out.println("Fizz");
        } else if (value % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(value);
        }

//        StringBuffer output = new StringBuffer();
//        if (value % 3 == 0) {
//            output.append("Fizz");
//        }
//        if (value % 5 == 0) {
//            output.append("Buzz");
//        }
//        if (output.isEmpty()) {
//            output.append(String.valueOf(value));
//        }
//        System.out.println(value);
    }

}
