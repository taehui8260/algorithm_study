package com.programmers.level3;

/**
 * 정수 삼각형
 *
 * 가장 큰 수가 오려면 큰 수가 더해져야 한다.
 * 자신에게 올 수 있는 수중 큰수를 받아 더한다.
 * 이과졍을 마지막 까지 하면 된다.
 *
 */
public class IntegerTriangle {
    public static void main(String[] args) {

    }
    public int solution(int[][] triangle) {
        int answer = 0;
        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j>0 && j<triangle[i].length-1){
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                } else if(j == 0){
                    triangle[i][j] += triangle[i-1][j];
                } else{
                    triangle[i][j] += triangle[i-1][j-1];
                }
                if(i == triangle.length-1){
                    answer = Math.max(answer, triangle[i][j]);
                }
            }
        }
        return answer;
    }
}
