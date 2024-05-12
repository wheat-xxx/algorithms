package algorithms_02;

import java.util.*;

/**
 * 图的遍历
 * @author wheat
 * @date 2023/12/01  14:53
 */
public class Solution_133 {

    public static class Node{
        int val;
        List<Node> neighbors;

        public Node() {
            this.val = 0;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    /**
     * 无向连通图--邻接表
     * 通过图中的一个节点遍历所有的节点，并对图进行deepcopy
     * @param node
     * @return
     */
    public Node cloneGraph_1(Node node) {
        if(node == null) return null;
        // 遍历所有的节点
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node.val, node);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            List<Node> neighbors = current.neighbors;
            for(Node n : neighbors) {
                if(!map.containsKey(n.val)) {
                    map.put(n.val, n);
                    queue.add(n);
                }
            }
        }

        // clone graph
        Map<Integer, Node> new_map = new HashMap<>();
        for(Integer val : map.keySet()) {
            Node n = new Node(val);
            new_map.put(val, n);
        }
        for(Map.Entry<Integer, Node> entry : new_map.entrySet()) {
            List<Node> oldNeighbors = map.get(entry.getKey()).neighbors;
            for(Node n : oldNeighbors) {
                entry.getValue().neighbors.add(new_map.get(n.val));
            }
        }

        return new_map.get(1);
    }

    private Map<Node, Node> visited = new HashMap<>();  // 深度优先遍历中标记已访问过的节点
    /**
     * 深度优先搜索遍历
     * @param node
     * @return
     */
    public Node cloneGraph_2(Node node) {
        if(node == null) return null;

        // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
        if(visited.containsKey(node)) return visited.get(node);

        // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node, cloneNode);

        // 遍历该节点的邻居并更新克隆节点的邻居列表
        for(Node n : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph_2(n));
        }

        return cloneNode;
    }

    /**
     * 广度优先搜索遍历
     * @param node
     * @return
     */
    public Node cloneGraph_3(Node node) {
        if (node == null) return null;

        Map<Node, Node> visited = new HashMap<>();

        // 将题目给定的节点添加到队列
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        // 克隆第一个节点并存储到哈希表中
        visited.put(node, new Node(node.val, new ArrayList<>()));

        // 广度优先搜索
        while(!queue.isEmpty()) {
            // 取出队列的头节点
            Node n = queue.poll();
            // 遍历该节点的邻居
            for(Node neighbor : n.neighbors) {
                // 如果没有被访问过，就克隆并存储在哈希表中
                if(!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    // 将邻居节点加入队列中
                    queue.add(neighbor);
                }
                // 更新当前节点的邻居列表
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }

}
