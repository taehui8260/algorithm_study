package com.programmers.level2;

import java.util.HashSet;
import java.util.Set;

/**
 * 후보키
 */
public class CandidateKey {
    public int solution(String[][] relation) {
        int answer = 0;
        int columnSize = relation.length;
        int rowSize = relation[0].length;
        int startNum;
        boolean[] except = new boolean[columnSize + 1];
        for(int i=1; i<=columnSize; i++){
            startNum = 0;
            Set<Integer> columnSet = new HashSet<>();
            while(true){

            }

        }
        return answer;
    }
    private void dfs(String[][] relation, boolean[] except, boolean[] visited, int start, int curSize ,int maxSize, Set<Integer> columnSet){
        if(start < except.length){
            if(!except[start]){
                visited[start] = true;
                if(curSize == maxSize){
                    Set<String> rowSet = new HashSet<>();
                    for(int j=0; j<relation.length; j++){
                        String row = "";
                        for(int x=0; x<relation[j].length; x++){
                            if(visited[x]) {
                                row = row + " " + relation[j][x];
                            }
                        }
                        rowSet.add(row);
                        if(rowSet.size() != j+1){
                            visited[start] = false;
                            dfs(relation, except, visited, start + 1, curSize, maxSize, columnSet);
                        }
                    }
                    if(rowSet.size() == relation[0].length){
                        for(int j=0; j<visited.length; j++){
                            if(visited[j]){
                                columnSet.add(j);
                            }
                        }
                    }
                    visited[start] = false;
                    dfs(relation, except, visited, start + 1, curSize, maxSize, columnSet);

                } else{
                    dfs(relation, except, visited, start + 1, curSize + 1, maxSize, columnSet);
                }

                visited[start] = false;
                dfs(relation, except, visited, start + 1, curSize, maxSize, columnSet);
            }
        }
    }
}
