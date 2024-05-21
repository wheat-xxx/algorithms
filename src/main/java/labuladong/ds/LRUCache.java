package labuladong.ds;

import java.util.HashMap;

/**
 * LRU 的全称是 Least Recently Used，也就是说我们认为最近使用过的数据应该是是「有用的」，很久都没用过的数据应该是无用的，
 * 内存满了就优先删那些很久没用过的数据。
 *
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行
 * @author wheat
 * @date 2024/04/17  11:22
 */
public class LRUCache {

    // key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;
    // 最大容量
    private int capacity;

    /**
     * capacity 初始化 LRU 缓存
     * @param capacity
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        this.cache = new DoubleList();
    }

    /**
     * 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1
     * @param key
     * @return
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 使用之后将移动到链表尾部 先删除后添加到尾部从而实现移动
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
        return x.val;
    }

    /**
     * 如果关键字 key 已经存在，则变更其数据值 value ；
     * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
     * @param key
     * @param val
     */
    public void put(int key, int val) {
        if (map.containsKey(key)) {
            Node x = map.get(key);
            x.val = val;
            // 移动至尾部
            cache.remove(x);
            cache.addLast(x);
            return;
        }

        // 添加新节点 包括map和cache
        Node x = new Node(key, val);
        // 如果满了，删除最近最久未使用的节点 map cache
        if (cache.size == capacity) {
            Node del = cache.removeFirst();
            map.remove(del.key);
        }
        map.put(key, x);
        cache.addLast(x);
    }

    /**
     * 双链表的节点
     * 为什么每个节点同时保存key和value?
     *  map: key -> node O(1)
     *  doubleList: node -> key O(1)
     */
    private class Node {
        public int key, val;
        public Node prev, next;
        public Node() {}
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * 双链表：伪头尾节点
     * 知道节点的指针，删除节点的时间复杂度是O(1)
     * 靠尾部的数据是最近使用的，靠头部的数据是最久未使用的
     */
    private class DoubleList {
        // 头尾虚节点
        private Node head, tail;
        // 链表元素数
        private int size;

        public DoubleList() {
            // 初始化双向链表的数据
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        /**
         * 在链表尾部添加节点 x，时间 O(1)
         * @param x
         */
        public void addLast(Node x) {
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        /**
         * 删除链表中的 x 节点（x 一定存在）
         * 由于是双链表且给的是目标 Node 节点，时间 O(1)
         * @param x
         */
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        /**
         * 删除链表中第一个节点，并返回该节点，时间 O(1)
         * @return
         */
        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        public int size() {
            return size;
        }
    }

}
