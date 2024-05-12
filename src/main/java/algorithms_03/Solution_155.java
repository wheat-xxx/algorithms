package algorithms_03;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wheat
 * @date 2023/12/03  19:13
 */
public class Solution_155 {

    class MinStack {
        private Deque<Integer> dataStack;
        private Deque<Integer> minStack;

        public MinStack() {
            dataStack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            dataStack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
