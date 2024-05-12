package algorithms_02;

import data_structure.DLinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wheat
 * @date 2023/10/07  17:01
 */
public class Solution_146 {

    class LRUCache {

        private DLinkedList<Data> list = new DLinkedList<>();
        private Map<Integer, DLinkedList<Data>.Node> map = new HashMap<>();
        private final Integer capacity;
        private Integer size = 0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            DLinkedList<Data>.Node node = map.get(key);
            if(node == null) return -1;
            list.moveToFirst(node);
            return node.data.value;
        }

        public void put(int key, int value) {
            // 1. 判断是否存在
            DLinkedList<Data>.Node node = map.get(key);
            if(node == null) {
                node = list.new Node(new Data(key, value));
                // 2. 判断容量是否充足
                if(this.size < this.capacity) {
                    list.addFirst(node);
                    map.put(key, node);
                    this.size++;
                } else {
                    DLinkedList<Data>.Node last = list.removeLast();
                    map.remove((Integer)last.data.key);
                    list.addFirst(node);
                    map.put(key, node);
                }
            } else {
                node.data.value = value;
                list.moveToFirst(node);
            }
        }
    }

    class Data{
        Integer key;
        Integer value;
        Data(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

}
