package src.baekjoon.Graph.bj2638;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static List<Integer> cheese = new ArrayList<>();
    static int time = 0;
    static int cheeseCount = 0;


    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        visited[x][y] = true;
        map[x][y] = 2;

        while(!queue.isEmpty()){
            int[] cheese = queue.poll();
            x = cheese[0];
            y = cheese[1];

            for(int i = 0; i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]){
                    if(map[nx][ny] == 0 || map[nx][ny] == 2){
                        visited[nx][ny] = true;
                        map[nx][ny] = 2;
                        queue.add(new int[] {nx, ny});
                    }
                }

            }

        }

        // 치즈 녹이기
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 1){
                    int cnt = 0;

                    for(int k=0;k<4;k++){
                        int ni = i + dx[k];
                        int nj = j + dy[k];

                        if(ni>=0 && ni<N && nj>=0 && nj<M && map[ni][nj] == 2){
                            cnt++;
                        }
                    }

                    if(cnt >= 2){
                        map[i][j] = 0;
                        cheeseCount--;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0;i < N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    cheeseCount++;
                }
            }
        }

        while(cheeseCount > 0){
            visited = new boolean[N][M];
            time++;
            bfs(0, 0);
        }

        System.out.println(time);
    }
}
