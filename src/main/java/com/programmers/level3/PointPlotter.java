package com.programmers.level3;

/**
 * 점 찍기
 *
 */
public class PointPlotter {
    public long solution(int k, int d) {
        long answer = 0;
        long [] point = {0, 0};
        long index = 1;
        while(true){
            point[1] = k * index++;
            if(point[1] > d){
                point[1] = point[1] - k;
                answer = point[1] / k + 1;
                break;
            }
        }
        for(long i=1; i * k <= d; i++){
            point[0] = k * i;
            while(true){
                if((point[0] * point[0] + point[1] * point[1]) <= (long) d * d){
                    answer = answer + point[1]/k + 1;
                    break;
                } else{
                    point[1] = point[1] - k;
                    if(point[1] < 0){
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
