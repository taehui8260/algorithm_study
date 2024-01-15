package com.lth.algorithm.programmers;

public class correctParenthesis {
    public static void main(String[] args) {

    }
    static boolean solution(String s) {
        boolean answer = true;
        int check = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                check++;
            }else{
                check--;
            }
            if(check <0){
                break;
            }
        }
        if(check != 0){
            answer = false;
        }
        return answer;
    }
}
