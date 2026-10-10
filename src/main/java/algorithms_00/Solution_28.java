package algorithms_00;

/**
 * Description:
 *      找出字符串中第一个匹配项的下标
 * @author wheat
 * @date 2023/02/26  19:06
 */
public class Solution_28 {

//    public int strStr(String haystack, String needle) {
//
//        // 边界条件
//        if(haystack == null || needle == null || haystack.length() < needle.length()){
//            return -1;
//        }
//
//        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
//            if(needle.equals(haystack.substring(i,i+needle.length()))){
//                return i;
//            }
//        }
//
//        return -1;
//    }

//    public int strStr(String haystack, String needle){
//        haystack.indexOf(needle);
//    }

    // KMP算法
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) {
            return 0;
        }
        // 如果 haystack 比 needle 还短，不可能匹配，直接返回 -1
        if (n < m) {
            return -1;
        }

        // ---------- 1. 构建 needle 的 next 数组 ----------
        // next[i] 表示 needle[0..i] 这个子串的最长相等前后缀的长度
        // 例如 needle = "abab"，next = [0, 0, 1, 2]
        int[] next = new int[m];

        // i 从 1 开始，因为 i=0 时子串只有一个字符，最长相等前后缀长度为 0（next[0] 默认为 0）
        // j 表示当前已经匹配的前缀长度，初始为 0
        for (int i = 1, j = 0; i < m; i++) {
            // 当字符不匹配时，j 需要回退到 next[j-1] 的位置
            // 回退的目的是尝试用更短的前缀来匹配当前后缀
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            // 如果字符匹配，前缀长度 j 加 1
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            // 记录当前位置 i 的最长相等前后缀长度
            next[i] = j;
        }

        // ---------- 2. 在 haystack 中使用 next 数组进行匹配 ----------
        // i 遍历 haystack，j 表示当前 needle 中已经匹配的字符个数
        for (int i = 0, j = 0; i < n; i++) {
            // 当字符不匹配时，根据 next 数组回退 j
            // 注意：这里不需要回退 i，因为 i 是主串的指针，会继续向前
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            // 如果当前字符匹配，j 加 1
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            // 如果 j 等于 needle 的长度，说明 needle 已经完全匹配
            // 此时匹配的起始位置是 i - m + 1
            if (j == m) {
                return i - m + 1;
            }
        }

        // 遍历完 haystack 仍未找到匹配，返回 -1
        return -1;
    }

}
