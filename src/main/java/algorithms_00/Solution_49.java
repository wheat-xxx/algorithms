package algorithms_00;

import org.junit.Test;

import java.util.*;

/**
 * Description:
 *
 *      给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 *      字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * @author wheat
 * @date 2023/03/06  19:20
 */
public class Solution_49 {

    /**
     *  这是一种很纯的写法
     */
//    private List<List<String>> res = new ArrayList<List<String>>();
//    private boolean[] used;
//
//    public List<List<String>> groupAnagrams(String[] strs) {
//
//        if(strs == null || strs.length == 0) return res;
//
//        used = new boolean[strs.length];
//
//        // 针对空串进行特殊处理
//        List<String> temp_null = new ArrayList<>();
//        for (int i = 0; i < strs.length; i++) {
//            if("".equals(strs[i])){
//                temp_null.add(strs[i]);
//                used[i] = true;
//            }
//        }
//        if(!temp_null.isEmpty()) res.add(temp_null);
//
//        for(int i = 0; i < strs.length; i++){
//            // 保存中间结果
//            List<String> others =  new ArrayList<String>();
//            Map<Character, Integer> map = new HashMap<Character, Integer>();
//
//            if(!used[i]){
//
//                for(int index = 0; index < strs[i].length(); index++){
//                    if(map.containsKey(strs[i].charAt(index))){
//                        int value = map.get(strs[i].charAt(index));
//                        map.remove(strs[i].charAt(index));
//                        map.put(strs[i].charAt(index), value+1);
//                    }else{
//                        map.put(strs[i].charAt(index), 1);
//                    }
//                }
//                others.add(strs[i]);
//                used[i] = true;
//            }else{
//                continue;
//            }
//            // 判断是否有字母异位词
//            for(int j = i + 1; j < strs.length; j++){
//                // 针对没有处理过的元素进行处理
//                if(!used[j]){
//
//                    // 只有字符长度相等 才有可能属于同一字母异位词
//                    if(strs[j].length() == strs[i].length()){
//                        Map<Character, Integer> map_temp = new HashMap<Character, Integer>();
//                        for(int index = 0; index < strs[j].length(); index++){
//                            if(map_temp.containsKey(strs[j].charAt(index))){
//                                int value = map_temp.get(strs[j].charAt(index));
//                                map_temp.remove(strs[j].charAt(index));
//                                map_temp.put(strs[j].charAt(index), value+1);
//                            }else{
//                                map_temp.put(strs[j].charAt(index), 1);
//                            }
//                        }
//                        if(map.equals(map_temp)){
//                            others.add(strs[j]);
//                            used[j] = true;
//                        }
//                    }
//
//                }
//            }
//            if(!others.isEmpty()) {
//                res.add(others);
//            }
//        }
//
//        return res;
//
//    }

//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map = new HashMap<>();
//
//        for(String str : strs){
//            char[] array = str.toCharArray();
//            Arrays.sort(array);
//            List<String> value = map.getOrDefault(new String(array), new ArrayList<>());
//            value.add(str);
//            map.put(new String(array), value);
//        }
//
//        return new ArrayList<List<String>>(map.values());
//    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            int[] array = new int[26];
            for(int index = 0; index < str.length(); index++){
                array[str.charAt(index) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int index = 0; index < array.length; index++){
                if(array[index] != 0){
                    sb.append((char)(index + 'a'));
                    sb.append(array[index]);
                }
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<String>());
            list.add(str);
            map.put(sb.toString(), list);
        }

        return new ArrayList<List<String>>(map.values());
    }

    @Test
    public void test(){

    }

}
