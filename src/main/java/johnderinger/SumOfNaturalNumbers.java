package johnderinger;

public class SumOfNaturalNumbers {

    public static void main (String[] args) {
        System.out.println(sumTheNumbers(5));
    }


    public static int sumTheNumbers (int number) {
        if (number <= 1) {
            return 1;
        }

        return number + sumTheNumbers(--number);
    }
}
