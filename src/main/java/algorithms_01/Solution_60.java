package algorithms_01;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/07  18:59
 */
public class Solution_60 {

    private boolean[] used;

    private int[] factorial;

    private int n;
    private int k;

    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        calculateFactorial(n);
        used = new boolean[n + 1];

        Arrays.fill(used, false);

        StringBuilder path = new StringBuilder();
        dfs(0, path);
        return path.toString();
    }

    private void calculateFactorial(int n){
        factorial = new int[n + 1];
        factorial[0] = 1;
        for(int i = 1; i <= n; i++){
            factorial[i] = i * factorial[i - 1];
        }
    }

    private void dfs(int index, StringBuilder path){
        if(index == n) return;
        int cnt = factorial[n - 1 - index];
        for(int i = 1; i <= n; i++){
            if(used[i]) continue;
            if(cnt < k){
                k -= cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(index + 1, path);
            return;
        }
    }
}
