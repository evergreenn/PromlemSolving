package 이코테.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 볼링공고르기 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static HashSet<Integer> combi_output = new HashSet<>();
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        //11:10 ~ 11:39
        //조합 DFS를 이용한 백트래킹
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.valueOf(input[0]);
        visited = new boolean[N];
        Arrays.fill(visited, false);
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        combi(0, N, 2);
        System.out.println(cnt);

    }
    public static void combi(int start, int n, int r) { //n개중에 r 개를 고르는 경우
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {//뽑힌것들 인덱스 추출(visited) 방문한것이 뽑힌것으로 치므로.
                    combi_output.add(arr[i]); //뽑힌 볼링번호의 무게값(arr[ 볼링번호 ] 이므로) 를 삽입.
                }
            }

            if (combi_output.size() == 2) {
                cnt++;
            }
            combi_output.clear();
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i]=true;
            combi(i + 1, n, r - 1);
            visited[i]=false;
        }

    }
}
/*
5 3
1 3 2 3 2
 */
/*
8 5
1 5 4 3 2 4 5 2
 */
