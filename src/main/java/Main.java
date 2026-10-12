import java.util.*;

/**
 *
 * @author wheat
 * @date 2023/03/06  19:27
 */
public class Main {

    public static void main(String[] args) {
        Main mainInstance = new Main();
    }

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

