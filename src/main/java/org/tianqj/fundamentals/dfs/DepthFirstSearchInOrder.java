package org.tianqj.fundamentals.dfs;

import org.tianqj.fundamentals.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearchInOrder {

    public List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);

        return result;
    }

    public void inOrder(TreeNode node, List<Integer> result) {
        if (node != null) {
            inOrder(node.left, result);
            result.add(node.val);
            inOrder(node.right, result);
        }
    }
}
