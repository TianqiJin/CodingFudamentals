package org.tianqj.fundamentals.bfs;

import org.junit.Test;

public class NumberOfIslandsTest {
    
    @Test
    public void test() {
        char[][]grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.solution(grid));
    }
}
