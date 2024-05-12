package algorithms_03;

/**
 * @author wheat
 * @date 2023/12/07  16:09
 */
public class Solution_168 {

    /**
     * 本质是一个数制转换问题 和一般的数制转换有区别
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {

        //保存中间运算结果
        StringBuilder sb = new StringBuilder();

        while(columnNumber > 0) {
            int temp = (columnNumber - 1) % 26; // a0 = others + 1
            char ch = (char)('A' + temp);
            sb.append(ch);
            columnNumber = (columnNumber - temp - 1) / 26;
        }

        return sb.reverse().toString();
    }

}
