package org.tianqj.fundamentals.bfs;

import org.junit.Test;
import org.tianqj.fundamentals.models.TreeNode;

public class BreadthFirstSearchTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        System.out.println(breadthFirstSearch.solution(root));
    }
}
