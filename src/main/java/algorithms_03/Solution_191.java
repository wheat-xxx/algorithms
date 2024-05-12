package algorithms_03;

/**
 * @author wheat
 * @date 2023/12/14  20:37
 */
public class Solution_191 {

    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') count++;
        }

        return count;
    }

    public int hammingWeight_2(int n) {
        int count = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            if((n & 1) == 1) count++;
            n >>>= 1;
        }

        return count;
    }

}
