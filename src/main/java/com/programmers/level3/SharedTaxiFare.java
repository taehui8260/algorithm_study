package com.programmers.level3;
import java.util.*;
/**
 * 택시 합승 요금
 *
 * 플로이드 워셜 알고리즘을 이용한 최소거리 찾기
 */
public class SharedTaxiFare {
    public static void main(String[] args) {

    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] map = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!(i == j)){
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int[] item: fares){
            map[item[0]-1][item[1]-1] = item[2];
            map[item[1]-1][item[0]-1] = item[2];
        }
        //플로이드 워셜 알고리즘
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][k] == Integer.MAX_VALUE ||  map[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    if(map[i][k] + map[k][j] < map[i][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        for(int[] item: map){
            answer = Math.min(item[s-1] + item[a-1] + item[b-1], answer);
        }
        return answer;
    }
}
