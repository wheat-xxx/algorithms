package examination.wheat;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wheat
 * @date 2024/05/14  19:28
 */
public class Exam0514 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] split = input.split("\\s+");
        int n = Integer.parseInt(split[0]);
        int X = Integer.parseInt(split[1]);

        input = scanner.nextLine();
        split = input.split("\\s+");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        // 初始化备忘录
        memo = new int[X + 1][nums.length];
        for (int i = 0; i < X + 1; i++) {
            Arrays.fill(memo[i], -666);
        }

        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }

        System.out.println(dp(nums, X, 0));
    }

    private static boolean flag = false;

    private static int[][] memo;

    private static int dp(int[] nums, int X, int start) {

        // base case
        if (X < 0) return -1;
        if (X == 0) return 0;
        if (start == nums.length) return -1;

        if (memo[X][start] != -666) return memo[X][start];

        int subProblem0 = dp(nums, X, start + 1);
        int subProblem1 = dp(nums, X - nums[start] / 2, start + 1);
        int subProblem2 = -1;
        if (!flag) {
            flag = true;
            subProblem2 = dp(nums, X - nums[start], start + 1);
            flag = false;
        }

        int res = Integer.MAX_VALUE;
        if (subProblem0 != -1) {
            res = Math.min(res, subProblem0);
        }
        if (subProblem1 != -1) {
            res = Math.min(res, 1 + subProblem1);
        }
        if (subProblem2 != -1) {
            res = Math.min(res, 1 + subProblem2);
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        memo[X][start] = res;
        return res;
    }

}

//    public static void main(String[] args) {
//        List<String> res = new ArrayList<>();
//        Set<String> set = new HashSet<>();
//
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        while(scanner.hasNextLine()) {
//            String s = scanner.nextLine().trim();
//            if (!set.contains(s)) {
//                set.add(s);
//                res.add(s);
//            }
//        }
//
//        for (String s : res) {
//            System.out.println(s);
//        }
//    }

/*
 * ---------------------------------------------------------------------------------------------------------------------
 */

