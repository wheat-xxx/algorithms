package capriccio.array;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * @author wheat
 * @date 2024/03/19  7:56
 */
public class Solution_844 {

    /**
     * 从后往前比较 理解错了题目
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {

        int sIndex = s.length() - 1, tIndex = t.length() - 1;
        while(sIndex >= 0 && tIndex >= 0) {
            // 处理退格字符 #
            // s
            sIndex = findValidCharIndex(s, sIndex);
            // t
            tIndex = findValidCharIndex(t, tIndex);
            // 比较
            if(sIndex >= 0 && tIndex >= 0) {
                if(s.charAt(sIndex) == t.charAt(tIndex)) {
                    sIndex--;
                    tIndex--;
                } else {
                    return false;
                }
            } else {
                break;
            }
        }
        if(sIndex < 0 && tIndex < 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 从后往前寻找有效的比较位置
     * @param s
     * @param index
     * @return
     */
    private int findValidCharIndex(String s, int index) {
        while(index >= 0 && s.charAt(index) == '#') {
            int count = 0;
            while(index >= 0 && s.charAt(index) == '#') {
                index--;
                count++;
            }
            while(index >= 0 && count-- > 0) {
                index--;
            }
        }
        return index;
    }

    /**
     * =================================================================================================================
     */

    /**
     * 思路：先计算出去掉#号之后的字符串 然后再比较是否相等
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare_2(String s, String t) {
        s = findValidStr(s);
        t = findValidStr(t);
        return s.equals(t);
    }

    /**
     * 计算去掉#号之后的字符串
     * @param s
     * @return
     */
    private String findValidStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '#') {
                sb.append(s.charAt(i));
            } else {
                if(sb.length() == 0) {
                    continue;
                } else {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
//        Solution_844 obj = new Solution_844();
//        int validCharIndex = obj.findValidCharIndex("a#b#", 3);
//        System.out.println(validCharIndex);
        Solution_844 obj = new Solution_844();
        System.out.println(obj.findValidStr("bxo#j##tw"));
    }

}
