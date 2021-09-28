package org.tianqj.fundamentals.dfs;

import org.junit.Test;
import org.tianqj.fundamentals.models.TreeNode;

public class DepthFirstSearchInOrderTest {

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        DepthFirstSearchInOrder depthFirstSearchInOrder = new DepthFirstSearchInOrder();
        System.out.println(depthFirstSearchInOrder.solution(treeNode));
    }
}
