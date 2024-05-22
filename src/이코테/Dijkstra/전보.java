package 이코테.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 전보 {
    //풀이 성공 ! , 시간의 개념 -> 가장 큰 최댓값 시간이 걸린다는 발상 이용.
    static int N;
    static int M;
    static int C;
    static PriorityQueue<City> queue = new PriorityQueue<>();

    static int[] dp;
    static ArrayList<ArrayList<City>> list = new ArrayList<>();

    public static void main(String[] args) {
        // 9 : 55 분 시작 10시 39분 구현 종료 44분 걸림.

        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        M = s.nextInt();
        C = s.nextInt();
        dp = new int[N + 1];
        Arrays.fill(dp, (int) 1e9);

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int start = s.nextInt();
            int end = s.nextInt();
            int cost = s.nextInt();
            list.get(start).add(new City(end, cost));
        }
        dp[C] = 0;
        queue.add(new City(C, 0));
        dijkstra();

        long count = Arrays.stream(dp)
                .filter(i -> i != (int) 1e9 && i != 0) //필터 사용법 숙지
                .count(); // 필터를 적용한 후 각 요소의 갯수
        int max = Arrays.stream(dp)
                .filter(i -> i != (int) 1e9 && i != 0)
                .max()
                .getAsInt();

        System.out.println(Arrays.toString(dp));

        System.out.println(count + " " + max);


    }

    public static void dijkstra() {
        while (!queue.isEmpty()) {
            City now = queue.remove();

            int cost = now.cost;
            ;
            int now_index = now.target;
            if (cost > dp[now_index]) {
                continue;
            }

            for (int i = 0; i < list.get(now_index).size(); i++) {

                City adjcent = list.get(now_index).get(i);
                int distance = adjcent.cost + dp[now_index];

                if (dp[adjcent.target] > distance) {
                    dp[adjcent.target] = distance;

                    queue.add(adjcent);
                }
            }
        }
    }
}

class City implements Comparable<City> {
    int target;
    int cost;

    public City(int target, int cost) {
        this.target = target;
        this.cost = cost;
    }

    @Override
    public int compareTo(City oter) {
        return this.cost - oter.cost;
    }
}/*
3 2 1
1 2 4
1 3 2
*/
