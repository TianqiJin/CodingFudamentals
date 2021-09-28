package org.tianqj.fundamentals.bst;

import org.tianqj.fundamentals.models.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode solution(int[] nums) {
        return convertSortedArray(nums, 0, nums.length - 1);
    }

    private TreeNode convertSortedArray(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode currentNode = new TreeNode(nums[mid]);
        currentNode.left = convertSortedArray(nums, start, mid - 1);
        currentNode.right = convertSortedArray(nums, mid + 1, end);

        return currentNode;
    }
}
