package com.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DeliveryBox {
    public static void main(String[] args) {
        DeliveryBox deliveryBox = new DeliveryBox();
        System.out.print(deliveryBox.solution(new int[]{4, 3, 1, 2, 5}));
    }
    //트럭(truckQueue) 트럭에 넣어야 하는 순서 [4, 3, 1, 2, 5]
    //주 레일(mainBeltQueue) 컨테이너 벨트에 올라와 있는 택배 [1, 2, 3, 4, 5]
    //보조 레일(subBeltStack) 트럭에 넣기 위한 출구가 막힌 임시 레일(후입선출)
    //트럭에 가장 먼저 넣어야 하는 택배가 4임으로 보조레일에 [3, 2, 1] 넣고 4를 트럭에 싣는다. 이런식으로 더이상 트럭에 싣지 못할때 까지 반복한다.
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> truckStack = new LinkedList<>();
        Queue<Integer> mainBeltStack = new LinkedList<>();
        Stack<Integer> subBeltStack = new Stack<>();

        int index = 1;

        for(int item: order){
            truckStack.add(item);
            mainBeltStack.add(index++);
        }

        while(!truckStack.isEmpty()){
            if(!mainBeltStack.isEmpty() && mainBeltStack.peek().equals(truckStack.peek())){
                mainBeltStack.poll();
                truckStack.poll();
                answer++;
            } else if (!subBeltStack.isEmpty() && subBeltStack.peek().equals(truckStack.peek())){
                subBeltStack.pop();
                truckStack.poll();
                answer++;
            } else{
                if(!mainBeltStack.isEmpty())
                    subBeltStack.add(mainBeltStack.poll());
                else{
                    break;
                }
            }

        }
        return answer;
    }
}
