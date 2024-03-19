package programmers.level2;

import java.util.LinkedList;
import java.util.List;

public class Cache {
    public static void main(String[] args) {
        solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"});
    }
    static public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new LinkedList<>();
        for (String city : cities) {
            answer += cacheHitDetect(cache, city.toUpperCase());
            inputCache(cache, cacheSize, city.toUpperCase());
            System.out.println(cache);
        }
        return answer;
    }
    static int cacheHitDetect(List<String> cache, String city){
        int result = 5;
        for (String s : cache) {
            if (s.equals(city)) {
                result = 1;
                break;
            }
        }
        return result;
    }

    static void inputCache(List<String> cache, int cacheSize, String city){
        cache.add(0, city);

        for (int i = 1; i < cache.size(); i++) {
            if (cache.get(i).equals(city)) {
                cache.remove(i);
                break;
            }
        }
        if(cache.size()>cacheSize){
            cache.remove(cacheSize);
        }
    }
}
