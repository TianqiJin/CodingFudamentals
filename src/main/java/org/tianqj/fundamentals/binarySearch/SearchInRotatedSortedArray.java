package org.tianqj.fundamentals.binarySearch;

import org.tianqj.fundamentals.bst.SearchInABinarySearchTree;

/**
 *There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInRotatedSortedArray {

    public static class ResultIndex {
        int index;
    }

    public int solution(int[] nums, int target) {
        if (nums.length == 1) {
            if (target == nums[0]) {
                return 0;
            } else {
                return - 1;
            }
        } else {
            ResultIndex resultIndex = new ResultIndex();
            findRotatedIndex(0, nums.length - 1, nums, resultIndex);
            int pivot = resultIndex.index;
            int result = -1;

            if (nums[pivot] <= target && target <= nums[nums.length - 1]) {
                result = binarySearch(pivot, nums.length - 1, nums, target);
            } else {
                result = binarySearch(0, pivot - 1, nums, target);
            }
            return result;
        }
    }

    public void findRotatedIndex(int start, int end, int[] nums, ResultIndex resultIndex) {
        if (start > end) {
            return;
        }

        int mid = (start + end) / 2;
        if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
            resultIndex.index  = mid;
            return;
        }
        findRotatedIndex(mid + 1, end, nums, resultIndex);
        findRotatedIndex(start, mid - 1, nums, resultIndex);
    }

    public int binarySearch(int start, int end, int[] nums, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(mid + 1, end, nums, target);
        } else {
            return binarySearch(start, mid - 1, nums, target);
        }
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.solution(new int[]{4,5,6,7,0,1,2}, 1));
    }
}
