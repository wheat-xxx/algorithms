package algorithms_03;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wheat
 * @date 2023/12/13  15:34
 */
public class Solution_179 {

    public String largestNumber(int[] nums) {
        List<String> strs = Arrays.stream(nums).mapToObj(String::valueOf).sorted(new StringComparator()).collect(Collectors.toList());
        Collections.reverse(strs);
        String res = String.join("", strs);
        return res;
    }

    private class StringComparator implements Comparator<String> {

        /**
         * 从小到大进行排列
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(String o1, String o2) {
            int idx1 = 0, idx2 = 0;
            while(idx1 < o1.length() && idx2 < o2.length()) {
                if(o1.charAt(idx1) == o2.charAt(idx2)) {
                    idx1++; idx2++;
                    continue;
                } else if (o1.charAt(idx1) < o2.charAt(idx2)) {
                    return -1;
                } else {
                    return 1;
                }
            }

            // 特殊情况：一个字符串是另一个字符串的前置子串
            if(idx1 < o1.length()) {
                idx2 = 0;
                while(idx1 < o1.length()) {
                    if(o1.charAt(idx1) == o2.charAt(idx2)) {
                        idx1++; idx2 = (idx2 + 1) % o2.length();
                        continue;
                    }else if (o1.charAt(idx1) < o2.charAt(idx2)) {
                        return -1;
                    } else {
                        return 1;
                    }
                }

                // 特殊情况：[8308,8308,830]
            }
            if(idx2 < o2.length()) {
                idx1 = 0;
                while(idx2 < o2.length()) {
                    if(o1.charAt(idx1) == o2.charAt(idx2)) {
                        idx1 = (idx1 + 1) % o1.length(); idx2++;
                        continue;
                    } else if (o1.charAt(idx1) < o2.charAt(idx2)) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }

            return 0;
        }

    }

    public String largestNumber_2(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = Arrays.stream(nums).mapToObj(Integer::new).toArray(Integer[]::new);

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while(sx <= x) {
                sx *= 10;
            }
            while(sy <= y) {
                sy *= 10;
            }
            return (int) (-sy*x-y+sx*y+x);
        });

        if(numsArr[0] == 0) {
            return "0";
        }

        String res = Arrays.stream(numsArr).map(String::valueOf).collect(Collectors.joining(""));
        return res;
    }

    public String largestNumber_3(int[] nums) {
        Integer[] array = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
        }

        // 降序排列
        Arrays.sort(array, (a, b) -> {
            String s1 = String.valueOf(a);
            String s2 = String.valueOf(b);
            return (s2 + s1).compareTo(s1 + s2);
        });

        if(array[0] == 0) {
            return "0";
        }

        return Arrays.stream(array).map(String::valueOf).collect(Collectors.joining(""));
    }

}
