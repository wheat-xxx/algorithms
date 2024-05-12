package algorithms_03;

/**
 * @author wheat
 * @date 2023/12/07  16:30
 */
public class Solution_171 {

    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int multiple = 1;
        for(int i = columnTitle.length() - 1; i >= 0; i--) {
            int temp = columnTitle.charAt(i) - 'A' + 1;
            ans += temp * multiple;
            multiple *= 26;
        }

        return ans;
    }

}
