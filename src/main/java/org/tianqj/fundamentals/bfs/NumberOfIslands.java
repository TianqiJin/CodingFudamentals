package org.tianqj.fundamentals.bfs;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 */

public class NumberOfIslands {

    public static class Coordinate {
        int i;
        int j;

        public Coordinate(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int solution(char[][] grid) {
        int result = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    result++;
                    bfs(new Coordinate(i, j), isVisited, grid);
                }
            }
        }

        return result;
    }

    private void bfs(Coordinate coordinate, boolean[][]isVisited, char[][]grid) {
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.add(coordinate);

        while(!queue.isEmpty()) {
            Coordinate current = queue.poll();
            isVisited[current.i][current.j] = true;
            List<Coordinate> adjacents = findAdjacent(isVisited, grid, current);
            adjacents.forEach(adjacent -> queue.add(new Coordinate(adjacent.i, adjacent.j)));
        }
    }

    private List<Coordinate> findAdjacent(boolean[][]isVisited, char[][]grid, Coordinate coordinate) {
        List<Coordinate> adjacents = new ArrayList<>();
        if (coordinate.i - 1 >= 0 && grid[coordinate.i - 1][coordinate.j] == '1' && !isVisited[coordinate.i - 1][coordinate.j]) {
            adjacents.add(new Coordinate(coordinate.i - 1, coordinate.j));
        }
        if (coordinate.i + 1 < grid.length && grid[coordinate.i + 1][coordinate.j] == '1' && !isVisited[coordinate.i + 1][coordinate.j]) {
            adjacents.add(new Coordinate(coordinate.i + 1, coordinate.j));
        }
        if (coordinate.j - 1 >= 0 && grid[coordinate.i][coordinate.j - 1] == '1' && !isVisited[coordinate.i][coordinate.j - 1]) {
            adjacents.add(new Coordinate(coordinate.i, coordinate.j - 1));
        }
        if (coordinate.j + 1 <  grid[coordinate.i].length && grid[coordinate.i][coordinate.j + 1] == '1' && !isVisited[coordinate.i][coordinate.j + 1]) {
            adjacents.add(new Coordinate(coordinate.i, coordinate.j + 1));
        }

        return adjacents;
    }


}
