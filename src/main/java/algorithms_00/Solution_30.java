package algorithms_00;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *      给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 * @author wheat
 * @date 2023/02/27  10:15
 */
public class Solution_30 {

//    private List<String> strLists = new ArrayList<>();
//    private StringBuilder sb = new StringBuilder();
//    private List<Integer> ret = new ArrayList<>();
//
//
//    public List<Integer> findSubstring(String s, String[] words) {
//
//        // 边界条件
//        if(s.length() < words.length * words[0].length()) return ret;
//
//        // 1 收集所有的串联子串
//        cancatString(words, 0);
//
//        // 2 遍历strLists查看 s 中是包含串联子串
//        for(String str : strLists){
////            if(s.indexOf(str) != -1){
////                ret.add(s.indexOf(str));
////            }
//            String others = s;
//            int count = 0;
//            while(others.length() >= str.length() && others.indexOf(str) != -1){
//                ret.add(others.indexOf(str) + count);
//                if(others.length() == str.length()){
//                    break;
//                }else {
//                    count += others.indexOf(str) + 1;
//                    others = others.substring(others.indexOf(str) + 1);
//                }
//            }
//        }
//
//        return ret;
//    }
//
//    /**
//     * 利用决策树收集所有的串联子串
//     * @param words
//     * @return
//     */
//    public void cancatString(String[] words, int start){
//
//        if(start == words.length - 1){
//            for(int i = 0; i < words.length; i++){
//                sb.append(words[i]);
//            }
//            if(!strLists.contains(sb.toString())) {
//                strLists.add(sb.toString());
//            }
//            sb.delete(0, sb.length());
//            return;
//        }
//
//        for(int i = start; i < words.length; i++){
//            swap(words, start, i);
//            cancatString(words, start+1);
//            swap(words, start, i);
//        }
//
//    }
//
//    public void swap(String[] words, int i, int j){
//        String others = words[i];
//        words[i] = words[j];
//        words[j] = others;
//    }

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> res = new ArrayList<>();

        if(s == null || s.length() == 0 || words == null || words.length == 0) return res;

        Map<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for(int i = 0; i < s.length() - all_len + 1; i++){
            String tmp = s.substring(i, i+all_len);
            Map<String, Integer> tmp_map = new HashMap<>();
            for(int j = 0; j < all_len; j += one_word){
                String w = tmp.substring(j, j+one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0)+1);
            }
            if(map.equals(tmp_map)) res.add(i);
        }

        return res;
    }


    @Test
    public void test(){

    }

}
