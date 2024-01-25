package com.lth.algorithm.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class MenuRenewal {
    public static void main(String[] args) {

    }
    //모든 요리에 대해 course로 받은 숫자에 대해 2이상의 부분 집합을 만든 후 중복이 있을 경우 value 1 하기
    //해당 내용중 value가 2 이상인 것들을 사전 오름차순으로 정렬하여 result
    static public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> corseList = new ArrayList<>();
        Map<String, Integer> menuCntDic = new HashMap<>();
        for(int courseSize : course){
            for(String order: orders){
                for(int i=0; i<=order.length()-courseSize; i++){
                    menuCntDic.merge(order.substring(i, courseSize), 1, Integer::sum);
                }
            }
        }
        for(String key:menuCntDic.keySet()){
            if(menuCntDic.get(key) >=2){
                corseList.add(key);
            }
        }
        System.out.println(corseList);
        String temp = "";

        for(int i=1; i<)
        return answer;
    }
}
