package com.lth.algorithm.programmers;

import java.util.HashSet;
import java.util.Set;

public class FindPrimeNumber {
    public static void main(String[] args) {
        FindPrimeNumber findPrimeNumber = new FindPrimeNumber();
        System.out.println(findPrimeNumber.solution("17"));
    }
    // 모든 경우의 수를 모두 set에 저장
    // 해당 수가 소수인지 판단
    public int solution(String numbers) {
        int answer = 0;
        boolean [] checkAry = new boolean[numbers.length()];
        Set<Integer> numSet = new HashSet<>();
        dfs(numbers, numSet, checkAry, 0, "");
        System.out.println(numSet);
        return answer;
    }

    //2577
    //모든 경우의 수를 구해야 함으로 dfs 사용
    void dfs(String numbers, Set<Integer> numSet, boolean [] checkAry, int index, String sumNum){
        if(!sumNum.equals("")){
            numSet.add(Integer.parseInt(sumNum));
        }
        for(int i=0; i<=numbers.length(); i++){
            checkAry[i] = true;
            dfs(numbers, numSet, checkAry, index, sumNum + numbers.charAt(i));
            checkAry[i] = false;
        }
    }
}
