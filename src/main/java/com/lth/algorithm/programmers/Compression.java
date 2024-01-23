package com.lth.algorithm.programmers;

import java.util.*;

public class Compression {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("TEST")));
    }
    static public int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        int dicNum = 27;
        long dicCnt = 0;
        String temp = "";

        Map<String, Integer> dictionary = new HashMap<>();
        for(int i=1; i < 27; i++){
            dictionary.put(String.valueOf((char) (i+64)), i);
        }
        //System.out.println("### dictionary : " + dictionary);
        //사전에 있는지 확인(시작 인덱스에서 단어 수를 하나씩 늘려가며 확인)
        //사전에 없는 단어가 나오기 전의 단어에 해당하는 사전번호는 answer에 추가하고 없는단어를 사전에 추가
        //이후 인덱스를 하나씩 추가해서 위의 과정을 반복
        for(int i=0; i<msg.length();){
            temp = "";
            for(int j=i; j<msg.length(); j++){
                temp = msg.substring(i, j+1);
                //System.out.println("### j : " + j);
                //System.out.println("### temp : " + temp);
                if(dictionary.get(temp) == null){
                    //System.out.println("### dictionary temp : " + temp);

                    dictionary.put(temp, dicNum++);
                    result.add(dictionary.get(msg.substring(i, j)));
                    i = j;
                    break;
                }
                if(j == msg.length()-1){
                    result.add(dictionary.get(msg.substring(i, j + 1)));
                    i = msg.length();
                    //System.out.println("### i : " + i);
                    break;
                }
            }
        }
        //System.out.println("### dictionary : " + dictionary);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
