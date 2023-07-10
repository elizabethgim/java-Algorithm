package baekjoon.마인크래프트_18111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minTime = 2*500*500;
        int height = 0;

        int time = 0;

        for(int h = 0; h <= 256; h++){
            int build = 0;
            int remove = 0;
            for(int i=0;i<N;i++){
                for(int j = 0;j<M;j++){
                    if(h < board[i][j]){
                        remove += board[i][j] - h;
                    } else if(h > board[i][j]){
                        build += h - board[i][j];
                    }
                }
            }

            if(remove+B >= build){
                time = remove * 2 + build;
                if(minTime >= time){
                    minTime = time;
                    height = h;
                }
            }


        }
        System.out.println(minTime+" "+height);

    }
}


//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++) {
//                System.out.print(board[i][j]+" ");
//            }System.out.println();
//        }

//        int time = 2*N*M;
//        int totalTime = 0;
//        int mid = (maxHeight+maxHeight) / 2;
//        int inventory = B;
//
//        while(maxHeight < maxHeight){
//            mid = (maxHeight+maxHeight) / 2 + 1;
//
//            totalTime = 0;
//            inventory = B;
//            boolean able = true;
//
//            for(int i=0;i<N;i++){
//                for(int j=0;j<M;j++) {
//                    if(mid == board[i][j]){
//                    }
//                    else if(mid - board[i][j] < 0){ // 비우기
//                        totalTime += Math.abs(mid - board[i][j]) * 2;
//                    } else { // 채우기
//                        if(inventory < (mid - board[i][j])){
//                            able = false;
//                            break;
//                        }
//                        totalTime += (mid - board[i][j]) * 1;
//                    }
//                }
//            }
//            System.out.println(mid+": "+totalTime);
//
//            if(totalTime >= time || !able){
//                maxHeight++;
//            } else{
//                maxHeight--;
//            }
//
//        }
//        System.out.println(totalTime+" "+mid);

//        int[][] dp = new int[N][M];
//        int minHeight = 256;
//        int maxHeight = 0;
//
//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                if(board[i][j] > maxHeight){
//                    maxHeight = board[i][j];
//                }
//                if(board[i][j] < minHeight){
//                    minHeight = board[i][j];
//                }
//            }
//        }
//
//        System.out.println(minHeight+" "+maxHeight);
//
