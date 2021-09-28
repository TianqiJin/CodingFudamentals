package org.tianqj.fundamentals.heaps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KthLargestNumberInAnArrayTest{
    KthLargestNumberInAnArray kthLargestNumberInAnArray;

    @Before
    public void setup() {
        kthLargestNumberInAnArray = new KthLargestNumberInAnArray();
    }

    @Test
    public void test() {
        int[] input = {3,2,3,1,2,4,5,5,6};
        int result = kthLargestNumberInAnArray.solution(input, 4);
        Assert.assertEquals(result, 4);
    }
}
