package algorithms_02;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/20  16:48
 */
public class Solution_119 {

    public List<Integer> getRow(int rowIndex){
        List<Integer> res = new ArrayList<>();

        if(rowIndex < 0) return res;

        res.add(1);

        for(int i = 1; i <= rowIndex; i++){
            int num = (int)(res.get(res.size() - 1) * (long)(rowIndex - i + 1) / i);
            res.add(num);
        }

        return res;
    }

}
