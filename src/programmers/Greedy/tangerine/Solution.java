/**
 * 프로그래머스, Lv 2, 귤고르기
 * https://school.programmers.co.kr/learn/courses/30/lessons/138476
 */
package src.programmers.Greedy.tangerine;

import java.util.*;

public class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int tan: tangerine){
            map.put(tan, map.getOrDefault(tan, 0)+1);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(((o1, o2) -> map.get(o2).compareTo(map.get(o1)))); // 내림차순 정렬

        for(int key: keySet){
            answer++;
            k -= map.get(key);
            if(k <= 0){
                break;
            }
        }

        return answer;
    }
    public static void main(String[] args){
        src.programmers.Greedy.tangerine.Solution s = new src.programmers.Greedy.tangerine.Solution();
        int result = s.solution(6, new int[] {1, 3, 2, 5, 4, 5, 2, 3});
        System.out.println(result);
    }
}
