package com.programmers.level2;

public class NextNum {
    public static void main(String[] args) {
        solution(78);
    }
    static public int solution(int n) {
        int decimal = 0;
        String binary = "";
        int oneCount = 0;
        int nextNumOneCount = 0;
        binary = Integer.toBinaryString(n);

        oneCount = checkOneCount(binary);


        while (oneCount != nextNumOneCount){
            binary = Integer.toBinaryString(++n);
            nextNumOneCount = checkOneCount(binary);
        }
        return n;
    }
    static public int checkOneCount(String binary){
        int oneCount = 0;
        for(int i=0; i<binary.length(); i++){
            if(binary.charAt(i) == '1'){
                oneCount++;
            }
        }
        return oneCount;
    }
}
