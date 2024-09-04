package johnderinger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class IsHappy {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int temp = n;
            int sum = 0;
            while (temp != 0) {
                int digital = temp % 10;
                sum += digital * digital;
                temp /= 10;
            }
            if (!set.add(sum)) return false;
            n = sum;
        }
        return true;
    }


}
