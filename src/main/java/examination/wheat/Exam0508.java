package examination.wheat;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author wheat
 * @date 2024/05/08  21:43
 */
public class Exam0508 {

//    public static void main(String[] args) {
//
//        int[] registers = new int[32];
//        Scanner scanner = new Scanner(System.in);
//
//        while (scanner.hasNextLine()) {
//            String input = scanner.nextLine();
//            String[] split = input.split("\\s+");
//            if (split.length == 2) {
//                int index = Integer.parseInt(split[1].substring(1));
//                System.out.println(registers[index]);
//            }
//            if (split.length == 3) {
//                int index = Integer.parseInt(split[1].substring(1));
//                // src可能为正整数或者寄存器的值
//                int val1 = 0;
//                if (split[2].charAt(0) == 'a') {
//                    val1 = registers[Integer.parseInt(split[2].substring(1))];
//                } else {
//                    val1 = Integer.parseInt(split[2]);
//                }
//                registers[index] = val1;
//            }
//            if (split.length == 4) {
//                String operation = split[0];
//                int index = Integer.parseInt(split[1].substring(1));
//                // src可能为正整数或者寄存器的值
//                int val1 = 0;
//                if (split[2].charAt(0) == 'a') {
//                    val1 = registers[Integer.parseInt(split[2].substring(1))];
//                } else {
//                    val1 = Integer.parseInt(split[2]);
//                }
//                int val2 = 0;
//                if (split[3].charAt(0) == 'a') {
//                    val2 = registers[Integer.parseInt(split[3].substring(1))];
//                } else {
//                    val2 = Integer.parseInt(split[3]);
//                }
//                if (operation.equals("ADD")) {
//                    registers[index] = val1 + val2;
//                }
//                if (operation.equals("SUB")) {
//                    registers[index] = val1 - val2;
//                }
//                if (operation.equals("MUL")) {
//                    registers[index] = val1 * val2;
//                }
//                if (operation.equals("DIV")) {
//                    registers[index] = val1 / val2;
//                }
//            }
//        }
//
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int capacity = Integer.parseInt(scanner.nextLine().trim());
        LRU lru = new LRU(capacity);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("write:")) {
                int lines = Integer.parseInt(scanner.nextLine().trim());
                int[][] data = new int[lines][2];
                for (int i = 0; i < lines; i++) {
                    String temp = scanner.nextLine();
                    String[] split = temp.split("\\s+");
                    data[i][0] = Integer.parseInt(split[0]);
                    data[i][1] = Integer.parseInt(split[1]);
                }
                lru.write(data);
            } else if (input.equals("read:")) {
                int localCell = Integer.parseInt(scanner.nextLine());
                lru.read(localCell);
            } else if (input.equals("query:")) {
                int localCell = Integer.parseInt(scanner.nextLine());
                System.out.println(lru.query(localCell));
            }
        }
    }

    static class LRU {
        int capacity;
        int size = 0;

        Map<Integer, Data> map = new HashMap<>();

        LRU(int capacity) {
            this.capacity = capacity;
        }

        void write(int[][] data) {
            for (int[] item : data) {
                if (map.containsKey(item[0])) {
                    map.get(item[0]).neighborCell = item[1];
                    map.get(item[0]).count++;
                } else if (size < capacity) {
                    map.put(item[0], new Data(item[0], item[1], 1));
                    size++;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (Map.Entry<Integer, Data> entry : map.entrySet()) {
                        if (min > entry.getValue().count) {
                            min = entry.getValue().count;
                        }
                    }
                    int del_key = -1;
                    long del_time = System.currentTimeMillis();
                    for (Map.Entry<Integer, Data> entry : map.entrySet()) {
                        if (min == entry.getValue().count && del_time > entry.getValue().timestamp) {
                            del_key = entry.getKey();
                            del_time = entry.getValue().timestamp;
                        }
                    }
                    map.remove(del_key);
                    map.put(item[0], new Data(item[0], item[1], 1));
                }
            }
        }

        void read(int localCell) {
            map.get(localCell).count++;
            map.get(localCell).timestamp = System.currentTimeMillis();
        }

        int query(int localCell) {
            if (map.containsKey(localCell))
                return map.get(localCell).neighborCell;
            else
                return -1;
        }
    }

    static class Data {
        int localCell;
        int neighborCell;
        int count = 0;
        long timestamp = System.currentTimeMillis();
        Data(int localCell, int neighborCell, int count) {
            this.localCell = localCell;
            this.neighborCell = neighborCell;
            this.count = count;
        }
    }
}
