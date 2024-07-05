package examination.wheat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wheat
 * @date 2024/06/04  21:34
 */
public class Exam0604 {

    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        long n = scanner.nextLong();
//        double res = 2.0 / (n * (n - 1));
//        long res_int = (long)(res * 100000000000L);
////        System.out.println(res_int);
//        if (res_int % 10 < 5) {
//            res_int = res_int / 10;
//        } else {
//            res_int = res_int / 10 + 1;
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append(res_int);
////        System.out.println(sb.toString());
//        if (n == 2) {
//            System.out.println("1.0000000000");
//            return;
//        }
//        if (sb.length() < 10) {
//            StringBuilder sb_temp = new StringBuilder("0.");
//            for (int i = 0; i < 10 - sb.length(); i++) {
//                sb_temp.append(0);
//            }
//            sb_temp.append(sb.toString());
//            System.out.println(sb_temp.toString());
//            return;
//        }
//        System.out.println("0." + sb.toString());
//
//
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String str3 = scanner.nextLine();
        int n, k;
        String[] split = str1.split("\\s+");
        n = Integer.parseInt(split[0]);
        k = Integer.parseInt(split[1]);

        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        split = str2.split("\\s+");
        for (int i = 0; i < n; i++) {
            nums1[i] = Integer.parseInt(split[i]);
        }
        split = str3.split("\\s+");
        for (int i = 0; i < n; i++) {
            nums2[i] = Integer.parseInt(split[i]);
        }

        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[]{nums1[i], nums2[i]};
        }

        backtrack(dp, 0, k);

        long max = 0;
        for (List<int[]> list : res) {
            long sum = 0;
            int min = Integer.MAX_VALUE;
            for (int[] ints : list) {
                sum += ints[0];
                min = Math.min(min, ints[1]);
            }
            max = Math.max(max, sum * min);
        }

        System.out.println(max);
    }

    private static List<int[]> trace = new ArrayList<>();
    private static List<List<int[]>> res = new ArrayList<>();

    private static void backtrack(int[][] list, int start, int k) {
        if (trace.size() == k) {
            res.add(new ArrayList<>(trace));
            return;
        }

        for (int i = start; i < list.length; i++) {
            trace.add(list[i]);
            backtrack(list, i + 1, k);
            trace.remove(trace.size() - 1);
        }
    }

}
