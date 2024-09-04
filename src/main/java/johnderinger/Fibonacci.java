package johnderinger;

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println("[" + fib(10) + "]");
    }

    private static long fib(long n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }



}
