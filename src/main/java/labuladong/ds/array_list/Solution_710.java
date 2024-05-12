package labuladong.ds.array_list;

import java.util.Random;

/**
 * 给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。
 * 设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 blacklist 的整数。
 * 任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
 *
 * 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
 * @author wheat
 * @date 2024/04/12  16:13
 */
public class Solution_710 {

    /**
     * java 生成随机数的方式
     * @param args
     */
    public static void main(String[] args) {
        // 使用 java.util.Random
        Random random = new Random();
        int randomNumber = random.nextInt();

        // 使用Math.random()
        // Math.random() 方法返回一个范围在 [0, 1) 之间的伪随机 double 值
        // Math.random() * n 将生成一个范围在 [0, n) 之间的随机数
        randomNumber = (int)(Math.random() * 1024);
    }

}
