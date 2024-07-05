package algorithms_04;

import java.util.HashSet;
import java.util.ServiceConfigurationError;
import java.util.Set;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串 是否与任何先前添加的字符串匹配。
 * 实现词典类 WordDictionary ：
 *      WordDictionary() 初始化词典对象
 *      void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 *      bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true；否则，返回 false。
 *      word 中可能包含一些 '.'，每个 . 都可以表示任何一个字母。
 *
 * 字典树
 *
 * @author wheat
 * @date 2024/07/02 9:05
 */
public class Solution_211 {

    /**
     * 字典树中的结点 这里用的是树中的边
     */
    private class TrieNode {
        boolean isWord = false; // 根节点->该节点 是否是一个单词
        TrieNode[] children = new TrieNode[26];
    }

    class WordDictionary {

        private TrieNode root = new TrieNode();

        public WordDictionary() {

        }

        public void addWord(String word) {
            TrieNode work = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (work.children[index] == null) {
                    TrieNode node = new TrieNode();
                    work.children[index] = node;
                }
                work = work.children[index];
            }
            work.isWord = true;
        }

        /**
         * 递归实现
         * @param word
         * @return
         */
        public boolean search(String word) {
            return search(word, 0, root);
        }

        private boolean search(String word, int index, TrieNode root) {
            int index_temp = word.charAt(index) - 'a';

            // 结束条件
            if (index == word.length() - 1) {
                if (word.charAt(index) != '.' && root.children[index_temp] != null && root.children[index_temp].isWord) {
                    return true;
                }
                if (word.charAt(index) == '.') {
                    for (int i = 0; i < 26; i++) {
                        if (root.children[i] != null && root.children[i].isWord) {
                            return true;
                        }
                    }
                }
                return false;
            }

            // 两种情况 word.charAt(index) == '.'
            // a - z
            if (word.charAt(index) != '.' && root.children[index_temp] != null) {
                boolean flag = search(word, index + 1, root.children[index_temp]);
                if (flag) return true;
            }

            // .
            if (word.charAt(index) == '.') {
                for (int i = 0; i < 26; i++) {
                    if (root.children[i] != null) {
                        boolean flag = search(word, index + 1, root.children[i]);
                        if (flag) return true;
                    }
                }
            }

            return false;
        }
    }

}
