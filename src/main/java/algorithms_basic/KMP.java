package algorithms_basic;

/**
 * @author wheat
 * @date 2024/05/15  19:49
 */
public class KMP {

    /**
     * 构建next数组
     * @param pattern
     * @return
     */
    private int[] getNext(char[] pattern) {
        /*
         * next[i] 表示i的最长公共前后缀中前缀的下一个元素
         * -1 表示没有公共前缀和后缀
         */
        int[] next = new int[pattern.length];
        next[0] = -1;
        int j = -1;
        int i = 0;
        while (i < pattern.length - 1) {
            if (j == -1 || pattern[i] == pattern[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];    // 精髓所在
            }
        }
        return next;
    }

    /**
     * KMP算法匹配
     * @param text
     * @param pattern
     * @return 匹配返回text中的起始位置 否则返回-1
     */
    public int kmpSearch(String text, String pattern) {
        if (text == null || pattern == null || text.length() < pattern.length()) return -1;

        char[] textArray = text.toCharArray();
        char[] patternArray = pattern.toCharArray();
        int[] next = getNext(patternArray);
        int i = 0;
        int j = 0;
        while (i < textArray.length && j < patternArray.length) {
            if (j == -1 || textArray[i] == patternArray[j]) {
                i++;
                j++;
            } else {    // textArray[i] != patternArray[j]
                j = next[j];        // 最长公共前缀和后缀 next[j]就是后缀的下一个位置
            }
        }
        if (j == patternArray.length) {
            return i - j;   // 匹配成功，返回匹配的起始位置
        } else {
            return -1;      // 匹配失败
        }
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String text = "ABABCABABCD";
        String pattern = "ABABCD";
        int position = kmp.kmpSearch(text, pattern);
        if (position != -1) {
            System.out.println("Pattern found at index: " + position);
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }

}
