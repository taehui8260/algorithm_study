package com.programmers.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ElectronicNetwork {
    public static void main(String[] args) {
        ElectronicNetwork electronicNetwork = new ElectronicNetwork();
        System.out.println(electronicNetwork.solution(4, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    }
    static int cnt1 = 0;
    static int cnt2 = 0;

    //전력 망은 트리형태 이다.
    //각 노드에 연결 되어있는 모든 노드를 저장한다.
    //모든 노드의 연결점에서 둘의 연결 제외 모든 연결을 찾아 그 차가 가장 작은 값을 구한다.
    public int solution(int n, int[][] wires) {
        int answer = 100;
        Map<Integer, Set<Integer>> connectNodeSet = new HashMap<>();

        for(int [] wire : wires){
            Set<Integer> wireSet0 = new HashSet<>();
            wireSet0.add(wire[1]);
            connectNodeSet.merge(wire[0], wireSet0, (integers, integers2) -> {
                        integers.addAll(integers2);
                        return integers;
                    }
            );
            Set<Integer> wireSet1 = new HashSet<>();
            wireSet1.add(wire[0]);
            connectNodeSet.merge(wire[1], wireSet1, (integers, integers2) -> {
                        integers.addAll(integers2);
                        return integers;
                    }
            );
        }
        for(int [] wire : wires){
            answer= Math.min(answer, Math.abs(getConnectNodeCnt(connectNodeSet, wire[0], wire[1]) - Math.abs(getConnectNodeCnt(connectNodeSet, wire[1], wire[0]))));
        }
        return answer;
    }
    public int getConnectNodeCnt(Map<Integer, Set<Integer>> connectNodeSet, int curNode, int disConnectNode){
        int cnt = 0;
        for(Integer node : connectNodeSet.get(curNode)){
            if(node != disConnectNode){
                cnt += getConnectNodeCnt(connectNodeSet, node, curNode) + 1;
            }
        }
        return cnt;
    }
}
