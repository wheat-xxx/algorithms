# BFS框架

~~~java
// 计算从起点 start 到终点 target 的最近距离
int BFS(Node start, Node target) {
    Queue<Node> queue; // 核心数据结构
    Set<Node> visited; // 避免走回头路

    // 将起点加入队列
    queue.offer(start);
    visited.add(start);
    
    while(!queue.isEmpty()) {
        int size = queue.size();
        /* 将当前队列中的所有节点向四周扩散 */
        for (int i = 0; i < size; i++) {
            Node cur = queue.poll();
            /* 划重点：这里判断是否到达终点 */
            if (cur == target) {
                return step;
            }
            /* 将 cur 的相邻节点加入队列 */
            for(Node x : cur.adj()) {
                if (x not in visited){
                    queue.offer(x);
                    visited.add(x);
                }
            }
        }
    }
    // 如果走到这里，说明在图中没有找到目标节点
}
~~~

---

# BFS面对的问题场景？

在一副图中找从start到target的最短距离；

---

