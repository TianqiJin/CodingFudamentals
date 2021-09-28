package org.tianqj.fundamentals.bfs;

import org.tianqj.fundamentals.models.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    public List<Integer> solution(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode first = queue.poll();
            result.add(first.val);
            if (first.left != null) {
                queue.add(first.left);
            }
            if (first.right != null) {
                queue.add(first.right);
            }
        }

        return result;
    }

}
