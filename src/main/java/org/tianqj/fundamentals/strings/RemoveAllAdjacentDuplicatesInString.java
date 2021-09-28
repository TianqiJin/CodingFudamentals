package org.tianqj.fundamentals.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 *
 * We repeatedly make duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * Example 2:
 *
 * Input: s = "azxxzy"
 * Output: "ay"
 */
public class RemoveAllAdjacentDuplicatesInString {

    private char emptyChar = ' ';
    public String solution(String s) {
        Set<Integer> set = new HashSet<>();
        set.stream().sorted();
        StringBuffer sb = new StringBuffer();
        char[] charArray = s.toCharArray();
        for (int left = 0, right = 1; left < s.length() && right < s.length(); left++, right++) {
            if (s.charAt(left) == s.charAt(right)) {
                right = findTheLongestRemoveArea(left, right, charArray);
                left = right - 1;
            }
        }

        for (char c: charArray) {
            if (c != emptyChar) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    protected int findTheLongestRemoveArea(int left, int right, char[]charArray) {
        while(left >= 0 && right < charArray.length) {
            while(left >= 0 && charArray[left] == emptyChar) {
                left--;
            }
            while(right < charArray.length && charArray[right] == emptyChar) {
                right++;
            }

            if (left < 0 || right >= charArray.length) {
                break;
            }
            if (charArray[left] != charArray[right]){
                break;
            }
            charArray[left] = emptyChar;
            charArray[right] = emptyChar;
            left -= 1;
            right += 1;
        }

        return right;
    }
}
