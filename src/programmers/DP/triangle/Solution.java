/*
* 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43105
* 정수삼각형
*
* */

package programmers.DP.triangle;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];

        for(int i=1 ; i < n;i++){
            for(int j = 0;j <= i;j++){
                // System.out.println(i+" "+j);
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if(j == i){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    int total1 = dp[i-1][j-1] + triangle[i][j];
                    int total2 = dp[i-1][j] + triangle[i][j];
                    // System.out.println(total1+" "+total2);
                    dp[i][j] = Math.max(total1, total2);
                }

                if(answer < dp[i][j]){
                    answer = dp[i][j];
                }
            }
        }

        // for(int i = 0;i < n;i++){
        //     for(int j = 0;j < n;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }



        return answer;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] arr = {{7}, {3, 8}, {8, 1, 0},{2, 7, 4, 4},{4, 5, 2, 6, 5}};
        int result = s.solution(arr);
        System.out.println(result);
    }
}