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
        System.out.println(stringCompression.solution("aabbaccc"));
    }

    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for (int divisor = 1; divisor <= s.length()/2; divisor++) {
            StringBuilder resultString = new StringBuilder();
            int index = 1;
            String standardString = s.substring(0, divisor);
            int i = divisor;
            while (true) {
                if(i + divisor > s.length()){
                    if (index != 1) {
                        resultString.append(Integer.toString(index)).append(standardString).append(s.substring(i));
                    } else {
                        resultString.append(standardString).append(s.substring(i));
                    }
                    break;
                }

                String substring = s.substring(i, i + divisor);
                if (standardString.equals(substring)) {
                    index++;
                } else {
                    if (index != 1) {
                        resultString.append(Integer.toString(index)).append(standardString);
                    } else {
                        resultString.append(standardString);
                    }
                    standardString = substring;
                    index = 1;
                }
                i += divisor;
            }
            answer = Math.min(answer, resultString.length());
        }
        return answer == Integer.MAX_VALUE ? s.length() : answer;
    }
}
