package com.lth.algorithm.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {
    public static void main(String[] args) {
        Sort sort = new Sort();
        System.out.println(sort.solution(new int[]{300,30030030, 12, 4, 647467454, 2222, 2, 0, 260}));
    }
    // 길이가 같을 경우 그냥 비교한다.
    // 길이가 다를경우 맨 가장 앞부터 하나씩 비교
    // 끝까지 비교했는데 같은값이 나올경우 짧은 문자열의 길이만큼 긴 문자열을 자른 후 비교
    // 위의 과정을 계속 반복

    // 만약 문자열의 앞자리가 0이면 0 출력
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] answerArray = new String[numbers.length];
        for(int i=0; i<numbers.length;i++) {
            answerArray[i] = String.valueOf(numbers[i]);
        }
        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                while(true) {
                    if(s1.length() ==  s2.length())
                        return s2.compareTo(s1);
                    if(s1.length() <  s2.length()) {
                        for (int i = 0; i < s1.length(); i++) {
                            if (s1.charAt(i) != s2.charAt(i))
                                return s2.substring(i, i + 1).compareTo(s1.substring(i, i + 1));
                        }
                        s2 = s2.substring(s1.length());
                    }
                    if(s1.length() >  s2.length()) {
                        for (int i = 0; i < s2.length(); i++) {
                            if (s1.charAt(i) != s2.charAt(i))
                                return s2.substring(i, i + 1).compareTo(s1.substring(i, i + 1));
                        }
                        s1 = s1.substring(s2.length());
                    }
                }
            }
        };
        // Comparator를 사용하여 배열 정렬
        Arrays.sort(answerArray, customComparator);
        for (String item : answerArray){
            answer.append(item);
        }
        return answer.substring(0,1).equals("0")?"0":String.valueOf(answer);
    }
}
