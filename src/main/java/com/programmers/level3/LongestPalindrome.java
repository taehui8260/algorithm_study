package com.programmers.level3;

/**
 * 가장 긴 팰린드룸
 *
 *
 *
 */
public class LongestPalindrome {
    public int solution(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            result = Math.max(result, expandAroundCenter(s, i, i)); // 홀수 길이 회문 체크
            result = Math.max(result, expandAroundCenter(s, i, i + 1)); // 짝수 길이 회문 체크
        }

        return result;
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // 회문 길이 반환
    }
}
