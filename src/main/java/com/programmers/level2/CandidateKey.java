package com.programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

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

        for(int i=1; i<=columnSize; i++){
            Set<Integer> columnSet = new HashSet<>();

            dfs(relation, except, 0, 1, i, columnSet, new ArrayList<>(), answer);
            for(Integer item: columnSet){
                except[item] = true;
            }
        }
        return answer[0];
    }
    private void dfs(String[][] relation, boolean[] except, int start, int curSize , int maxSize, Set<Integer> columnSet, List<Integer> indexList, int[] answer){
        if(start >= relation[0].length){return;}
        if(!except[start]){
            if(curSize == maxSize){
                indexList.add(start);
                Set<String> key = new HashSet<>();
                for(int i=0; i<relation.length; i++){
                    List<String> candidateKey = new ArrayList<>();
                    for(Integer index: indexList) {
                        candidateKey.add(relation[i][index]);
                    }
                    Collections.sort(candidateKey);
                    key.add(candidateKey.stream().collect(Collectors.joining(", ")));
                }
                if(key.size() == relation.length){
                    System.out.println(key);
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
