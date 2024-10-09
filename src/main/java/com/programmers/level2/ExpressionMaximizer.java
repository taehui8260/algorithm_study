package com.programmers.level2;


import java.util.*;

/**
 * 수식 최대화
 *
 * 각 숫자와 수식을 list 형태로 변환 후 수식의 순서에 따라 값을 구해 최대값을 구한다.
 */
public class ExpressionMaximizer {
    public static void main(String[] args) {
        ExpressionMaximizer expressionMaximizer = new ExpressionMaximizer();
        System.out.println(expressionMaximizer.solution("100-200*300-500+20"));
    }

    public long solution(String expression) {
        long answer = 0;
        List<Character> operation = new LinkedList<>();
        List<String> expressionList = new LinkedList<>();
        List<List<Character>> operationList = new ArrayList<>();
        int startIndex = 0;
        //list로 변환
        for(int i=0; i<expression.length(); i++){
            char curChart = expression.charAt(i);
            if(curChart == '-' || curChart == '*' || curChart == '+'){
                if(!operation.contains(curChart)){
                    operation.add(curChart);
                }
                expressionList.add(expression.substring(startIndex, i));
                expressionList.add(expression.substring(i, i+1));
                startIndex = i + 1;
            }
            if(i == expression.length()-1){
                expressionList.add(expression.substring(startIndex));
            }
        }
        setOperation(operation, new LinkedList<>(), new boolean[operation.size()], operation.size(), operationList);
        for(List<Character> item: operationList){
            List<String> vueExpressionList = new ArrayList<>();
            for(String item_2: expressionList){
                vueExpressionList.add(item_2);
            }
            long value = 0;
            for(char item_2 : item) {
                for (int i = 0; i <vueExpressionList.size();) {
                    String cur = vueExpressionList.get(i);
                    if(cur.equals(String.valueOf(item_2))){
                        value = operating(vueExpressionList.get(i-1), vueExpressionList.get(i+1), cur);
                        vueExpressionList.remove(i+1);
                        vueExpressionList.remove(i);
                        vueExpressionList.set(i-1, String.valueOf(value));
                        continue;
                    }
                    i++;
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(vueExpressionList.get(0))));
        }
        return answer;
    }

    private void setOperation(List<Character> operation, List<Character> sum, boolean [] visited, int size, List<List<Character>> operationList){
        if(size == sum.size()){
            List<Character> curOperation = new LinkedList<>();
            for(Character item: sum){
                curOperation.add(item);
            }
            operationList.add(curOperation);
            return;
        }
        for(int i=0; i<size; i++){
            if(!visited[i]){
                sum.add(operation.get(i));
                visited[i] = true;
                setOperation(operation, sum, visited, size, operationList);
                visited[i] = false;
                sum.remove(sum.size()-1);
            }
        }
    }
    private long operating (String num1, String num2, String sign){
        switch (sign){
            case "+":
                return Long.parseLong(num1) + Long.parseLong(num2);
            case "-":
                return Long.parseLong(num1) - Long.parseLong(num2);
            case "*":
                return Long.parseLong(num1) * Long.parseLong(num2);
        }
        return 0;
    }
}
