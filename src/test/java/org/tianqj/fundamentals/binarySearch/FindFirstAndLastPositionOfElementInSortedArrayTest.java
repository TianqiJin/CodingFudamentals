package org.tianqj.fundamentals.binarySearch;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArrayTest {

    FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray;

    @Before
    public void setup() {
        findFirstAndLastPositionOfElementInSortedArray = new FindFirstAndLastPositionOfElementInSortedArray();
    }

    @Test
    public void test() {
        int[] input = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.solution(input, target)));
        int[] input2 = {2, 2};
        target = 2;
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray.solution(input2, target)));
    }
}
