package algorithms_02;

import java.util.*;

/**
 *
 *
 *
 * @author wheat
 * @date 2024/07/05  16:19
 */
public class Solution_127 {

    /**
     * 图的广度优先搜索遍历 - Queue
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                Iterator<String> iterator = set.iterator();
                while (iterator.hasNext()) {
                    String adj = iterator.next();
                    if (judge(node, adj)) {
                        // 结束条件
                        if (endWord.equals(adj)) {
                            return count + 1;
                        }

                        queue.offer(adj);
                        iterator.remove();
                    }
                }
            }
        }

        return 0;
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
    
}
