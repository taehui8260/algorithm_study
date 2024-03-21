package com.programmers.level2;

import java.util.*;

public class MakeMin {
    public static void main(String[] args) {
        int[] a = {1, 4, 2};
        int[] b = {5, 4, 4};
        solution(a,b);
    }
    static public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        int bLength = B.length;

        for(int i=0; i<bLength; i++){
            answer += A[i] * B[bLength-1 -i];
        }
        System.out.println(answer);
        return answer;
    }
}
