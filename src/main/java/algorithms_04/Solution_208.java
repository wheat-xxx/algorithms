package algorithms_04;

/**
 * @author wheat
 * @date 2024/02/26  15:52
 */
public class Solution_208 {

    /**
     * 树中的节点
     */
    class TrieNode {
        boolean isWord = false;     // 根节点->该节点 是否是一个单词
        TrieNode[] children = new TrieNode[26];     // 数组下标表示26个英文字母
    }

    /**
     * Trie树，字典树
     */
    class Trie {

        TrieNode root;  // 根节点

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode work = root;
            int index = -1;
            for (int i = 0; i < word.length(); i++) {
                index = (int)(word.charAt(i) - 'a');
                if(work.children[index] == null) {
                    work.children[index] = new TrieNode();
                }
                work = work.children[index];
            }
            work.isWord = true;
        }

        public boolean search(String word) {
            TrieNode work = root;
            int index = -1;
            for (int i = 0; i < word.length(); i++) {
                index = (int)(word.charAt(i) - 'a');
                if(work.children[index] == null) {
                    return false;
                }
                work = work.children[index];
            }
            return work.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode work = root;
            int index = -1;
            for (int i = 0; i < prefix.length(); i++) {
                index = (int)(prefix.charAt(i) - 'a');
                if(work.children[index] == null) {
                    return false;
                }
                work = work.children[index];
            }
            return true;
        }
    }

}
