package algorithms_20;

/**
 * @author wheat
 * @date 2024/07/29  18:41
 */
public class Solution_1047 {

    public String removeDuplicates(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (sb.length() == 0 || s.charAt(i) != sb.charAt(sb.length() - 1)) {
                sb.append(s.charAt(i));
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return sb.toString();
    }

}
