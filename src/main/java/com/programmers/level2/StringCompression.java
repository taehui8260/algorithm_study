package com.programmers.level2;

import java.util.LinkedList;
import java.util.List;

/**
 * 문자열 압축
 *
 * 약수로 짜른다.
 */
public class StringCompression{
    public int solution(String s) {
        int answer = 0;
        String resultString = "";
        List<Integer> divisors = findDivisors(s.length());
        for(Integer divisor: divisors){
            int index = 0;
            for(int i=0; i<s.length()-divisor;){
                if(s.substring(i, i+divisor).equals(s.substring(i+divisor, i+divisor+divisor))){

                }
                i += divisor;
            }
        }
        return answer;
    }
    private List<Integer> findDivisors(int n){
        List<Integer> result = new LinkedList<>();
        for(int i=2; i<n; i++){
            if(n%2 ==0){
                result.add(i);
            }
        }
        return result;
    }
}
