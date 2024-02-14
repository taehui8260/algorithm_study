package com.lth.algorithm.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {
    public static void main(String[] args) {
        Sort sort = new Sort();
        System.out.println(sort.solution(new int[]{3, 30, 34, 5, 9, 307 ,0}));
    }
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] answerArray = new String[numbers.length];
        for(int i=0; i<numbers.length;i++) {
            answerArray[i] = String.valueOf(numbers[i]);
        }
        // 첫 번째 글자를 기준으로 내림차순으로 정렬하는 Comparator
        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.equals("0") || s2.equals("0"))
                    return s2.compareTo(s1);
                return s2.split("0")[0].compareTo(s1.split("0")[0]);
            }
        };
        // Comparator를 사용하여 배열 정렬
        Arrays.sort(answerArray, customComparator);
        for (String item : answerArray){
            answer.append(item);
        }
        return String.valueOf(answer);
    }
}
