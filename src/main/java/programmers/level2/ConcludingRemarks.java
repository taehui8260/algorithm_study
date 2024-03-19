package programmers.level2;

public class ConcludingRemarks {
    public static void main(String[] args) {

    }
    static public int[] solution(int n, String[] words) {
        // 1. 끝말잇기 실패할 경우
        // 2. 중복된 단어를 말했을 경우
        int[] answer = {};
        String word = "";
        int outPersonNum = 0;
        int outOrder = 0;
        boolean breakFlg = false;

        for(int i=1; i<words.length; i++){
            word = words[i];
            if(words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)){
                outPersonNum = i % n + 1;
                outOrder = i / n + 1;
                break;
            }
            for(int j = i-1; j >= 0; j--){
                if(word.equals(words[j])){
                    outPersonNum = i % n + 1;
                    outOrder = i / n + 1;
                    breakFlg = true;
                    break;
                }
            }
            if(breakFlg)
                break;
        }
        answer = new int[]{outPersonNum, outOrder};
        return answer;
    }
}
