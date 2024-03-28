package com.programmers.level3;

import java.util.Arrays;

/**
 * 단속카메라
 *
 * 진입 시점순으로 정렬을 한다.
 * 다음 차의 진입 시점과 진출 시점을 보고 교집합을 구한다. 없으면 + 1
 *
 *
 */
public class SpeedDetectionCamera {
    public static void main(String[] args) {
        SpeedDetectionCamera speedDetectionCamera = new SpeedDetectionCamera();
        System.out.print(speedDetectionCamera.solution(new int [][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[0], b[0]));

        int []temp = routes[0];
        for(int i=1; i<routes.length; i++){
            if(temp[1] >= routes[i][0]){
                temp[0] = routes[i][0];
                temp[1] = Math.min(temp[1], routes[i][1]);
            } else{
                temp = routes[i];
                answer++;
            }
        }
        return ++answer;
    }
}
