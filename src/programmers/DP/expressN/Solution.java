/*
* 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42895
* N으로 표현
* */
package programmers.DP.expressN;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int N, int number){
        if(number == N){
            return 1;
        }

        int answer = -1;
        Set<Integer>[] setArr = new Set[9];
        int t = N;
        for(int i = 1;i < 9;i++){
            setArr[i] = new HashSet<>();
            setArr[i].add(t);
            t = t * 10 + N;
        }

        for(int i=1;i<9;i++){
            for(int j=1;j < i;j++){
                for(Integer a: setArr[j]){
                    for(Integer b: setArr[i-j]){
                        setArr[i].add(a+b);
                        setArr[i].add(a-b);
                        setArr[i].add(b-a);
                        setArr[i].add(a*b);
                        if(a!=0){
                            setArr[i].add(b/a);
                        }
                        if(b!=0){
                            setArr[i].add(a/b);
                        }
                    }
                }
            }
        }
        for(int i=1;i<9;i++){
            if(setArr[i].contains(number)){
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int result = s.solution(5, 12);
        System.out.println(result);
    }
}
