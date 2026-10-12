package algorithms_01;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/11  16:23
 */
public class Solution_71 {

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        // 一个或多个 / 作为分隔符
        String[] parts = path.split("/+");

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else {
                stack.offerLast(part);
            }
        }

        return "/" + String.join("/", stack);
    }

}
