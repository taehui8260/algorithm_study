package com.lth.algorithm.programmers;

public class NRadixNotation {
    public static void main(String[] args) {
        System.out.println(solution(16	,16	,2	,1));
    }
    //진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
    //두자리 이상일 시 한자리 씩 말해야 한다.
    //게임 족보는 0 ~ 까지 10진수를 n진수로 변환한 값의 합으로 이루어진 String 이다.
    //게임 족보 중 주인공이 대답해야 하는 값(m의 배수 + p-1)을 answer에 넣는다.
    //필요한 게임 족보의 자리수 = t * m;

    static public String solution(int n, int t, int m, int p) {
        StringBuilder answer =  new StringBuilder();
        StringBuilder gamerPedigree = new StringBuilder();
        gamerPedigree.append("0");
        int index = 0;
        while(gamerPedigree.length() < t * m){
            gamerPedigree.append(changeNRadixNotation(index, n));
            index++;
        }
        for(int i=0; i<gamerPedigree.length(); i++){
            if(i%m == p-1){
                answer.append(gamerPedigree.charAt(i));
            }
            if(answer.length() == t)
                break;
        }
        //System.out.println("### gamerPedigree : " + gamerPedigree);
        return String.valueOf(answer);
    }

    static String changeNRadixNotation(int decimal, int n){
        StringBuilder nRadixNotation = new StringBuilder();
        String remainder = "";
        while (!(decimal == 0)){
            if(decimal % n > 9){
                //ASCII 코드를 이용한 10 이상의 숫자를 A, B ... Z 로 변경
                remainder = String.valueOf((char)(55 + decimal % n));
            } else {
                remainder = String.valueOf(decimal % n);
            }
            decimal = decimal/n;
            nRadixNotation.insert(0, remainder);
        }
        return String.valueOf(nRadixNotation);
    }

}
