/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154540
 * 무인도 여행
 * 접근 방법
 * 1. 그래프 탐색 -> DFS/BFS
 * 2. 해당 영역들의 전체 값을 구해야 하므로 DFS
 * 3. 문제 조건 적용
 * 3-1. X인 경우 방문 불가
 * 3-2. 영역들의 값을 오름차순으로 정렬
 */
package programmers.BFS_DFS.ATripToDesertedIsland;

import java.util.*;

class Solution {
    int n, m;
    
    public int dfs(int x, int y, int[][] board, int[][] result, boolean[][] visited){
        int area = 0;
        ArrayList<int[]> stack = new ArrayList<int[]>();
        
        stack.add(new int[]{x, y, board[x][y]});
        visited[x][y] = true;
        
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {-1, 1, 0, 0};
        
        while(!stack.isEmpty()){
            int[] s = stack.remove(stack.size()-1);
            int xx = s[0];
            int yy = s[1];
            int dd = s[2];
            area += board[xx][yy];
            
            for(int i=0;i<4;i++){
                int nx = xx + dx[i];
                int ny = yy + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(!visited[nx][ny] && board[nx][ny] != -1){
                        stack.add(new int[]{nx, ny, dd+board[nx][ny]});
                        visited[nx][ny] = true;
                        result[nx][ny] = dd+board[nx][ny];
                    }
                }
            }    
            
        }
        
        return area;
    }
    
    /*
    dfs로 방문해서 해당 지역들 합을 구함.
    방문 지역들의 합으로 모두 변환
    방문한 지역들을 오름차순으로 정렬
    */
    public int[] solution(String[] maps) {
        ArrayList<Integer> areas = new ArrayList<>();
        
        n = maps.length;
        m = maps[0].length();
        
        // System.out.println(n);
        // System.out.println(m);
        int[][] board = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(maps[i].charAt(j) == 'X'){
                    board[i][j] = -1;
                } else {
                    board[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }
        
        int[][] result = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && board[i][j] != -1){
                    areas.add(dfs(i, j, board, result, visited));
                }
                
            }
        }
        
        int[] answer = new int[areas.size()];

        if(areas.isEmpty()){
            answer = new int[]{-1};
        } else{
            Collections.sort(areas);
        
            for(int i=0;i<areas.size();i++){
                answer[i] = areas.get(i);
            }
        }
        
        return answer;
    }
}