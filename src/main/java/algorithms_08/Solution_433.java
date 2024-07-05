package algorithms_08;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 最小基因变换
 *
 * 如何判断两个字符串只有一位不相同呢？
 *
 * @author wheat
 * @date 2024/07/05  9:34
 */
public class Solution_433 {

    /**
     * 图的广度优先搜索遍历 寻找两点之间的最短距离
     * 牛逼
     * @param startGene
     * @param endGene
     * @param bank
     * @return
     */
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[bank.length];

        queue.offer(startGene);
        for (int i = 0; i < bank.length; i++) {
            if (startGene.equals(bank[i])) {
                visited[i] = true;
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                for (int k = 0; k < bank.length; k++) {
                    if (!visited[k] && judge(node, bank[k])) {
                        // 结束条件
//                    if (bank[k] == endGene) {
//                        return count;
//                    }
                        if (endGene.equals(bank[k])) {
                            return count;
                        }

                        visited[k] = true;
                        queue.offer(bank[k]);
                    }
                }
            }
        }

        return -1;
    }

    private boolean judge(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_433().minMutation("AAAACCCC", "CCCCCCCC",
                new String[]{"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"}));
    }

}
