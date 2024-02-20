package com.lth.algorithm.programmers.level2;

import java.math.BigInteger;

public class FibonacciNumbers {
    public static void main(String[] args) {
        System.out.print(solution2(100000));
    }
    static public int solution(int n) {
        int answer = (int)fibonacci(n)%1234567;
        return answer;
    }
    static public int fibonacci(int n){
        BigInteger first = new BigInteger("0");
        BigInteger second = new BigInteger("1");
        BigInteger temp = new BigInteger("0");

        for(int i = 0; i < n-1; i++){
            temp = first.add(second);
            first = second;
            second = temp;
        }
        return temp.mod(new BigInteger("1234567")).intValue();
    }

    static public int solution2(int n) {
        int answer = (int)fibonacci2(n)%1234567;
        return answer;
    }
    static public int fibonacci2(int n){
        int first = 0;
        int second = 1;
        int temp = 2;

        for(int i = 0; i < n-1; i++){
            temp = first + second;
            first = second % 1234567;
            second = temp % 1234567;
        }
        return temp;
    }
}
