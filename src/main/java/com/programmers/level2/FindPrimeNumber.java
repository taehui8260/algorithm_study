package com.programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class FindPrimeNumber {
    public static void main(String[] args) {
        FindPrimeNumber findPrimeNumber = new FindPrimeNumber();
        System.out.println(findPrimeNumber.solution("011"));
    }
    // 모든 경우의 수를 모두 set에 저장 (DFS 알고리즘 이용)
    // 해당 수가 소수인지 판단
    public int solution(String numbers) {
        int answer = 0;
        boolean [] checkAry = new boolean[numbers.length()];
        Set<Integer> numSet = new HashSet<>();
        dfs(numbers, numSet, checkAry, 0, "");
        for(Integer num : numSet){
            if(detectPrimeNumber(num))
                answer++;
        }
        return answer;
    }
    //모든 경우의 수를 구해야 함으로 dfs 사용
    void dfs(String numbers, Set<Integer> numSet, boolean [] checkAry, int index, String sumNum){
        if(!sumNum.isEmpty()){
            numSet.add(Integer.parseInt(sumNum));
        }
        for(int i=0; i<numbers.length(); i++){
            if(!checkAry[i]) {
                checkAry[i] = true;
                dfs(numbers, numSet, checkAry, index, sumNum + numbers.charAt(i));
                checkAry[i] = false;
            }
        }
    }
    boolean detectPrimeNumber(int num){
        if(num <= 1)
            return false;
        for(int i = 2; i*i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
