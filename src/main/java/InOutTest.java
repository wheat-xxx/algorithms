import java.util.Scanner;

/**
 *
 * 处理输入输出：in.hasNext() in.hasNextLine() in.next() in.nextInt() in.nextLine()
 * 字符串划分：str.split("\\s+").trim()
 *
 * @author wheat
 * @date 2024/09/26  9:59
 */
public class InOutTest {

    /**
     * ACM 输入输出处理
     */
    private static void inOutTest() {

        Scanner in = new Scanner(System.in);
        String line = in.nextLine().trim();

        // 单个值
        int val = Integer.parseInt(line);

        // 多个值
        String[] splits = line.split("\\s+");
        int[] nums = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            nums[i] = Integer.parseInt(splits[i]);
        }

    }

}
