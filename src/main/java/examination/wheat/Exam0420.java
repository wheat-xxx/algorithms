package examination.wheat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wheat
 * @date 2024/04/20  9:46
 */
public class Exam0420 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        long n = in.nextLong();
//
//        StringBuilder sb = new StringBuilder();
//        for (long i = 0; i < n; i++) {
//            if (i == 0 || i == 1) {
//                sb.append(1).append(" ");
//                continue;
//            }
//            sb.append(i).append(" ");
//        }
//        System.out.println(sb.toString().trim());
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        String s = in.next();
//        long res = 0L;
//        if (s.indexOf(0) == '-') {
//            for (int i = 2; i < s.length(); i++) {
//                String str1 = s.substring(0, i);
//                String str2 = s.substring(i, s.length());
//                res = Math.max(res, Long.parseLong(str1) + Long.parseLong(str2));
//            }
//        } else {
//            for (int i = 1; i < s.length(); i++) {
//                String str1 = s.substring(0, i);
//                String str2 = s.substring(i, s.length());
//                res = Math.max(res, Long.parseLong(str1) + Long.parseLong(str2));
//            }
//        }
//        System.out.println(res);
//
//
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int q = in.nextInt();
//        for (int i = 0; i < q; i++) {
//            int n = in.nextInt();
//            long k = in.nextLong();
//            String s = in.next();
//            String t = in.next();
//
//            int count = 0;
//            for (int j = 0; j < s.length(); j++) {
//                if (t.charAt(j) > s.charAt(j)) {
//                    count += (int)t.charAt(j) - (int)s.charAt(j);
//                } else if (t.charAt(j) < s.charAt(j)) {
//                    count += 26 - ((int)s.charAt(j) - (int)t.charAt(j));
//                }
//            }
//
//            boolean flag = (k - count) % 26 == 0;
//            if (k < count) flag = false;
//            System.out.println(flag ? "Yes" : "No");
//        }
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//        byte[] nums = new byte[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = in.nextByte();
//        }
//        int[][] edges = new int[n - 1][2];
//
//        for (int i = 0; i < n - 1; i++) {
//            edges[i][0] = in.nextInt();
//            edges[i][1] = in.nextInt();
//        }
//
//        // 构造树
//        TreeNode root = buildTree(nums, edges);
//
//
//    }




    private static class TreeNode {
        byte val;
        List<TreeNode> children = new ArrayList<>();
        TreeNode() {

        }
        TreeNode(byte val) {
            this.val = val;
        }
    }

    /**
     * @param nums
     * @param edges
     * @return
     */
    private static TreeNode buildTree(byte[] nums, int[][] edges) {
        TreeNode[] nodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new TreeNode(nums[i]);
        }

        for (int[] edge : edges) {
            if (edge[0] < edge[1]) {
                nodes[edge[0] - 1].children.add(nodes[edge[1] - 1]);
            } else {
                nodes[edge[1] - 1].children.add(nodes[edge[0] - 1]);
            }
        }

        return nodes[0];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        Long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] left = Arrays.copyOfRange(nums, 0, i);
            int[] right = Arrays.copyOfRange(nums, i, n);
            long left_count = down(left);
            long right_count = up(right);
            res = Math.min(res, left_count + right_count);
        }
        System.out.println(res);
    }

    private static long down(int[] nums) {
        long count = 0;
        if (nums == null || nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    swap(nums, j, j+1);
                    count++;
                }
            }
        }
        return count;
    }

    private static long up(int[] nums) {
        long count = 0;
        if (nums == null || nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j+1);
                    count++;
                }
            }
        }
        return count;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}