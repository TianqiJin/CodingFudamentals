package org.tianqj.fundamentals.dfs;

import org.junit.Test;
import org.tianqj.fundamentals.models.TreeNode;

public class DepthFirstSearchPreOrderTest {

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        DepthFirstSearchPreOrder depthFirstSearchPreOrder = new DepthFirstSearchPreOrder();
        System.out.println(depthFirstSearchPreOrder.solution(treeNode));
    }
}
