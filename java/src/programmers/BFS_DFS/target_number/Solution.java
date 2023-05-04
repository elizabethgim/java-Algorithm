/*
* 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java
* 타겟 넘버
* - 재귀를 활용
* */
package programmers.BFS_DFS.target_number;

public class Solution {
    public static int len;
    public static int answer;

    public static void dfs(int[]numbers, int n, int total, int target){
        if(n == len){
            if(total == target){
                answer++;
            }
            return;
        }
        dfs(numbers, n+1, total-numbers[n], target);
        dfs(numbers, n+1, total+numbers[n], target);
    }

    public int solution(int[] numbers, int target) {
        answer = 0;
        len = numbers.length;
        System.out.println(len);
        dfs(numbers, 0, 0, target);
        return answer;
    }

    public static void main(String[] args){
        int[] arr = {1, 1, 1, 1, 1};
        int target = 3;
        int expected = 5;
        Solution s = new Solution();
        int a = s.solution(arr, target);
        if(a == expected){
            System.out.println("PASS");
        }else{
            System.out.println("X");
        }
    }
}
