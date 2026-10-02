package data_structure;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * 动态数组代码实现
 * @author wheat
 * @date 2025/02/16  19:51
 */
public class MyArrayList<E> {

    // 真正存储数据的底层数组
    private E[] data;
    // 记录当前元素个数
    private int size;
    // 默认初始容量
    private static final int INIT_CAP = 1;

    public MyArrayList() {
        this(INIT_CAP);
    }

    public MyArrayList(int initCapacity) {
        data = (E[]) new Object[initCapacity];
        size = 0;
    }

    /**
     * 尾部添加
     * @param elem
     */
    public void addLast(E elem) {
        int cap = data.length;
        // 看 data 数组容量够不够
        if (size == cap) {
            resize(2 * cap);
        }
        // 在尾部插入元素
        data[size++] = elem;
    }

    /**
     * 任意位置插入
     * @param index
     * @param elem
     */
    public void add(int index, E elem) {
        // 检查索引越界
        checkPositionIndex(index);

        // 看 data 数组容量够不够
        int cap = data.length;
        if (size == cap) {
            resize(2 * cap);
        }

        // 搬移数据 data[index..] -> data[index+1..]
        // 给新元素腾出位置
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        // 插入新元素
        data[index] = elem;
        size++;
    }

    public void addFirst(E elem) {
        add(0, elem);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public E removeLast() {
        // 判断是否有元素
        if (size == 0) {
            throw new NoSuchElementException();
        }

        // 可以缩容，节约空间
        int cap = data.length;
        if (size == cap / 4) {
            resize(cap / 2);
        }

        E deleteVal = data[size - 1];
        // 删除最后一个元素
        // 必须给最后一个元素置为 null，否则会内存泄漏
        data[size - 1] = null;
        size--;

        return deleteVal;
    }

    /**
     * 删除任意位置元素
     * @param index
     * @return
     */
    public E remove(int index) {
        // 检查索引越界
        checkElementIndex(index);

        int cap = data.length;
        // 可以缩容，节约空间
        if (size == cap / 4) {
            resize(cap / 2);
        }

        E deletedVal = data[index];

        // 搬移数据 data[index+1..] -> data[index..]
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;

        return deletedVal;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E get(int index) {
        // 检查索引越界
        checkElementIndex(index);

        return data[index];
    }

    public E set(int index, E element) {
        // 检查索引越界
        checkElementIndex(index);
        // 修改数据
        E oldVal = data[index];
        data[index] = element;
        return oldVal;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        System.out.println("size = " + size + " cap = " + data.length);
        System.out.println(Arrays.toString(data));
    }

    /**
     * data扩容
     * @param newCap
     */
    private void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];

        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }

        data = temp;
    }

    /**
     * 检查 index 索引位置是否可以存在元素
     * @param index
     */
    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // 检查 index 索引位置是否存在元素
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        // 初始容量设置为 3
        MyArrayList<Integer> arr = new MyArrayList<>(3);

        // 添加 5 个元素
        for (int i = 1; i <= 5; i++) {
            arr.addLast(i);
        }

        arr.remove(3);
        arr.add(1, 9);
        arr.addFirst(100);
        int val = arr.removeLast();

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

}
