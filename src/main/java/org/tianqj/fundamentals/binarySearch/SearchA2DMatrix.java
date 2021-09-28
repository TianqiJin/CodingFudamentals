package org.tianqj.fundamentals.binarySearch;

public class SearchA2DMatrix {

    public boolean solution(int[][] matrix, int target) {

        int rowNumber = findRowNumber(0, matrix.length - 1, matrix, target);
        int result = -1;
        if (rowNumber == -1) {
            return false;
        } else {
            result = binarySearch(0, matrix[rowNumber].length - 1, matrix, target, rowNumber);
        }

        if (result != -1) {
            return true;
        }
        return false;
    }

    public int binarySearch(int start, int end, int[][]matrix, int target, int rowNumber) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end)/2;
        if (matrix[rowNumber][mid] == target) {
            return mid;
        } else if (matrix[rowNumber][mid] < target) {
            return binarySearch(mid + 1, end, matrix, target, rowNumber);
        } else {
            return binarySearch(start, mid - 1, matrix, target, rowNumber);
        }
    }

    public int findRowNumber(int start, int end, int[][]matrix, int target) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (target == matrix[mid][0]) {
            return mid;
        }
        if (target < matrix[mid][0]) {
            if (mid - 1 < 0) {
                return - 1;
            } else {
                if (matrix[mid - 1][0] <= target) {
                    return mid - 1;
                } else {
                    return findRowNumber(start, mid - 1, matrix, target);
                }
            }
        } else {
            if (mid + 1 > end) {
                if (matrix[mid][matrix[mid].length - 1] >= target ) {
                    return mid;
                } else {
                    return -1;
                }
            } else {
                if (matrix[mid + 1][0] > target) {
                    return mid;
                } else {
                    return findRowNumber(mid + 1, end, matrix, target);
                }
            }
        }
    }

    public static void main(String[] args) {
        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        int[][] input = {{1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}};
        System.out.println(searchA2DMatrix.solution(input, 7));
    }
}
