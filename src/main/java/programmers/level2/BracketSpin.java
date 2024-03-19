package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class BracketSpin {
    public static void main(String[] args) {
        System.out.print(solution("{({)}}"));
    }
    static public int solution(String s) {
        int answer = 0;
        int maxSpinCnt = s.length();
        Character[] bracketArray = new Character[maxSpinCnt];
        for(int i=0; i<maxSpinCnt; i++){
            bracketArray[i] = s.charAt(i);
        }
        for(int i=0; i<maxSpinCnt; i++){
            if(i!=0)
                spin(bracketArray);
            if(checkBracket(bracketArray)){
                answer++;
            }
        }
        return answer;
    }
    static void spin(Character [] bracketArray){
        Character temp = bracketArray[0];
        for(int i=1; i<bracketArray.length; i++){
            bracketArray[i-1] = bracketArray[i];
        }
        bracketArray[bracketArray.length-1] = temp;
    }
    static boolean checkBracket(Character [] bracketArray){
        boolean rightFlg = true;
        int smallBracketCnt = 0;
        int middleBracketCnt = 0;
        int bigBracketCnt = 0;
        for(int i=0; i<bracketArray.length; i++){
            Character bracket = bracketArray[i];
            if(bracket == '('){
                smallBracketCnt++;
            } else if(bracket == ')'){
                smallBracketCnt--;
                if(smallBracketCnt < 0){
                    rightFlg = false;
                    break;
                }
                if(bracketArray[i-1] == '{' || bracketArray[i-1] == '['){
                    rightFlg = false;
                    break;
                }
            }else if(bracket == '{'){
                middleBracketCnt++;
            }else if(bracket == '}'){
                middleBracketCnt--;
                if(middleBracketCnt < 0){
                    rightFlg = false;
                    break;
                }
                if(bracketArray[i-1] == '(' || bracketArray[i-1] == '['){
                    rightFlg = false;
                    break;
                }
            }else if(bracket == '['){
                bigBracketCnt++;
            }else if(bracket == ']'){
                bigBracketCnt--;
                if(bigBracketCnt < 0){
                    rightFlg = false;
                    break;
                }
                if(bracketArray[i-1] == '(' || bracketArray[i-1] == '{'){
                    rightFlg = false;
                    break;
                }
            }
        }
        if(smallBracketCnt !=0 || middleBracketCnt !=0 || bigBracketCnt !=0){
            rightFlg = false;
        }
        return rightFlg;
    }
}
