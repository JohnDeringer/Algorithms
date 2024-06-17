/**
 * Created with IntelliJ IDEA.
 * User: jderinger
 * Date: 1/17/13
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class RefTest {

    public RefTest() {
        Integer x = 1;
        methOne(x);
        System.out.println("x [" + x + "]");
    }

    public void methOne(Integer i) {
        System.out.println("methOne(1) [" + i + "]");
        i++;
        System.out.println("methOne(2) [" + i + "]");
    }

    public static void main(String[] args) {
        //String id = "1";
        //System.out.println("id-1 [" + id + "]");
        RefTest refTest = new RefTest();
       // System.out.println("id-2 [" + id + "]");
    }


}
