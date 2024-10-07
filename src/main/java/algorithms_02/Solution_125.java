package algorithms_02;

/**
 * 回文串判断
 * @author wheat
 * @date 2023/08/31  15:09
 */
public class Solution_125 {

    public boolean isPalindrome(String s) {
        // 判断是否为空
        if(s == null) return true;

        StringBuilder sb = new StringBuilder();

        // 获取所有的字母和数字
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else if (Character.isLowerCase(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else if (Character.isUpperCase(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        // 回文串判断
        int i = 0; int j = sb.length() - 1;
        while(i < j) {
            if(sb.charAt(i) != sb.charAt(j)) return false;
            i++; j--;
        }

        return true;
    }

}
