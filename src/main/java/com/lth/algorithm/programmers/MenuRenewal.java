package com.lth.algorithm.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class MenuRenewal {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
    }
    //모든 요리에 대해 course로 받은 숫자에 대해 2이상의 부분 집합을 만든 후 중복이 있을 경우 value 1 하기
    //해당 내용중 value가 2 이상인 것들을 사전 오름차순으로 정렬하여 result
    static public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> corseList = new ArrayList<>();
        Map<String, Integer> menuCntDic = new HashMap<>();

        for(int courseSize : course){
            for(String order: orders){
                DFSCourse(order, 0, courseSize, 0, new boolean[order.length()], menuCntDic);
                System.out.println(menuCntDic);

            }
        }

        //System.out.println(menuCntDic);
        String temp = "";

        return answer;
    }
    static void DFSCourse(String order, int startNum, int courseSize, int nowCourseSize, boolean []checkInputMenu, Map<String, Integer> menuCntDic){
        checkInputMenu[startNum] = true;
        nowCourseSize++;
        StringBuilder temp = new StringBuilder();
        if(courseSize == nowCourseSize) {
            System.out.println("### courseSize : " + courseSize);
            System.out.println("### nowCourseSize : " + nowCourseSize);
            for (int i = 0; i < order.length(); i++) {
                if (checkInputMenu[i]) {
                    temp.append(order.charAt(i));
                }
            }
            System.out.println("### checkInputMenu : " + Arrays.toString(checkInputMenu));

            System.out.println("### temp : " + temp);

            menuCntDic.merge(String.valueOf(temp), 1, Integer::sum);


            return;
        }
        if(++startNum < order.length()) {
            if(nowCourseSize < courseSize)
                DFSCourse(order, startNum, courseSize, nowCourseSize, checkInputMenu, menuCntDic);
            checkInputMenu[startNum] = false;
            if(--nowCourseSize < courseSize)
                DFSCourse(order, startNum, courseSize, nowCourseSize, checkInputMenu, menuCntDic);
            }
        }
    }
