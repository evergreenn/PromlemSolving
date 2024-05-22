package 이코테.Graph;

import java.util.Arrays;
import java.util.Scanner;

public class UnionFind {
    static int[] parent;

    public static int findparent(int n) {

        if (n == parent[n]) {
            return n;
        } else {
            return findparent(parent[n]);
        }

    }

    public static void union(int a, int b) {
        int a_parent = findparent(a);
        int b_parent = findparent(b);

        if (a_parent < b_parent) {
            parent[b] = a_parent;
        } else {
            parent[a]=b_parent;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int M=s.nextInt();

        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parent[i]=i;
        }

        for (int i = 0; i < M; i++) {
            int a = s.nextInt();
            int b = s.nextInt();

            union(a,b);
        }

        System.out.print("각 원소가 속한 집합: ");
        for (int i = 1; i <= N; i++) {
            System.out.print(findparent(i)+" ");
        }
        System.out.println();
        System.out.print("부모 테이블: ");
        for (int i = 1; i <= N; i++) {
            System.out.print(parent[i]+" ");
        }

        System.out.println(Arrays.toString(parent));




    }
}
/*
3 3
1 2
1 3
2 3
 */
/*
6 4
1 4
2 3
2 4
5 6
 */