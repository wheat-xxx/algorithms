package algorithms_03;

import java.sql.SQLOutput;

/**
 * @author wheat
 * @date 2023/12/14  17:22
 */
public class Solution_190 {

    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

}
