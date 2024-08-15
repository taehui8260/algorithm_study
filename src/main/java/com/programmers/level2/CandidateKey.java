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
        int columnSize = relation[0].length;
        List<Set<Integer>> candidateKeys = new ArrayList<>();

        // 모든 조합에 대해 검사
        for (int i = 1; i < (1 << columnSize); i++) {
            Set<Integer> keySet = new HashSet<>();
            for (int j = 0; j < columnSize; j++) {
                if ((i & (1 << j)) != 0) {
                    keySet.add(j);
                }
            }

            // 최소성 체크
            if (!isMinimal(keySet, candidateKeys)) continue;

            // 유일성 체크
            if (isUnique(relation, keySet)) {
                candidateKeys.add(keySet);
            }
        }

        return candidateKeys.size();
    }

    private boolean isMinimal(Set<Integer> keySet, List<Set<Integer>> candidateKeys) {
        for (Set<Integer> candidateKey : candidateKeys) {
            if (keySet.containsAll(candidateKey)) {
                return false;
            }
        }
        return true;
    }

    private boolean isUnique(String[][] relation, Set<Integer> keySet) {
        Set<String> seen = new HashSet<>();
        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for (int key : keySet) {
                sb.append(row[key]).append("|");
            }
            if (!seen.add(sb.toString())) {
                return false;
            }
        }
        return true;
    }
}
