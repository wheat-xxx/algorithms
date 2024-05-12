package labuladong.ds.stack_queue;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）
 * @author wheat
 * @date 2024/04/16  19:47
 */
public class Solution_232 {

    /**
     * 当stack2为空时，将stack1中的所有元素加入到stack2中
     */
    private class MyQueue {

        private Stack<Integer> stack1 = new Stack<>();  // 放入元素
        private Stack<Integer> stack2 = new Stack<>();  // 取元素
        private Integer count = 0;

        public MyQueue() {
        }

        public void push(int x) {
            stack1.push(x);
            count++;
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            count--;
            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return count == 0;
        }
    }

}
