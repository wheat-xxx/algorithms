package algorithms_04;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wheat
 * @date 2023/12/18  20:07
 */
public class Solution_202 {

//    public boolean isHappy(int n) {
//        long others = n;
//        for (int i = 0; i < 1000; i++) {
//            others = square(others);
//            if(others == 1) return true;
//        }
//        return false;
//    }
//
//    private long square(long n) {
//        long res = 0;
//        while(n != 0) {
//            long others = n % 10;
//            res += others * others;
//            n = n / 10;
//        }
//        return res;
//    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public boolean isHappy_2(int n) {
        int slow = n;
        int fast = getNext(n);
        while(fast != 1 && fast != slow) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n) {
        int res = 0;
        while(n > 0) {
            int digit = n % 10;
            res += digit * digit;
            n = n / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution_202().isHappy_2(19);
    }



}
