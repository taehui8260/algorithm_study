package com.programmers.level3;

import java.util.Arrays;

/**
 * 거스름돈
 *
 * money를 오름차순 정렬
 *
 * dp[0] 부터  dp[n] 까지 0 ~ n원을 거스름 돈으로 줄 수 있는 경우를 구한다.
 */
public class Change {
    public int solution(int n, int[] money) {
        int [] changeAry = new int [n+1];
        Arrays.sort(money);
        int MOD = 1000000007;
        changeAry[0] = 1;

        for(int coin: money){
            for(int i=coin; i<n+1; i++){
                changeAry[i] = (changeAry[i] + changeAry[i-coin])/MOD;
            }
        }
        return changeAry[n];
    }
}
