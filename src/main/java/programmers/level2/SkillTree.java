package programmers.level2;

import java.util.*;

public class SkillTree {
    public static void main(String[] args) {
        System.out.println(solution("CBD" , new String[]{
            "BACDE", "CBADF", "AECB", "BDA"
        }));
    }
    //선행스킬을 map에 순서를 value로 넣는다.
    //스킬트리를 보고 해당 선행스킬에 해당하는 스킬들을 배열에 넣는다.
    //배열을 순회하면서 map에 할당된 순서를 비교해 순서가 맞는 경우를 찾는다.
    static public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> skill_order = new HashMap<>();
        for(int i=0; i<skill.length(); i++){
            skill_order.put(skill.charAt(i), i);
        }

        for(String skill_tree: skill_trees){
            List<Character> skillList = new ArrayList<>();
            for(int i=0; i<skill_tree.length(); i++){
                if(skill_order.get(skill_tree.charAt(i)) != null){
                    skillList.add(skill_tree.charAt(i));
                }
            }
            if(checkSkillTree(skillList, skill_order)){
                answer++;
            }
        }
        return answer;
    }
    //선행스킬을 지켰는지 판단하는 함수
    static boolean checkSkillTree(List<Character> skillList, Map<Character, Integer> skill_order){
        for(int i=0; i<skillList.size(); i++){
            if(i != skill_order.get(skillList.get(i))) {
                return false;
            }
        }
        return true;
    }
}
