package algorithms_00;

import java.util.*;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/02/23  15:51
 */
public class Solution_17 {

    // 实现数字和字符之间的映射 也可以直接用数组进行存储
    public static final Map<Character, List<Character>> map = new HashMap<>();

    static{
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y','z'));
    }

    // 路径保存
    private StringBuilder sb = new StringBuilder();

    // 结果集
    private List<String> resList = new ArrayList<>();

    /**
     * 分析：
     *      这是一个排列组合的问题
     *      可以利用决策树结合回溯算法实现
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        // 边界条件
        if(digits == null && digits.length() == 0){
            return resList;
        }

        backtrack(digits, 0);
        return resList;

    }

    private void backtrack(String digits, int index) {
        // 结束条件
        if(sb.length() == digits.length()){
            resList.add(sb.toString());
            return;
        }
        for(char ch : map.get(digits.charAt(index))){
            sb.append(ch);
            backtrack(digits, index+1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
