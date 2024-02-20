package com.lth.algorithm.programmers.level2;

public class LastCommonMultiple {
    public static void main(String[] args) {

    }
    static public int solution(int[] arr) {
        int answer = 0;
        int lcm = arr[0];
        for(int i=1; i<arr.length; i++){
            lcm = lcm(lcm, arr[i]);
        }
        return answer;
    }
    static int gdc(int a, int b){
        int r;
        while(b != 0){
            r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
    static int lcm(int a, int b){
        return (a * b)/gdc(a,b);
    }
}
