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
        System.out.println(maliciousUserMap);
        return answer;
    }

    private boolean findMakingUserId(String maskingId, String userId){
        if(maskingId.length() != userId.length())
            return false;

        List<Integer> starIndex = new ArrayList<>();
        for(int i=0; i<maskingId.length(); i++){
            if(maskingId.charAt(i) == '*'){
                starIndex.add(i);
            }
        }
        for(int index : starIndex){
            if(index < maskingId.length())
                userId = userId.substring(0,index) + "*" + userId.substring(index+1);
            else{
                userId = userId.substring(0,index) + "*";
            }
        }

        return maskingId.equals(userId);
    }

    private backTracking(List<List<Integer>> maliciousUserMap, )
}
