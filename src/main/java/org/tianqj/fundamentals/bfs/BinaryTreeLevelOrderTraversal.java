package org.tianqj.fundamentals.bfs;

import org.tianqj.fundamentals.models.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {

    public static class TreeNodeWithHeight {
        TreeNode node;
        int height;

        public TreeNodeWithHeight(TreeNode node, int height) {
            this.node = node;
            this.height = height;
        }
    }

    public List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNodeWithHeight> queue = new ArrayDeque<>();
        queue.add(new TreeNodeWithHeight(root, 0));
        while (!queue.isEmpty()) {
            TreeNodeWithHeight first = queue.poll();
            if (result.size() <= first.height) {
                result.add(new ArrayList<>());
            }
            result.get(first.height).add(first.node.val);
            if (first.node.left != null) {
                queue.add(new TreeNodeWithHeight(first.node.left, first.height + 1));
            }
            if (first.node.right != null) {
                queue.add(new TreeNodeWithHeight(first.node.right, first.height + 1));
            }
        }

        return result;
    }

}
