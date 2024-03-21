package com.programmers.level2;

import java.util.LinkedList;
import java.util.List;

public class NewsClearing {
    public static void main(String[] args) {
        System.out.println(solution("aa1+aa2", "AAAA12"));

    }
    static public int solution(String str1, String str2) {
        int answer = 65536;
        List<String> strList = new LinkedList<>();
        List<String> strList2 = new LinkedList<>();
        String temp = "";
        float inspectionCnt = 0;
        float unionCnt = 0;
        for(int i=0; i<str1.length()-1; i++){
            temp = str1.substring(i, i+2).toUpperCase();
            if(checkString(temp))
                strList.add(temp);
        }
        for(int i=0; i<str2.length()-1; i++){
            temp = str2.substring(i, i+2).toUpperCase();
            if(checkString(temp))
                strList2.add(temp);
        }

        //교집합 확인을 위한 Flg 배열

        boolean [] inspectionFlg = new boolean[strList2.size()];

        for(String item: strList){
            for(int i=0; i<strList2.size(); i++){
                if(!inspectionFlg[i]){
                    if(item.equals(strList2.get(i))){
                        inspectionFlg[i] = true;
                        inspectionCnt++;
                        break;
                    }
                }
            }
        }
        unionCnt = strList.size() + strList2.size() - inspectionCnt;
        System.out.println(strList);
        System.out.println(strList2);
        System.out.println("### unionCnt : " + unionCnt);
        System.out.println("### inspectionCnt : " + inspectionCnt);
        System.out.println("### inspectionCnt/unionCnt");
        if(unionCnt != 0){
            answer = (int) ((inspectionCnt/unionCnt) * 65536);
        }
        return answer;
    }
    static boolean checkString(String str){
        return !str.matches(".*[\\s\\d[^a-zA-Z0-9]]+.*");
    }
}
