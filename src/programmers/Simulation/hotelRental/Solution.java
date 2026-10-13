/**
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/155651
 * 
 */

package programmers.Simulation.hotelRental;

import java.util.*;

public class Solution {
    public String addTen(String org){
        String[] time = org.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        
        minute = minute + 10;
        
        if(minute >= 60){
            hour += minute / 60;
            minute = minute % 60;
        }
        
        return String.format("%02d:%02d", hour, minute);
    }
    
    public String[] compareTime(String org1, String org2){
        String[] t1 = org1.split(":");
        String[] t2 = org2.split(":");

        int h1 = Integer.parseInt(t1[0]);
        int m1 = Integer.parseInt(t1[1]);

        int h2 = Integer.parseInt(t2[0]);
        int m2 = Integer.parseInt(t2[1]);

        if (h1 < h2) {
            return new String[]{org1, org2};
        }

        if (h1 == h2) {
            if (m1 <= m2) {
                return new String[]{org1, org2};
            } else {
                return new String[]{org2, org1};
            }
        }
        
        return new String[] {org2, org1};
    }
    
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        ArrayList<String[]> rooms = new ArrayList<>();
        
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        
        for(String[] time: book_time){
            String start = time[0];
            String end = time[1];
            // System.out.println(start);
            // System.out.println(end);
                        
            if(rooms.isEmpty()){
                rooms.add(time);
            } else {
                boolean assigned = false;
                
                for(String[] room: rooms){
                    String r_start = room[0];
                    String r_end = room[1];
                    
                    if(addTen(r_end).compareTo(start) <=0){
                        room[0] = start;
                        room[1] = end;
                        
                        assigned = true;
                        break;
                    }
                    // if(r_start < start){
                    //    if(r_end <= start - 10){
                    //        continue;
                    //    } else {
                    //        room.add(new String[] {start, end});
                    //        assigned = true;
                    //     }
                    // } else {
                    //     if(r_end < end - 10){
                    //         room.add(new String[] {start, end});
                    //         assigned = true;
                    //     } else {
                    //         continue;
                    //     }
                    // }
                }
                
                if(!assigned){
                    rooms.add(new String[] {start, end});
                }
            }
        }
        answer = rooms.size();
        
        return answer;
    }
}