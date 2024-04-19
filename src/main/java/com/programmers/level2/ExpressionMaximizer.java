package com.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 수식 최대화
 */
public class ExpressionMaximizer {
    public static void main(String[] args) {
        ExpressionMaximizer expressionMaximizer = new ExpressionMaximizer();
        System.out.println(expressionMaximizer.solution("100-200*300-500+20"));
    }

    public long solution(String expression) {
        long answer = 0;
        String stringResult;
        char [][]signAry = {
                {'+', '-', '*'},
                {'+', '*', '-'},
                {'-', '+', '*'},
                {'-', '*', '+'},
                {'*', '-', '+'},
                {'*', '+', '-'},
        };
        for(char [] item : signAry){
            stringResult = expression;

            for(char item_2: item){
                System.out.println("### item_2: " +item_2);
                System.out.println("### stringResult: " +stringResult);
                stringResult = getExpression(stringResult, item_2);


            }
            answer = Math.max(answer, Long.parseLong(stringResult));
        }

        return answer;
    }

    private String getExpression(String expression, char sign){
        System.out.println("### expression: " +expression);
        System.out.println("### sign: " +sign);

        String frontNum = "";
        int frontNumSign = 0;
        String backNum = "";
        int backNumSign = 0;
        int expressionLength = expression.length();
        String result = "";
        for(int i=0; i<expressionLength; i++){
            if(expression.charAt(i) == sign){
                for(int j=i-1; j>=0; j--){
                    if(!Character.isDigit(expression.charAt(j)) || j==0){
                        System.out.println("### expression.charAt(i): " + expression.charAt(j));
                        frontNumSign = j == 0 ? j-1 : j;
                        frontNum = expression.substring(frontNumSign+1, i);
                        break;
                    }
                }
                for(int j=i+1; j<expression.length(); j++){
                    if(!Character.isDigit(expression.charAt(j)) || j == expression.length()-1){

                        backNumSign = j == expression.length()-1 ? j+1 : j;
                        backNum = expression.substring(i+1, backNumSign);
                        break;
                    }
                }
                System.out.println("### frontNum: " + frontNum);
                System.out.println("### backNum: " + backNum);
                expression = expression.substring(0,frontNumSign+1) + operating(frontNum, backNum, sign) + expression.substring(backNumSign);
                break;
            }
            if(i == expressionLength-1)
                return expression;
        }
        expression = getExpression(expression, sign);
        return expression;
    }
    private int operating (String num1, String num2, char sign){
        switch (sign){
            case '+':
                return Integer.parseInt(num1) + Integer.parseInt(num2);
            case '-':
                return Integer.parseInt(num1) - Integer.parseInt(num2);
            case '*':
                return Integer.parseInt(num1) * Integer.parseInt(num2);
        }
        return 0;
    }
}
