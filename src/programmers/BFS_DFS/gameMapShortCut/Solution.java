package src.programmers.BFS_DFS.gameMapShortCut;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static class position{
        int x, y;
        public position(int x, int y){
            this.x =x;
            this.y = y;
        }
    }

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int solution(int[][] maps){
        int h = maps.length;
        int w = maps[0].length;

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {0, 0});

        boolean[][] visited = new boolean[h][w];
        visited[0][0] = true;


        while (!que.isEmpty()){
            int[] q = que.poll();
            int x = q[0];
            int y = q[1];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if( 0 <= nx && nx < h && 0 <= ny && ny < w){
                    if(!visited[nx][ny] && maps[nx][ny] > 0){
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[x][y] + 1;
                        que.add(new int[] {nx, ny});
                    }
                }
            }
        }
//        return maps[h-1][w-1] == 1 ? -1 : maps[h-1][w-1];
        if(maps[h-1][w-1]== 1){
            return -1;
        }
        return maps[h-1][w-1];
    }

}
