package algorithms_04;

import java.util.*;

/**
 * @author wheat
 * @date 2023/12/19  16:44
 */
public class Solution_207 {

//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        boolean[][] flags = new boolean[numCourses][numCourses];
//        for (int i = 0; i < numCourses; i++) {
//            Arrays.fill(flags[i], false);
//        }
//
//        for (int i = 0; i < prerequisites.length; i++) {
//            flags[prerequisites[i][0]][prerequisites[i][1]] = true;
//        }
//
//        for (int i = 0; i < numCourses; i++) {
//            for (int j = i; j < numCourses; j++) {
//                if(flags[i][j] && flags[j][i]) return false;
//            }
//        }
//
//        return true;
//    }

    /**
     * 广度优先搜索遍历
     * @param numCourses
     * @param prerequisites prerequisites[][1]表示先修课程
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 节点就是0-numCourses
        // 邻接表存储图的边
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        // 存储节点的入度
        int[] inDegree = new int[numCourses];
        // 利用队列结合广度优先搜索遍历对图进行拓扑排序
        Queue<Integer> queue = new LinkedList<>();

        // 初始化图结构 以及每个节点的入度
        for(int[] edge : prerequisites) {
            edges.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }

        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int result = 0;
        while(!queue.isEmpty()) {
            // u -> v
            result++;
            int u = queue.poll();
            for(int v : edges.get(u)) {
                if(--inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        return result == numCourses;
    }


}
