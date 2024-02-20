package com.lth.algorithm.programmers.level2;

public class ChangeJadenCase {
    public static void main(String[] args) {
        System.out.println(solution("aasda   asdgsgs    sdfsdf"));
    }
     static public String solution(String s) {
        String inputData = s.toLowerCase();
        String answer = "";
         answer = inputData.substring(0, 1).toUpperCase() + inputData.substring(1);
        for(int i=1; i<answer.length(); i++){
            if(answer.charAt(i-1)==' ' && answer.charAt(i) != ' '){
                answer = answer.substring(0, i) + answer.substring(i, i+1).toUpperCase() + answer.substring(i+1);
            }
        }
        return answer;
    }
}
