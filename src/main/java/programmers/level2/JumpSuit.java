package programmers.level2;

public class JumpSuit {
    public static void main(String[] args) {

    }
    public int solution(int n) {
        int ans = 0;
        while(n!=0){
            if(n%2 == 1){
                ans++;
            }
            n = n/2;
        }
        return ans;
    }
}
