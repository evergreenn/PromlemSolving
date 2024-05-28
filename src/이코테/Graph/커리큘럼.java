package 이코테.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 커리큘럼 {
    static int[] cost_arr;
    static int[] indegree;
    static ArrayList<ArrayList<Subject>> list;
    static Queue<Integer> queue = new LinkedList<>();


    public static void main(String[] args) {
        // 11: 02 시작

        Scanner s = new Scanner(System.in);
         list = new ArrayList<>();
        StringTokenizer st ;

        int N = s.nextInt();
         cost_arr = new int[N + 1];
         indegree=new int[N+1];
        Arrays.fill(cost_arr, 0);
        Arrays.fill(indegree, 0);

        s.nextLine();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(s.nextLine());

            while (st.hasMoreTokens()) {
                int cost =Integer.valueOf(st.nextToken());
                cost_arr[i]=cost;

                while (st.hasMoreTokens()) {
                    int input = Integer.valueOf(st.nextToken());
                    if (input == -1) {
                        break;
                    }
                    list.get(input).add(new Subject(cost,i));
                    indegree[i]+=1;
                }
            }
        }
    }

    public static void topology_sort() {

        //시작시 진입차수가 0인것을 큐에 담음.
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }


    }
}
class Subject {
    int cost;
    int index;

    public Subject(int cost, int index) {
        this.cost=cost;
        this.index=index;
    }
}
/*
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
 */
