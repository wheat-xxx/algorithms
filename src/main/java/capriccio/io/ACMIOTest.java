package capriccio.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ACM模式输出输出通用模板
 * @author wheat
 * @date 2024/03/18  15:28
 */
public class ACMIOTest {

    public static void main(String[] args) {
        ACMIOTest obj = new ACMIOTest();
//        obj.test01();
//        obj.test02();
//        obj.test03();
//        obj.test04();
//        obj.test05();
//        obj.test07();
//        obj.test08();
        obj.test10();
    }

    /**
     * 多⾏输⼊，每⾏两个整数
     */
    public void test01() {
        System.out.println("输入A+B，遇到 A、B 为0 的时候终止:");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if(a == 0 && b == 0) {
                System.out.println("bye~~");
                break;
            }
            System.out.println(a + b);
        }
    }

    /**
     * 多组数据，每组第⼀⾏为n, 之后输⼊n⾏两个整数
     */
    public void test02() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            while(n-- > 0) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.println(a + b);
            }
        }
    }

    /**
     * 若⼲⾏输⼊，遇到0终⽌，每⾏第⼀个数为N，表示本⾏后⾯有N个数
     */
    public void test03(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int N = scanner.nextInt();
            if(N == 0) {
                break;
            }
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        }
    }

    /**
     * 若⼲⾏输⼊，每⾏包括两个整数a和b，由空格分隔，每⾏输出后接⼀个空⾏
     */
    public void test04(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a + b);
            System.out.println();
        }
    }

    /**
     * 多组n⾏数据，先输⼊⼀个整数N，然后输入整数M并在同⼀⾏内输⼊M个整数,每组输出之间输出⼀个空⾏
     */
    public void test05(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            int N = scanner.nextInt();
            // 每组有n行数据
            while(N-- > 0) {
                int M = scanner.nextInt();
                int sum = 0;
                // 每行有m个数据
                while(M-- > 0) {
                    sum += scanner.nextInt();
                }
                System.out.println(sum);
                if(N > 0) System.out.println();
            }

        }
    }

    /**
     * 多组测试样例，每组输⼊数据为字符串，字符⽤空格分隔
     * 输出为⼩数点后两位
     */
    public void test06() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] items = line.split(" ");
            for (String item : items) {
                // 操作
            }
        }

        double avg = 3.25;
        System.out.printf("%.2f\n", avg);
    }

    /**
     * 多组测试⽤例，第⼀⾏为正整数n, 第⼆⾏为n个正整数，n=0时，结束输⼊，每组输出结果的下⾯都输出⼀个空⾏
     */
    public void test07() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int N = scanner.nextInt();
            if(N == 0) {
                break;
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(scanner.nextInt());
            }
            // 遍历
            for (Integer i : list) {
                System.out.println(i);
            }
            System.out.println();
        }
    }

    /**
     * 多组测试数据。每组输⼊⼀个整数n，输出特定的数字图形
     */
    public void test08() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int N = scanner.nextInt();
            for (int i = 1; i <= N; i++) {
                print(N - i, i);
            }
            for (int i = N - 1; i >= 1; i--) {
                print(N - i, i);
            }
        }
    }

    private void print(int blank, int n) {
        // 前面需要补齐空格
        for (int i = 0; i < blank; i++) {
            System.out.print(" ");
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(i);
        }
        for (int i = n - 1; i > 0; i--) {
            System.out.print(i);
        }
        System.out.println();
    }

    /**
     * 多⾏输⼊，每⾏输⼊为⼀个字符和⼀个整数，遇到特殊字符结束
     */
    public void test09() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            if ("@".equals(line)) {
                break;
            }
            String[] inputs = line.split(" ");
            char ch = inputs[0].charAt(0);
            int n = Integer.parseInt(inputs[1]);
        }
        scanner.close();
    }

    /**
     * 第⼀⾏是⼀个整数n，表示⼀共有n组测试数据, 之后输⼊n⾏字符串
     */
    public void test10() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine().trim();
                StringBuilder sb = new StringBuilder(line);
                // 对字符串进行处理

                System.out.println(sb.toString());
            }
        }
    }




}
