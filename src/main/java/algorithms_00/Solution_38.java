package algorithms_00;

import org.junit.Test;

/**
 * Description:
 *      外观数列
 * @author wheat
 * @date 2023/03/01  15:03
 */
public class Solution_38 {

    /**
     *      递归实现 相当于从后往前进行解决问题
     * @param n
     * @return
     */
    public String countAndSay(int n){

        // 边界检验
        if(n == 1){
            return "1";
        }

        StringBuilder sb = new StringBuilder();

        // 获取前一个外观数列
        String last = countAndSay(n-1);

        // 对前一个外观数列进行描述并返回
        for(int i = 0; i < last.length();){
            int count = 1;
            while(i + 1 < last.length()){
                if(last.charAt(i) == last.charAt(i + 1)){
                    count++;i++;
                    continue;
                }
                break;
            }
            sb.append(count);sb.append(last.charAt(i));
            i++;
        }

        return sb.toString();
    }

    /**
     *      非递归实现：从前往后解决问题 这个也是比较简单的
     */

    @Test
    public void test(){
        String res = countAndSay(4);

    }

}
