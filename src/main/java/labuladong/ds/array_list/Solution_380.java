package labuladong.ds.array_list;

import java.util.*;

/**
 * 实现RandomizedSet 类：
 *
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 *
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 *
 * 等概率随机获取元素 一定要满足：底层用数组实现，且数组必须紧凑的
 * @author wheat
 * @date 2024/04/12  15:26
 */
public class Solution_380 {

    private class RandomizedSet {
        /**
         * 存储元素的值
         */
        private List<Integer> nums;
        /**
         * 记录每个元素在nums中的索引
         */
        private Map<Integer, Integer> valToIndex;


        public RandomizedSet() {
            this.nums = new ArrayList<>();
            this.valToIndex = new HashMap<>();
        }

        /**
         * 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false
         * @param val
         * @return
         */
        public boolean insert(int val) {
            if (valToIndex.containsKey(val)) {
                return false;
            }
            // 若 val 不存在，插入到 nums 尾部，
            // 并记录 val 对应的索引值
            nums.add(val);
            valToIndex.put(val, nums.size() - 1);
            return true;
        }

        /**
         * 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false
         * @param val
         * @return
         */
        public boolean remove(int val) {
            if (!valToIndex.containsKey(val)) {
                return false;
            }
            // 先拿到 val 的索引
            Integer index = valToIndex.get(val);
            // 将最后一个元素填充到val的位置，并更新map
            valToIndex.put(nums.get(nums.size() - 1), index);
            nums.set(index, nums.get(nums.size() - 1));
            // 删除最后一个元素 并删除map中的val
            nums.remove(nums.size() - 1);
            valToIndex.remove(val);
            return true;
        }

        public int getRandom() {
            // 生成一个范围在 [0, n] 之间的随机整数
            int randomIndex = new Random().nextInt(nums.size());
            return nums.get(randomIndex);
        }
    }

}
