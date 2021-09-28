package org.tianqj.fundamentals.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] solution(int[] nums, int target) {
        List<Integer> resultList = new  ArrayList<>();
        findResultRecur(0, nums.length - 1, nums, target, resultList);
        finalizeResultList(resultList);
        return new int[]{resultList.get(0), resultList.get(1)};
    }

    public void findResultRecur(int start, int end, int[] nums, int target, List<Integer> resultList) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            addToResultList(resultList, mid);
            findResultRecur(start, mid - 1, nums, target, resultList);
            findResultRecur(mid + 1, end, nums, target, resultList);
        } else if (nums[mid] > target) {
            findResultRecur(start, mid - 1, nums, target, resultList);
        } else {
            findResultRecur(mid + 1, end, nums, target, resultList);
        }
    }

    public void addToResultList(List<Integer> resultList, int index) {
        if (resultList.isEmpty()) {
            resultList.add(index);
        } else if (resultList.size() == 1) {
            if (index < resultList.get(0)) {
                int tmp = resultList.get(0);
                resultList.set(0, index);
                resultList.add(tmp);
            } else {
                resultList.add(index);
            }
        } else {
            if (index > resultList.get(1)) {
                resultList.set(1, index);
            } else if(index < resultList.get(0)) {
                resultList.set(0, index);
            }
        }
    }

    public void finalizeResultList(List<Integer> resultList) {
        if (resultList.isEmpty()) {
            resultList.add(-1);
            resultList.add(-1);
        } else if (resultList.size() == 1) {
            resultList.add(resultList.get(0));
        }
    }
}
