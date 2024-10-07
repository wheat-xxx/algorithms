package algorithms_02;

import sun.text.resources.uk.FormatData_uk_UA;

import javax.smartcardio.TerminalFactory;
import java.util.*;

/**
 * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，
 * 一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 *      每对相邻的单词之间仅有单个字母不同。
 *      转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
 *      sk == endWord
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，
 * 如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
 *
 * @author wheat
 * @date 2024/07/08  20:31
 */
public class Solution_126 {

//    /**
//     * 思路：回溯算法 - 暴力解法 - 超出时间限制
//     * @param beginWord
//     * @param endWord
//     * @param wordList
//     * @return
//     */
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<Integer> selects = new ArrayList<>();
//        for (int i = 0; i < wordList.size(); i++) {
//            if (wordList.get(i).equals(beginWord)) {
//                selects.add(i);
//            }
//        }
//        // wordList 没有 beginWord
//        if (selects.isEmpty()) {
//            wordList.add(beginWord);
//            selects.add(wordList.size() - 1);
//        }
//
//        int n = wordList.size();
//        used = new boolean[n];
//        this.wordList = wordList;
//
//        backtrack(selects, endWord);
//
////        return res;
//        // res里面是所有的转换序列
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < res.size(); i++) {
//            min = Math.min(res.get(i).size(), min);
//        }
//
//        List<List<String>> retVal = new ArrayList<>();
//        for (List<String> strs : res) {
//            if (strs.size() == min) {
//                retVal.add(strs);
//            }
//        }
//        return retVal;
//    }
//
//    private List<List<String>> res = new ArrayList<>();
//    private List<String> trace = new ArrayList<>();
//    private boolean[] used;
//    private List<String> wordList;
//
//    /**
//     * 回溯算法框架
//     * @param selects
//     * @param endWord
//     */
//    private void backtrack(List<Integer> selects, String endWord) {
//
//        // 结束条件
//        if (!trace.isEmpty() && trace.get(trace.size() - 1).equals(endWord)) {
//            res.add(new ArrayList<>(trace));
//            return;
//        }
//
//        for (Integer select : selects) {
//            // 做选择
//            trace.add(wordList.get(select));
//            used[select] = true;
//            // 获取新一轮的选择列表
//            List<Integer> selectNew = new ArrayList<>();
//            for (int i = 0; i < wordList.size(); i++) {
//                if (!used[i] && judge(wordList.get(select), wordList.get(i))) {
//                    selectNew.add(i);
//                }
//            }
//            backtrack(selectNew, endWord);
//            // 撤销选择
//            trace.remove(trace.size() - 1);
//            used[select] = false;
//        }
//
//    }
//
//    /**
//     * 判断两个字符串是否只相差一个字符
//     * @param s1
//     * @param s2
//     * @return
//     */
//    private boolean judge(String s1, String s2) {
//        int n = s1.length();
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            if (s1.charAt(i) != s2.charAt(i)) {
//                count++;
//            }
//        }
//        return count == 1;
//    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 广度优先搜索遍历 - 回溯
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        set.remove(beginWord);

        Map<String, Integer> steps = new HashMap<>();
        steps.put(beginWord, 0);
        Map<String, List<String>> from = new HashMap<>();

        boolean found = false;
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 遍历每一层的结点
            for (int i = 0; i < size; i++) {
                String curNode = queue.poll();
                char[] chs = curNode.toCharArray();
                // 单词的每一个位置进行替换
                for (int j = 0; j < chs.length; j++) {
                    char origin = chs[j];
                    // 每个位置共有26种替换
                    for (char k = 'a'; k <= 'z'; k++) {
                        chs[j] = k;
                        String nextNode = String.valueOf(chs);

                        // 如果from中已有next，且层次与当前相同，则表明，本层还有其他节点同样指向了这个nextWord
                        // 这时dict中已经不存在nextWord了,则直接加入from
                        if (steps.containsKey(nextNode) && steps.get(nextNode) == step) {
                            from.get(nextNode).add(curNode);
                            continue;
                        }

                        // 枚举的单词不存在或者已经遍历过了，则跳过
                        if (!set.contains(nextNode)) {
                            continue;
                        }

                        // nextNode在wordList中
                        queue.offer(nextNode);
                        set.remove(nextNode);
                        steps.put(nextNode, step);
                        from.putIfAbsent(nextNode, new ArrayList<>());
                        from.get(nextNode).add(curNode);
                        // 判断nextNode是否为最终目标，第一个遍历到endWord的层数，就是最短路径
                        if (nextNode.equals(endWord)) {
                            found = true;
                        }
                    }
                    chs[j] = origin;
                }
            }
            if (found) break;
            step++;
        }

        if (found) {
            trace.addFirst(endWord);
            backtrack(from, endWord, beginWord);
        }

        return res;

    }

    private List<List<String>> res = new ArrayList<>();
    private Deque<String> trace = new LinkedList<>();

    /**
     * 回溯框架
     * @param from
     * @param curNode
     * @param beginWord
     */
    private void backtrack(Map<String, List<String>> from, String curNode, String beginWord) {
        // 结束条件
        if (curNode.equals(beginWord)) {
            res.add(new ArrayList<>(trace));
            return;
        }

        for (String node : from.get(curNode)) {
            // 做选择
            trace.addFirst(node);
            backtrack(from, node, beginWord);
            // 撤销选择
            trace.removeFirst();
        }
    }

}
