package com.programmers.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 후보키
 */
public class CandidateKey {
    public static void main(String[] args) {
        CandidateKey candidateKey = new CandidateKey();
        System.out.print(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"},
        {
            "600", "apeach", "music", "2"
        }});
    }
    public int solution(String[][] relation) {
        int[] answer = {0};
        int columnSize = relation.length;
        int rowSize = relation[0].length;
        boolean[] except = new boolean[columnSize];
        Set<Integer> columnSet = new HashSet<>();

        for(int i=1; i<=columnSize; i++){
            dfs(relation, except, 0, 1, i, columnSet, new ArrayList<>(), answer);
        }
        return answer[0];
    }
    private void dfs(String[][] relation, boolean[] except, int start, int curSize , int maxSize, Set<Integer> columnSet, List<Integer> indexList, int[] answer){
        if(start >= relation.length){return;}
        if(!except[start]){
            if(curSize == maxSize){
                indexList.add(start);
                Set<String> key = new HashSet<>();
                for(int i=0; i<relation.length; i++){
                    String candidateKey = "";
                    for(Integer index: indexList) {
                        candidateKey += relation[i][index] + " ";
                    }
                    key.add(candidateKey);
                }
                if(key.size() == relation.length){
                    answer[0] += 1;
                    for(Integer index: indexList ){
                        columnSet.add(index);
                    }
                }
                indexList.remove(indexList.size()-1);
            }
            else{
                indexList.add(start);
                dfs(relation, except, start + 1, curSize + 1, maxSize, columnSet, indexList, answer);
                indexList.remove(indexList.size() - 1);
            }
        }
        dfs(relation, except, start + 1, curSize, maxSize, columnSet, indexList, answer);
    }
}
