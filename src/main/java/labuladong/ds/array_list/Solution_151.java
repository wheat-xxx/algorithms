package labuladong.ds.array_list;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * 有时候咱们拍脑袋的常规思维，在计算机看来可能并不是最优雅的；但是计算机觉得最优雅的思维，对咱们来说却不那么直观。
 * @author wheat
 * @date 2024/04/12  8:52
 */
public class Solution_151 {

    public String reverseWords(String s) {
        // 去除开头和结尾多余的空格
        String trim = s.trim();
        // 字符串翻转
        StringBuilder sb = new StringBuilder(trim);
        String reverseStr = sb.reverse().toString();
        // 进行单词划分
        String[] words = reverseStr.split("\\s+");
        sb = new StringBuilder();
        // 将每个单词进行翻转
        for (String word : words) {
            String reverseWord = new StringBuilder(word).reverse().toString();
            sb.append(reverseWord).append(" ");
        }

        // 去除末尾的空格
        return sb.toString().trim();
    }


}
