package org.tianqj.fundamentals.heaps;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MaxHeapTest {
    MaxHeap maxHeap;
    @Before
    public void setup() {
        maxHeap = new MaxHeap();
    }
    @Test
    public void test() {
        int[] input = {3, 1, 6, 5, 4, 2};
        int[] result = maxHeap.solution(input);
        System.out.println(Arrays.toString(result));
    }
}
