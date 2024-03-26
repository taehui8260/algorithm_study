package com.programmers.level3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 단어 변환
 *
 * 해당 단어가 없으면 return 0
 *
 * 하나씩 변화하는 단어를 파악해 BFS를 사용해 풀기
 */
public class WorkConverter {
    public static void main(String[] args) {
        WorkConverter workConverter = new WorkConverter();
        System.out.println(workConverter.solution("hit",	"cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean returnFlg = true;
        boolean[] check = new boolean[words.length];
        HashMap<String, Integer> wordValue = new HashMap<>();

        for(String word: words){
            wordValue.put(word, 0);
            if (target.equals(word)) {
                returnFlg = false;
                break;
            }
        }
        if(returnFlg)
            return 0;

        Queue<String> wordQue = new LinkedList<>();

        for(int i=0; i<words.length; i++){
            if(!check[i] && hasSingleCharDifference(begin, words[i])){
                wordQue.add(words[i]);
                wordValue.put(words[i], 1);
                check[i] = true;
            }
        }

        while(wordQue.peek() != null){
            String word = wordQue.poll();
            answer =  wordValue.get(word);
            if(word.equals(target)){
                return answer;
            }
            for(int i=0; i<words.length; i++){
                if(!check[i] && hasSingleCharDifference(word, words[i])){
                    wordQue.add(words[i]);
                    wordValue.put(words[i], answer + 1);
                    check[i] = true;
                }
            }
        }
        return 0;
    }

    boolean hasSingleCharDifference(String word1, String word2){
        int diffrentIndex = 0;
        for(int i=0; i<word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i))
                diffrentIndex++;
            if(diffrentIndex>1)
                return false;
        }
        return true;
    }
}
