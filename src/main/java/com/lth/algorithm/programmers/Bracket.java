package com.lth.algorithm.programmers;

public class Bracket {
    public static void main(String[] args) {

    }
    static public int solution(int n, int a, int b)
    {
        int answer = 1;
        int i = Math.abs(b-a);
        while(i > 1)
        {
            b = (b/2 + b%2);
            a = (a/2 + a%2);
            i = Math.abs(b-a);
            answer++;
        }
        return answer;
    }

}
