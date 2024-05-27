package 이코테.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 도시분할계획 {
    static int[] parent;

    public static void union(int a, int b) {
        int parent_a = findParent(a);
        int parent_b = findParent(b);

        if (parent_a > parent_b) {
            parent[a] = parent_b;
        } else {
            parent[b]=parent_a;
        }
    }

    public static int findParent(int n) {
        if (n == parent[n]) {
            return n;
        } else {
            return findParent(parent[n]);
        }

    }
    public static void main(String[] args) throws IOException {
        //10시 23분 ~ 10시 56분 포기.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        long result=0;
        long max=(long) -1e9;

        PriorityQueue<House> heapq = new PriorityQueue<>();
        ArrayList<House> list = new ArrayList<>();
        parent=new int[N+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i]=i;
        }
        for (int i = 0; i < M; i++) {
            int[] city = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int start=city[0];
            int end=city[1];
            int cost = city[2];
            heapq.offer(new House(start,end,cost));

        }





//        Collections.sort(list);
//        for (House b : list) {
//            System.out.println(b);
//        }


        while (!heapq.isEmpty()) {
            House edge = heapq.remove();
            System.out.println(edge);
            int a = findParent(edge.start);
            int b = findParent(edge.end);
            int cost=edge.cost;
            if (a == b) {
                continue;
            }

            union(a,b);
            result+=cost;
            max=Math.max(max,cost);
        }
        System.out.println(result-max);
    }

}

class House implements Comparable<House> {

    int start;
    int end;
    int cost;

    public House(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(House other) { //오름차순 정렬 this - other
        int oter_cost = other.cost;


        return this.cost-oter_cost;
    }

    @Override
    public String toString() {
        return start +" "+end+" "+cost;
    }
}
/*
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4
 */
