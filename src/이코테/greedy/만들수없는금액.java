package 이코테.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class 만들수없는금액 {
    static int[] arr;
    static Boolean[] visited;
    static int N;
    static int sum=0;
    static HashSet<Integer> set;

    public static void main(String[] args) {
        //12:44 ~ 1: 44 : 1시간 걸림.
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        arr = new int[N];

        visited = new Boolean[N];
        Arrays.fill(visited,false);
        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int input = s.nextInt();
            arr[i]=input;
        }

        for (int i = 1; i <= N; i++) {
            combi(0,N,i);
            System.out.println(set.toString());
        }
        int index=1;
        while (true) {
            if (!set.contains(index)) {
                System.out.println(index);
                break;
            }
            index++;
        }

    }

    public static void combi(int start, int n,int r) {//n개중에 r 을 뽑는 경우
        if (r == 0) {
            //n개중 r 개를 선택완료(visited 배열에 인덱스가 true로 표시함으로써 뽑는 처리)
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    //뽑힌 인덱스 더하기 처리
                    sum += arr[i];
                }
            }
            set.add(sum);
            sum=0;

        }
        for (int i = start; i < n; i++) {
            visited[i]=true;
            combi(i+1,n,r-1);//한개가 뽑혔으므로, 뽑는수 -1을 수행함. 또한 시작점이 뽑힌것이므로 i+1 부터 탐색
            visited[i]=false;
        }
    }
}
/*
5
3 2 1 1 9
 */
