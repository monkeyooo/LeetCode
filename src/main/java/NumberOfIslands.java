package src.main.java;
/*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
["1","1","1","1","0"],
["1","1","0","1","0"],
["1","1","0","0","0"],
["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
["1","1","0","0","0"],
["1","1","0","0","0"],
["0","0","1","0","0"],
["0","0","0","1","1"]
]
Output: 3*/


public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        if (grid == null) return 0;

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    // dfs
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int vertical, int horizontal) {
        if (vertical < 0 || vertical >= grid.length) { // should use equals to avoid index out of bounds
            return;
        }
        if (horizontal < 0 || horizontal >= grid[0].length) { // should use equals to avoid index out of bounds
            return;
        }
        if (grid[vertical][horizontal] == '0') return;
        grid[vertical][horizontal] = '0'; // mark as visited

        dfs(grid, vertical + 1, horizontal);
        dfs(grid, vertical, horizontal + 1);
        dfs(grid, vertical, horizontal - 1);
        dfs(grid, vertical - 1, horizontal);

    }
}
