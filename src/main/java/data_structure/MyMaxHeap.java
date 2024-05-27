package data_structure;

import java.util.Arrays;

/**
 * 堆的性质：
 *      完全二叉树：堆必须是完全二叉树，即除最后一层外，每一层都是满的，且最后一层的节点从左到右排列。
 *      堆序性质：对于最大堆（Max Heap），任何一个节点的值都大于或等于其子节点的值。对于最小堆（Min Heap），任何一个节点的值都小于或等于其子节点的值。
 * 堆的类型：最大堆 最小堆
 * 堆的操作：
 *      插入：在堆的末尾插入新元素，调整新插入的元素，通过“上浮”操作，使堆重新满足堆序性质。
 *      删除最大/最小值（即删除根节点）：将根节点与最后一个节点交换并删除最后一个节点，调整新的根节点，通过“下沉”操作，使堆重新满足堆序性质。
 *      构建堆：将一个无序数组转换为堆
 *
 *
 * @author wheat
 * @date 2024/05/27  9:12
 */
public class MyMaxHeap {

    private int[] heap;
    private int capacity;
    private int size;

    public MyMaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    /**
     * 获取父节点的索引
     * @param index
     * @return
     */
    private int parent(int index) {
        return (index - 1) / 2;
    }

    /**
     * 获取左子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 获取右子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 交换数组中的两个元素
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * 确保容量足够，不够时扩展容量
     */
    private void ensureCapacity() {
        if (size == capacity) {
            capacity = capacity * 2;
            int[] newHeap = new int[capacity];
            for (int i = 0; i < size; i++) {
                newHeap[i] = heap[i];
            }
//            System.arraycopy(heap, 0, newHeap, 0, size);
            heap = newHeap;
        }
    }

    /**
     * 插入新元素到堆中 - 上浮
     * @param value
     */
    public void insert(int value) {
        ensureCapacity();
        heap[size++] = value;
        int index = size - 1;
        while (index > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    /**
     * 删除并返回堆中的最大元素
     * @return
     */
    public int extractMax() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty!");
        }

        int max = heap[0];
        heap[0] = heap[--size];

        // 堆调整 - 下沉
        int index = 0;
        int largest = index;
        int left = leftChild(largest);
        int right = rightChild(largest);
        while (index < size) {
            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }
            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }

            if (index == largest) {
                break;
            } else {
                swap(index, largest);
                index = largest;
                left = leftChild(index);
                right = rightChild(index);
            }
        }

        return max;
    }

    public int getMax() {
        if (size == 0) {
            throw new RuntimeException("Heap is Empty!");
        }
        return heap[0];
    }

    /**
     * 返回堆的大小
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断堆是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MyMaxHeap maxHeap = new MyMaxHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(15);

        System.out.println("Max Value: " + maxHeap.extractMax());  // 输出 20
        System.out.println("Max Value: " + maxHeap.extractMax());  // 输出 15
        System.out.println("Max Value: " + maxHeap.extractMax());  // 输出 10
        System.out.println("Max Value: " + maxHeap.extractMax());  // 输出 5
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(15);
        System.out.println("Max Value: " + maxHeap.extractMax());  // 输出 20
        System.out.println("Max Value: " + maxHeap.extractMax());  // 输出 15
        System.out.println("Max Value: " + maxHeap.extractMax());  // 输出 10
    }

}
