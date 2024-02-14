package com.lth.algorithm.programmers;

public class Tiling {
    public static void main(String[] args) {

    }
    //높이가 고정 되이있고 들어가는 최소 단위의 타일이 정해져 있기 때문에 이는 피보나치를 이룬다.
    //예들들어 길이가 4인 타일을 모두 채운다고 할떄에 모든 경우의 수를 생각해 보면 가장 뒤에 단위타일을 세로로 둔경우와 가로로 둔 경우 2개로 나눌 수 있다. 즉 단위타일을 세로로 둔 경우 길이가 2인 타일을 채우는 경우와 같고 단위타일을 가로로 둔 경우 길이가 3인 타일을 채우는 경우와 같다.
    // 1:1, 2:2, 3:3, 4:5, 5:8, 6:13 이런식으로 피보나치를 이룬다.
    public int solution(int n) {
        int answer = 0;
        int [] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for(int i=2; i<n; i++){
            result[i] = (result[i-2] + result[i-1]) % 1000000007;
        }
        return result[n-1];
    }
}
