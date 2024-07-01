package com.programmers.level2;

import java.util.LinkedList;
import java.util.List;

/**
 * 문자열 압축
 * <p>
 * 약수로 짜른다.
 */
public class StringCompression {

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression.solution("abcabcdede"));
    }

    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        List<Integer> divisors = findDivisors(s.length());
        System.out.println(divisors);
        for (Integer divisor : divisors) {
            String resultString = "";
            int index = 1;
            String standardString = s.substring(0, divisor);
            for (int i = divisor; i <= s.length() - divisor; ) {
                String substring = s.substring(i, i + divisor);
                if (standardString.equals(substring)) {
                    index++;
                    if (i == s.length() - divisor) {
                        if (index != 1) {
                            resultString = resultString + Integer.toString(index) + standardString;
                        } else {
                            resultString = resultString + standardString;
                        }
                        break;
                    }
                } else {
                    if (index != 1) {
                        resultString = resultString + Integer.toString(index) + standardString;
                    } else {
                        resultString = resultString + standardString;
                    }
                    standardString = substring;
                    index = 1;
                }
                i += divisor;
            }
            System.out.println("### standardString: " + standardString);
            System.out.println("### resultString: " + resultString);
            answer = Math.min(answer, resultString.length());
        }

        return answer == Integer.MAX_VALUE ? s.length() : answer;
    }

    private List<Integer> findDivisors(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
