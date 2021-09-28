package org.tianqj.fundamentals.strings;

/**
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * Example 2:
 *
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 * Example 3:
 *
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *
 *
 * Constraints:
 *
 * 1 <= num1.length, num2.length <= 104
 * num1 and num2 consist of only digits.
 * num1 and num2 don't have any leading zeros except for the zero itself.
 */
public class AddStrings {

    public String solution(String num1, String num2) {
        int numOneLength = num1.length() - 1;
        int numTwoLength = num2.length() - 1;
        StringBuffer sb = new StringBuffer();
        boolean needBorrow = false;
        while(numOneLength >= 0 || numTwoLength >= 0) {
            int firstNum = numOneLength >=0? Integer.parseInt(String.valueOf(num1.charAt(numOneLength--))) : 0;
            int secondNum = numTwoLength >=0? Integer.parseInt(String.valueOf(num2.charAt(numTwoLength--))) : 0;
            int currentNum = firstNum + secondNum;

            if (needBorrow) {
                currentNum += 1;
            }
            sb.append(currentNum % 10);
            if (currentNum / 10 > 0) {
                needBorrow = true;
            } else {
                needBorrow = false;
            }
        }
        if (needBorrow) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }

}
