package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class VowelDictionary {

    public static void main(String[] args) {
        System.out.println(solution("AAAAO"));
    }

    //모음 A E I O U 로 만 들 수 있는 5개의 모음 이하의 단어 사전
    //거꾸로 생각해보면 된다. A A A A 0  A4개를 앞에두고 로 만들 수 있는 단어는 총 5 + 1개
    //A A A 0 0 A3개를 앞에두고 만들 수 있는 단어는 5 * (5 + 1) + 1개
    //A A 0 0 0 A2개를 앞에두고 만둘 수 있는 단어는 5 * (5*6 + 1) + 1
    //이러한 규칙을 이용해 원하는 단어의 사전 번호를 구하는 방법
    //AIAAA 이면
    static public int solution(String word) {
        Map<Character, Integer> vowelNum = new HashMap<>();
        vowelNum.put('A', 0);
        vowelNum.put('E', 1);
        vowelNum.put('I', 2);
        vowelNum.put('O', 3);
        vowelNum.put('U', 4);

        int maxIndex = 5;
        int answer = 0;
        for(int i=0; i < word.length(); i++){
            answer += getDicNum(vowelNum.get(word.charAt(i)), maxIndex--);
        }
        return answer + word.length();
    }

    static int getDicNum(Integer vowelNum, Integer repeatCnt){
        int num = 1;
        for(int i=1; i<repeatCnt; i++){
            num = 5*(num) + 1;
        }
        //System.out.println("### num :" + num);
        //System.out.println("### repeatCnt :" + repeatCnt);
        //System.out.println("### vowelNum :" + vowelNum);
        //System.out.println("### vowelNum.get(c)*num :" + vowelNum*num);
        return vowelNum*num;
    }
}
