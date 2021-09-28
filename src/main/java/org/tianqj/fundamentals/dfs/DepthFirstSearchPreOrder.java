package org.tianqj.fundamentals.dfs;

import org.tianqj.fundamentals.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearchPreOrder {

    public List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);

        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            preorder(node.left, result);
            preorder(node.right, result);
        }
    }
}
