package com.programmers.level2;

public class ExpressionNum {
    public static void main(String[] args) {
        solution(15);
    }
    static public int solution(int n) {

        int answer = 1;
        for(int i=1; n-sum(i)>0; i++){
            if((n-sum(i))%(i+1) == 0){
                answer++;
            }
        }
        return answer;
    }
    static public int sum(int n) {
        int result = 0;
        for(int i=1; i<=n; i++){
            result += i;
        }
        return result;
    }
}
