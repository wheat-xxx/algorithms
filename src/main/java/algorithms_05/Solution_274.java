package algorithms_05;

import java.util.Arrays;

/**
 * H指数
 * @author wheat
 * @date 2024/05/29  8:27
 */
public class Solution_274 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = 0, j = citations.length - 1;
        while (i < j) {
            int temp = citations[i];
            citations[i] = citations[j];
            citations[j] = temp;
            i++;
            j--;
        }
        int res = 0;
        for (int k = 0; k < citations.length; k++) {
            if (citations[k] >= k + 1) {
                res = k + 1;
            }
        }

        return res;
    }

}
