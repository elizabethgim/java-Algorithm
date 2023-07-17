package baekjoon.bj26069;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        N = Integer.parseInt(br.readLine());
        Set<String> dancePeople = new HashSet<>();

        for(int i = 0;i < N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String person1 = st.nextToken();
            String person2 = st.nextToken();

            if(dancePeople.contains(person1) || dancePeople.contains(person2)){
                dancePeople.add(person1);
                dancePeople.add(person2);
            }

            if(person1.equals("ChongChong") || person2.equals("ChongChong")){
                dancePeople.add(person1);
                dancePeople.add(person2);
            }
        }

        System.out.println(dancePeople.size());
    }
}

/*
12
bnb2011 chansol
chansol chogahui05
chogahui05 jthis
jthis ChongChong
jthis jyheo98
jyheo98 lms0806
lms0806 pichulia
pichulia pjshwa
pjshwa r4pidstart
r4pidstart swoon
swoon tony9402
tony9402 bnb2011
 */