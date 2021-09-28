package org.tianqj.fundamentals.heaps;

import java.util.List;

public class MaxHeap {

    public int[] solution(int[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = input[i];
            maxHeapify(result, i);
        }

        return result;

    }

    public void maxHeapify(int[] result, int currentPosition) {
        while(currentPosition > 0) {
            int parentPosition = (currentPosition - 1) / 2;
            if (result[currentPosition] > result[parentPosition]) {
                int tmp = result[parentPosition];
                result[parentPosition] = result[currentPosition];
                result[currentPosition] = tmp;
            } else {
                return;
            }

            currentPosition = parentPosition;
        }
    }
}
