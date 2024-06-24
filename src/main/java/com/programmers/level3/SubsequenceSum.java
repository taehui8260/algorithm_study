package com.programmers.level3;

/**
 * 연속 펄스 부분 수열의 합
 *
 * 수열 확인
 * 첫번째 값부터 하나씩 -1, +1을 반복하면서 최대값을 찾는다.
 *
 * 만약 0보다 작아질 경우 초기화 다음값부터 다시 부분 수열 끝까지 반복
 */
public class SubsequenceSum {
    public long solution(int[] sequence) {
        long maxValue_1 = 0;
        long maxValue_2 = 0;

        long curSumValue_1 = 0;
        long curSumValue_2 = 0;

        long pulse = 1;

        for (int j : sequence) {
            if (curSumValue_1 + pulse * j > 0) {
                curSumValue_1 += pulse * j;
            } else {
                curSumValue_1 = 0;
            }
            pulse *= -1;
            if (curSumValue_2 + pulse * j > 0) {
                curSumValue_2 += pulse * j;
            } else {
                curSumValue_2 = 0;
            }
            maxValue_1 = Math.max(maxValue_1, curSumValue_1);
            maxValue_2 = Math.max(maxValue_2, curSumValue_2);
        }
        return Math.max(maxValue_1, maxValue_2);
    }
}
