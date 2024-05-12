package algorithms_01;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/07  17:31
 */
public class Solution_58 {

    public int lengthOfLastWord(String s) {

        int right = s.length() - 1, left = s.length() - 1;

        while(s.charAt(right) == ' '){
            right--;
        }
        left = right;
        while(left >= 0 && s.charAt(left) != ' '){
            left--;
        }

        return right - left;
    }

}
