package com.programmers.level2;

public class CoupleGame {
    public static void main(String[] args) {
        solution("aaa");
    }
    static public int solution(String s)
    {
        int answer = 0;
        String result = s;
        boolean excapeFlg = false;
        while (!excapeFlg) {
            excapeFlg = true;
            for (int i = 0; i < s.length() - 1; ) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    if (i < s.length() - 2) {
                        s = s.substring(0, i) + s.substring(i + 2);
                    } else {
                        s = s.substring(0, i);
                    }
                    excapeFlg = false;
                } else {
                    i++;
                }
            }
        }
        if(s.isEmpty())
            answer = 1;
        return answer;
    }
}
