package com.programmers.level2;

/**
 * 괄호 변환
 *
 * 균형잡힌 괄호 찾기
 *
 * 두 문자열 분리(u, v)
 * u의 올바른 균형잡힌 여부에 따라 분기처리
 *
 * 균형잡힌 경우
 * u + 처음부터 v
 *
 * 균형잡힌 경우가 아닌 경우
 *
 * ( + 처음부터 v + ) + 뒤집은 u
 *
 */
public class BracketConverter {
    public static void main(String[] args) {
        BracketConverter bracketConverter = new BracketConverter();
        System.out.println(bracketConverter.solution("()))((()"));
    }
    public String solution(String p) {
        return makeBalanceBrackets(p);
    }

    //괄호 뒤집기
    String changeBrackets(String brackets){
        StringBuilder result = new StringBuilder();
        String temp = brackets.substring(1, brackets.length()-1);
        for(int i=0; i<temp.length(); i++){
            if(temp.charAt(i) == '('){
                result.append(")");
            } else{
                result.append("(");
            }
        }
        return String.valueOf(result);
    }
    String makeBalanceBrackets(String brackets){
        if(brackets.length() == 0){
            return "";
        }
        String result = "";
        int balance = 0;
        int index = 0;
        for(int i=0; i<brackets.length(); i++){
            if(brackets.charAt(i) == ')'){
                balance--;
            }
            if(brackets.charAt(i) == '('){
                balance++;
            }
            if(balance == 0){
                index = i;
                break;
            }
        }
        //균형잡힌 분자열
        if(brackets.charAt(0) == ')'){
            result = "(" + makeBalanceBrackets(brackets.substring(index+1)) + ")" + changeBrackets(brackets.substring(0, index+1));
        }
        //올바른 분자열
        if(brackets.charAt(0) == '('){
            result = brackets.substring(0, index+1) + makeBalanceBrackets(brackets.substring(index+1));
        }
        return result;
    }
}
