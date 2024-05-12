package algorithms_02;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/20  16:40
 */
public class Solution_118 {

    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> res = new ArrayList<>();
        if(numRows <= 0) return res;
        for(int i = 1; i <= numRows; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 1; j <= i; j++){
                if(j == 1 || j == i){
                    list.add(1);
                }else {
                    List<Integer> pre = res.get(res.size() - 1);
                    int num = pre.get(j - 2) + pre.get(j - 1);
                    list.add(num);
                }
            }
            res.add(list);
        }
        return res;
    }

}
