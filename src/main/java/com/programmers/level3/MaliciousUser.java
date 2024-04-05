package com.programmers.level3;

import java.util.*;

/**
 * 불량 사용자
 *
 * 불량 아이디에 따른 매핑되는 아이디의 index를 불량아이디를 key로 map에 저장한다.
 *
 * 불량 아이디 별 저장 되어 있는 index를 비교해 서로 다른 조합이 되는 개수를 찾는다.
 */
public class MaliciousUser {
    Set<String> resultSet = new HashSet<>();

    public static void main(String[] args) {
        MaliciousUser maliciousUser = new MaliciousUser();

        System.out.println(maliciousUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        List<List<Integer>> maliciousUserMap = new ArrayList<>();
        boolean[] checkUserId = new boolean[user_id.length];
        for(int j=0; j<banned_id.length; j++){
            List<Integer> bannedList = new ArrayList<>();
            for(int i=0; i<user_id.length; i++){
                if(findMakingUserId(banned_id[j], user_id[i])){
                    bannedList.add(i);
                }
            }
            maliciousUserMap.add(j, bannedList);
        }
        backTracking(maliciousUserMap, checkUserId, 0, new ArrayDeque<>());
        return resultSet.size();
    }

    //마스킹 처리된 아이디와 같은 아이디 인댁스 찾기
    private boolean findMakingUserId(String bannedId, String userId){
        if (bannedId.length() != userId.length()) return false;

        for (int i = 0; i < bannedId.length(); i++) {
            if (bannedId.charAt(i) == '*') continue;
            if (bannedId.charAt(i) != userId.charAt(i)) return false;
        }
        return true;
    }

    //마스킹 처리된 아이디와 매핑되어있는 아이디의 조합 확인
    private void backTracking(List<List<Integer>> maliciousUserMap,boolean[] checkUserId, int index, ArrayDeque<Integer> combination){
        if(index == maliciousUserMap.size()){
            List<Integer> result = new ArrayList<>(combination);
            result.sort((o1, o2) -> o1-o2);
            resultSet.add(result.toString());
            return;
        }
        for(int i=0; i<maliciousUserMap.get(index).size(); i++){
            if(!checkUserId[maliciousUserMap.get(index).get(i)]){
                checkUserId[maliciousUserMap.get(index).get(i)] = true;
                combination.push(maliciousUserMap.get(index).get(i));
                backTracking(maliciousUserMap, checkUserId, ++index, combination);
                combination.pop();

                checkUserId[maliciousUserMap.get(--index).get(i)] = false;
                System.out.println();

            }
        }
    }
}
