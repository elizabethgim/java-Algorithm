/**
 * 문제 링크
 * https://school.programmers.co.kr/learn/courses/30/lessons/148653
 * 
 * 문제의 숨은 조건 찾기가 까다로웠던 문제
 */

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            int d = storey % 10;
            int next = storey / 10 % 10;
            
            if(d < 5){
                answer += d;
            } else if (d > 5){
                answer += 10 - d;
                storey += 10 - d;
            } else {
                if(next >= 5){
                    answer += d;
                    storey += d;
                } else {
                    answer += d;
                }
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}