package 이코테.Graph;

import java.util.Scanner;

public class 팀결성 {
    static int[] parent;

    public static void union(int a, int b) {
        int findparent_a = findparent(a);

        int findparent_b = findparent(b);

        if (findparent_a < findparent_b) {
            parent[b] = findparent_a;
        } else {
            parent[a]=findparent_b;
        }

    }

    public static int findparent(int n) {
        if (n == parent[n]) {
            return n;
        } else {
            return findparent(parent[n]);
        }

    }
    public static void main(String[] args) {
        //11: 33 ~ 11: 44

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        int M = s.nextInt();

        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parent[i]=i;
        }

        for (int i = 0; i < M; i++) {
            int order = s.nextInt();

            int a = s.nextInt();
            int b = s.nextInt();

            if (order == 0) {
                union(a, b);
            } else {
                if (findparent(a) == findparent(b)) {
                    System.out.println("YES");

                } else {
                    System.out.println("NO");
                }
            }
        }
    }

}
/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
 */
