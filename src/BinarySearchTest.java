import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: jderinger
 * Date: 9/3/12
 * Time: 10:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 7, 9, 5};
        Arrays.sort(arr);
        System.out.println(BinarySearch.search(arr, 2));
    }

}
