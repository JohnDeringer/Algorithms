package measure;

/**
 * @author <a href="mailto:john.deringer@sri.com">John Deringer</a>
 *         Date: 12/5/13 7:18 PM
 */
public class MyIncDec implements IncDec {

    private int x;

    public MyIncDec(int x) {
        this.x = x;
    }

    public void increment() {
        this.x++;
    }

    public void decrement() {
        this.x--;
    }

}
