package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class Sequence {
    public static void main(String[] args) {

    }
    static public int solution(int[] elements) {
        int answer = 0;
        //Queue<Integer> que = new LinkedList<>();
        Map<Integer, Integer> sequenceSum = new HashMap<>();
        /*for(Integer element: elements){
            que.add(element);
        }*/
        int temp = 0;
        for(int i=0; i< elements.length; i++){
            for(int j=1; j<= elements.length; j++){
                int sum = 0;
                for(int z = 0; z<j; z++){
                    sum += elements[z];
                }
                sequenceSum.merge(sum, 1, Integer::sum);

            }
            temp = elements[0];
            for(int z=0; i< elements.length-1; i++){
                elements[z] = elements[z+1];
            }
            elements[elements.length-1] = temp;
        }
        answer = sequenceSum.size();
        return answer;
    }
}
