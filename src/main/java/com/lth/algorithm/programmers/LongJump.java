package com.lth.algorithm.programmers;

public class LongJump {
    public static void main(String[] args) {
        System.out.println(solution(2000));
    }
    static public long solution(int n) {
        long [] fibonacci = new long[2001];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        long answer = 1;
        //결국 값은 파보나치
        for(int i=2; i<=n; i++){
            fibonacci[i] = (fibonacci[i-2] + fibonacci[i-1]) % 1234567;
        }
        answer = fibonacci[n];
        return answer;
    }
    static long getResult(int n){
        long answer = 0;
        for(int i=0; i<=n; i++){
            if((n-i)%2 == 0){
                answer = answer + factorial((n-i)/2 + i)/(factorial(i) * factorial((n-i)/2));
                System.out.println("I: " + i);
                System.out.println("answer: " +answer);
            }
        }
        return answer;
    }
    static long factorial(int n){
        long factorial = 1;
        for(int i=1; i<=n; i++){
            factorial = factorial * i;
        }
        return factorial;
    }
}
