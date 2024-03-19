package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class ChangeNum {
    public static void main(String[] args) {
        ChangeNum test = new ChangeNum();
        System.out.println(test.solution(2,	5,	4));
    }
    //최단경우의 수를 찾는것이기 때문에 bfs 이용
    //x가 y로 되기 위한 방법은 최대 x ~ y까지의 경우가 존재하기 때문에 y-x + 1 개의 중복값 판단을 위한 배열 필요
    //x에 대한 계산 결과와 해당 결과에 도달하기 위한 cost를 담는 Class XValueCost 생성
    //Queue에 XValueCost를 담고 +n, *2, *3의 경우를 실행하면서 bfs 진행한다.
    public int solution(int x, int y, int n) {
        int answer = 0;
        answer = bfs(x, y, n);
        return answer;
    }
    int bfs(int x, int y, int n){
        boolean []checkXValue = new boolean[y-x + 1];
        Queue<XValueCost> queue = new LinkedList<>();
        queue.add(new XValueCost(x, 0));
        checkXValue[0] = true;
        while(!queue.isEmpty()){
            XValueCost xValueCost = queue.poll();
            if(xValueCost.x == y){
                return xValueCost.cost;
            }
            if(xValueCost.x*2 <= y && !checkXValue[xValueCost.x*2 - x]){
                queue.add(new XValueCost(xValueCost.x*2, xValueCost.cost + 1));
                checkXValue[xValueCost.x*2 - x] = true;
            }
            if(xValueCost.x*3 <= y && !checkXValue[xValueCost.x*3 - x]){
                queue.add(new XValueCost(xValueCost.x*3, xValueCost.cost + 1));
                checkXValue[xValueCost.x*3 - x] = true;
            }
            if(xValueCost.x + n <= y && !checkXValue[xValueCost.x + n - x]){
                queue.add(new XValueCost(xValueCost.x + n, xValueCost.cost + 1));
                checkXValue[xValueCost.x + n - x] = true;
            }
        }
        return -1;
    }
    class XValueCost{
        int x;
        int cost;
        XValueCost(int x, int cost){
            this.x = x;
            this.cost = cost;
        }
    }
}
