package measure;

/**
 * @author <a href="mailto:john.deringer@sri.com">John Deringer</a>
 *         Date: 12/5/13 7:24 PM
 */
public class MyNewIncDec implements IncDec {

    private int x;

    public MyNewIncDec(int x) {
        this.x = x;
    }

    public void increment() {
        long startTime = System.currentTimeMillis();
        this.x++;
        System.out.println("count [" + x + "] incrementTime:" + (System.currentTimeMillis() - startTime));
    }

    public void decrement() {
        long startTime = System.currentTimeMillis();
        this.x--;
        System.out.println("count [" + x + "] decrementTime:" + (System.currentTimeMillis() - startTime));
    }

    public static void main(String[] args) {
        MyNewIncDec myNewIncDec = new MyNewIncDec(1000000000);

        for (int i = 0; i < 100000; i++) {
            myNewIncDec.increment();
        }

        for (int i = 0; i < 100000; i++) {
            myNewIncDec.decrement();
        }

    }

}
