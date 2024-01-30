package com.lth.algorithm.programmers;

import java.util.Arrays;

public class EatTheLoad {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
    }
    //dfs를 하면 너무 많은 경우가 나올꺼 같은데....
    static int solution(int[][] land) {
        int answer = 0;
        int maxValue = 0;
        for(int i=1; i<land.length; i++){
            for(int j=0; j<land[i].length; j++){
                maxValue = 0;

                for(int z=0; z<land[i-1].length; z++){
                    if(j != z){
                        maxValue = Math.max(maxValue, land[i-1][z]);
                    }
                }
                land[i][j] = maxValue + land[i][j];
                if(i == land.length-1){
                    answer = Math.max(answer, land[i][j]);
                }
            }
        }
        return answer;
    }
}
