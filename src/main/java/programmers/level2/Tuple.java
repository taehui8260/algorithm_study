package programmers.level2;

import java.util.LinkedHashSet;

public class Tuple {
    public static void main(String[] args) {
        System.out.println(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
    }
    static public int[] solution(String s) {
        //int[][]배열에 크기 순 정렬로 넣는다
        //하나씩 추가
        s = s.replace("{", "");
        s = s.substring(0, s.length()-2);

        String[] temp = s.split("},");
        int[][] num = new int[temp.length][];

        for (String value : temp) {
            num[value.split(",").length - 1] = changeStringAryToIntAry(value.split(","));
        }
        int[] answer = new int[num.length];
        LinkedHashSet<Integer> data = new LinkedHashSet<>();
        for (int i=0; i< num.length; i++) {
            //System.out.println("num.length = " + num.length);
            for (int j=0; j<num[i].length; j++) {
                //System.out.println("num[" + i + "]" + "[" + j + "] = " + num[i][j]);

                data.add(num[i][j]);
            }
        }
        int index = 0;
        for(int item: data){
            answer[index++] = item;
        }
        return answer;
    }
    static int[] changeStringAryToIntAry(String[] ary){
        int[] result = new int[ary.length];
        for(int i=0; i<ary.length; i++){
            //System.out.println(ary[i]);

            result[i] = Integer.parseInt(ary[i]);
        }
        return result;
    }

}
