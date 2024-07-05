package examination.wheat;

import java.util.Scanner;

/**
 * @author wheat
 * @date 2024/06/16  20:39
 */
public class Exam0616 {

    //    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int T = Integer.parseInt(in.nextLine());
//        for (int i = 0; i < T; i++) {
//            String s1 = in.nextLine();
//            String[] split = s1.split("\\s+");
//            int m = Integer.parseInt(split[0]);
//            int s = Integer.parseInt(split[1]);
//            s1 = in.nextLine();
//            split = s1.split("\\s+");
//            int[] nums = new int[m];
//            for (int j = 0; j < m; j++) {
//                nums[j] = Integer.parseInt(split[j]);
//            }
//
//            String msg = isValid(nums, m, s) ? "YES" : "NO";
//            System.out.println(msg);
//        }
//    }
//
//    private static boolean isValid(int[] nums, int m, int s) {
//        Arrays.sort(nums);
//        int[] nums_new = new int[nums[m - 1]];
//        for (int i = 0; i < m; i++) {
//            nums_new[nums[i] - 1] = nums[i];
//        }
//        int sum = 0;
//        for (int i = 0; i < nums_new.length; i++) {
//            if (nums_new[i] == 0) {
//                sum += i + 1;
//            }
//        }
//        if (sum == s) {
//            return true;
//        }
//        if (sum > s) {
//            return false;
//        }
//
//        // sum < s
//        for (int i = nums[m - 1] + 1; sum <= s; i++) {
//            sum += i;
//            if (sum == s) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[] prices = new int[N];
            for (int j = 0; j < N; j++) {
                prices[j] = Integer.parseInt(scanner.nextLine());
            }
            backtrack(prices, 0);
            System.out.println(min - prices[N - 1]);
            min = Integer.MAX_VALUE;
        }

    }

    private static int min = Integer.MAX_VALUE;
    private static int[] trace = new int[2];

    private static void backtrack(int[] prices, int index) {
        // base case
        if (index == prices.length) {
            if (min > trace[0]) {
                min = trace[0];
            }
            return;
        }

        if (trace[1] >= 100) {
            // 情况二 用
            trace[1] = trace[1] - 100 + prices[index];
            backtrack(prices, index + 1);
            trace[1] = trace[1] + 100 - prices[index];
        }

        // 情况一 不用
        // 做选择
        trace[0] += prices[index];
        trace[1] += prices[index];
        backtrack(prices, index + 1);
        // 撤销选择
        trace[0] -= prices[index];
        trace[1] -= prices[index];

    }

}
