package com.lth.algorithm.programmers;

import java.util.Arrays;

public class SliceAry {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 2, 5)));
    }
    static public int[] solution(int n, long left, long right) {
        int maxNum = (int) (right - left) +1;
        int[] answer = new int[(int) (maxNum)];
        int index = 0;
        System.out.println((int) (left/n));
        for(long i = left; i<=right; i++){
            long x  = i % n;
            long y = i / n;
            answer[index++] = (int) (Math.max(x, y)) + 1;
        }
        return answer;
    }
}
