package com.lth.algorithm.programmers.level2;

public class ChangeBinary {
    public static void main(String[] args) {
        solution("110010101001");
    }
    static public int[] solution(String s) {
        int zeroCount = 0;
        int changeCount = 0;
        int[] answer = deleteZero(s, changeCount, zeroCount);
        return answer;
    }
    static private int[] deleteZero(String binary, int changeCount, int zeroCount){
        while(binary.length() > 1){
            for(int i=0; i<binary.length(); i++){
                if(binary.charAt(i) == '0'){
                    zeroCount++;
                }
            }
            binary = binary.replaceAll("0", "");
            binary = Integer.toBinaryString(binary.length());
            System.out.println(binary);
            changeCount++;
        }
        int [] result = {changeCount, zeroCount};
        return result;
    }
}
