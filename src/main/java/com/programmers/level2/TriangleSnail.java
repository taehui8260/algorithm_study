package com.programmers.level2;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 삼각 달팽이
 */
public class TriangleSnail {
    public static void main(String[] args) {

    }
    //
    public int[] solution(int n) {
        int[][] triangleMap = new int [n][n];
        int startX = 0;
        int startY = -1;
        int index = 0;
        for(int i=n; i>0; i--){
            for(int j=i; j>0; j--){
                if((n-i) % 3 == 0){
                    triangleMap[++startY][startX] = ++index;
                }
                if((n-i) % 3 == 1){
                    triangleMap[startY][++startX] = ++index;
                }
                if((n-i) % 3 == 2){
                    triangleMap[--startY][--startX] = ++index;
                }
            }
        }
        List<Integer> result = new LinkedList<>();
        for(int item [] : triangleMap){
            for(int item_2: item){
                if(item_2 != 0){
                    result.add(item_2);
                }
            }
        }
        int[] answer =  result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
