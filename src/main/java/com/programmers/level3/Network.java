package com.programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 네트워크
 *
 * 1번 노드와 연결되어있는 모든 노드를 구한다(bfs 사용)
 * 체크한 노드는 true 처리
 * 이후 true가 되어 있는 노드를 또 반복
 * 반복 횟수만큼의 네트워크가 존재한다.
 */
public class Network {
    public static void main(String[] args) {
        Network network = new Network();
        System.out.println(network.solution(3,	new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];

        for(int i=0; i<n; i++){
            if(!check[i]){
                Queue<Integer> networkQue = new LinkedList<>();
                answer++;

                check[i] = true;
                networkQue.add(i);
                findConnectNetwork(networkQue, computers, check);
            }
        }
        return answer;
    }

    private void findConnectNetwork(Queue<Integer> networkQue, int[][] computersm, boolean[] check) {
        int node;
        while(networkQue.peek() != null){
            node = networkQue.poll();
            for(int i=0; i<computersm[0].length; i++){
                if(computersm[node][i] != 0 && !check[i]){
                    networkQue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
