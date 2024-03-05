package com.lth.algorithm.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class MenuRenewal {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
    }

    //주문 메뉴 오름차순 정렬
    //DFS를 이용 모든 코스 크기에 따른 모든 경우의 수 map 할당 최대 값 저장
    //최대값에 해당하는 코드를 answer에 추가
    //answer 사전순으로 정렬
    static public String[] solution(String[] orders, int[] course) {
        List<String> corseList = new ArrayList<>();
        Map<String, Integer> menuCntDic = new HashMap<>();
        int courseForMaxSize = 0;

        //주문 메뉴 오름차순 정렬

        for(int i=0; i<orders.length; i++){
            char[] charArray = orders[i].toCharArray();
            System.out.println(charArray);
            Arrays.sort(charArray);
            orders[i] =  new String(charArray);

        }

        //주문 별 코스 사이즈에 해당하는 모든 조합 구하기
        for (int courseSize : course) {
            for (String order : orders) {
                DFSCourse(0, order, menuCntDic,"", courseSize);
            }
        }

        //코스 사이즈 별 최대 개수 구하기
        for (int courseSize : course) {
            courseForMaxSize = 0;
              for(String key: menuCntDic.keySet()){
                  if(key.length() == courseSize){
                      courseForMaxSize = courseForMaxSize > menuCntDic.get(key) ? courseForMaxSize : menuCntDic.get(key);
                  }
              }
            for(String key: menuCntDic.keySet()){
                if(key.length() == courseSize && courseForMaxSize >1 &&menuCntDic.get(key) == courseForMaxSize){
                    corseList.add(key);
                }
            }
        }
        corseList.sort(String::compareTo);

        //System.out.println(menuCntDic);
        String temp = "";

        return corseList.toArray(new String[0]);
    }

    static void DFSCourse(int startIndex, String order, Map<String, Integer> menuCntDic, String course, int courseSize) {
        if (!"".equals(course) && course.length() == courseSize) {
            menuCntDic.merge(course, 1, Integer::sum);
        }
        for (int i = startIndex; i < order.length(); i++) {
            DFSCourse(i+1, order, menuCntDic, course + order.charAt(i), courseSize );
        }
    }
}
