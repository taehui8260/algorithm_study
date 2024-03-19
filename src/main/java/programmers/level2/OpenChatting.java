package programmers.level2;

import java.util.*;

public class OpenChatting {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }
    //유저 아이디 별 닉네임 Map에 저장
    //명령어와 아이디를 보고 최종 로그 작성
    static public String[] solution(String[] record) {
        List<String> answerList = new ArrayList<>();
        String[] answer = {};
        Map<String, String> statusMap = new HashMap<>();
        statusMap.put("Enter", "들어왔습니다.");
        statusMap.put("Leave", "나갔습니다.");
        Map<String, String> userData = new HashMap<>();
        String[][] recordData = new String[record.length][3];

        for(int i=0; i<record.length; i++){
            recordData[i] = record[i].split(" ");
            if(recordData[i].length > 2)
                userData.put(recordData[i][1], recordData[i][2]);
        }
        for (String[] recordDatum : recordData) {
            if (statusMap.get(recordDatum[0]) != null || statusMap.get(recordDatum[0]) != null) {
                answerList.add(userData.get(recordDatum[1]) + "님이 " + statusMap.get(recordDatum[0]));
            }
        }
        answer = answerList.toArray(new String[0]);
        return answer;
    }
}
