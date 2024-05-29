package com.programmers.level2;

import java.util.Arrays;

/**
 * 테이블 해시 함수
 *
 *
 */
public class TableHashFunction {
    public static void main(String[] args) {

    }
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (o1, o2) ->
            o1[col-1] - o2[col-1]
        );
        int[] S_i = new int[row_end - row_begin + 1];
        for(int i=0; i<S_i.length; i++){
            for(int item: data[row_begin + i]){
                S_i[i] += item % (row_begin + i);
            }
        }
        for(int i=0; i<S_i.length; i++){
            answer ^= S_i
        }
        return answer;
    }
}
