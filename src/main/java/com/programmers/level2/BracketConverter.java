package com.programmers.level2;

/**
 * 괄호 변환
 *
 * 균형잡힌 괄호 찾기
 *
 */
public class BracketConverter {
    public static void main(String[] args) {

    }
    public String solution(String p) {
        String answer = "";
        return answer;
    }

    boolean findBalancedBrackets(String brackets){
        int balance = 0;
        for(int i=0; i<brackets.length(); i++){
            if(brackets.charAt(i) == ')'){
                balance--;
            }
            if(brackets.charAt(i) == '('){
                balance++;
            }
            if(balance == 0){
                return true;
            }
        }
        return false;
    }
    boolean findValidBrackets(String brackets){
        return true;
    }

}
