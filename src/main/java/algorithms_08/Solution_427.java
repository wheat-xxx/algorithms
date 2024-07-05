package algorithms_08;

import algorithms_09.Solution_452;
import algorithms_10.Solution_502;

/**
 * @author wheat
 * @date 2024/06/27  14:43
 */
public class Solution_427 {

    private class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    /**
     * 递归构建
     * @param grid
     * @return
     */
    public Node construct(int[][] grid) {
        return construct(grid, 0, grid.length - 1, 0, grid.length - 1);
    }

    public Node construct(int[][] grid, int row1, int row2, int col1, int col2) {
        Node root = new Node();

        int count = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                if (grid[i][j] == 1) count++;
            }
        }

        // 判断是否是叶子结点
        if (count == 0 || count == (row2 - row1 + 1) * (col2 - col1 + 1)) {
            root.val = count == 0 ? false : true;
            root.isLeaf = true;
            return root;
        }

        // 不是叶子结点
        root.isLeaf = false;
        root.topLeft = construct(grid, row1, (row1 + row2) / 2, col1, (col1 + col2) / 2);
        root.topRight = construct(grid, row1, (row1 + row2) / 2, (col1 + col2) / 2 + 1, col2);
        root.bottomLeft = construct(grid, (row1 + row2) / 2 + 1, row2, col1, (col1 + col2) / 2);
        root.bottomRight = construct(grid, (row1 + row2) / 2 + 1, row2, (col1 + col2) / 2 + 1, col2);
        return root;
    }


}
