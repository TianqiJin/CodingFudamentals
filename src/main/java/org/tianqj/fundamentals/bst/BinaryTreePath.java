package org.tianqj.fundamentals.bst;

import org.tianqj.fundamentals.models.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePath {

    public List<String> solution(TreeNode root) {
        List<List<Integer>> tmpResult = new ArrayList<>();
        preOrderTraverse(root, new Stack<>(), tmpResult);

        List<String> result = new ArrayList<>();
        tmpResult.forEach(tmp -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmp.size(); i++) {
                sb.append(tmp.get(i));
                if (i != tmp.size() - 1) {
                    sb.append("->");
                }
            }
            result.add(sb.toString());
        });

        return result;
    }

    public void preOrderTraverse(TreeNode node, Stack<Integer> currentPath, List<List<Integer>> result) {
        if (node != null) {
            currentPath.push(node.val);
            if (node.left == null && node.right == null) {
                result.add(new ArrayList<Integer>(currentPath));
            }
            preOrderTraverse(node.left, currentPath, result);
            preOrderTraverse(node.right, currentPath, result);
            currentPath.pop();
        }
    }

}
