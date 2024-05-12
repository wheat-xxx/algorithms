package examination.wei;

import java.time.LocalTime;
import java.time.chrono.MinguoChronology;

/**
 * @author wheat
 * @date 2024/03/23  10:48
 */
public class Solution_0323_2 {

    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }

    private int minDeletions(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int index = 0;
        int count = 0;
        while(index < stringBuilder.length()) {
            if(index + 1 < stringBuilder.length() && stringBuilder.charAt(index) == stringBuilder.charAt(index + 1)){
                stringBuilder.deleteCharAt(index + 1);
                count++;
            } else {
                index++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aaaabc";
        System.out.println(new Solution_0323_2().minDeletions(s));
    }

}
