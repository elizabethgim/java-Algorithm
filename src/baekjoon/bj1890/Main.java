package baekjoon.bj1890;
/*
1 0 1 0
0 0 0 0
1 0 0 0
0 0 0 0

1 0 1 0
0 0 0 0
1 0 0 0
0 0 1 0

1 0 1 0
0 0 0 0
1 1 0 0
1 0 1 0

1 0 1 0
0 0 0 0
1 1 0 1
1 0 1 0

1 0 1 0
0 0 0 0
1 1 0 1
1 0 1 1

1 0 1 0
0 0 0 0
1 1 0 1
1 0 1 2

1 0 1 0
0 0 0 0
1 1 0 1
1 0 1 3


4
1 1 1 3
1 0 0 0
1 1 0 0
0 2 0 0
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = 1;
        for(int i = 0; i< N; i++){
            for(int j = 0; j< N; j++){
                int move = board[i][j];
                if(i== N -1 && j == N -1){
                    break;
                }
                if(move > 0){
                    if(i + move < N){
                        dp[i + move][j] += dp[i][j];
                    }
                    if(j + move < N){
                        dp[i][j + move] += dp[i][j]; // 왜 ++dp[i][j+move]하면 틀릴까?
                    }
//                    System.out.println(i+" "+j);
//                    for(int n = 0; n< N; n++) {
//                        for (int m = 0; m < N; m++) {
//                            System.out.print(dp[n][m]+" ");
//                        }System.out.println();
//                    }
                }
            }
        }
        System.out.print(dp[N -1][N -1]);
    }
}
