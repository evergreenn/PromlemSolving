package 이코테.implementation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

//12:18 ~ 1:03
public class 치킨배달2 {
    public static int[][] map;

    public static ArrayList<ArrayList<Node>> output = new ArrayList<ArrayList<Node>>();
    public static ArrayList<Node> chicken = new ArrayList<>();
    public static ArrayList<Node> house = new ArrayList<>();

    public static boolean[] visited;
    public static int M;
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        M = s.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num=s.nextInt();
                if(num==2){
                    chicken.add(new Node(i, j));
                }
                if (num == 1) {
                    house.add(new Node(i, j));
                }
                map[i][j]=num;
            }
        }
        visited = new boolean[chicken.size()];
        combination(new int[M], 0, 0);
        int answer=(int) 1e9;

        for (int i = 0; i < output.size(); i++) {
            ArrayList<Node> chickens = output.get(i);
            answer = Math.min(calc(chickens), answer);

        }
        System.out.println(answer);

    }

    public static int calc(ArrayList<Node> chicken) {
        int total=0;

        for (Node house : house) {
            int x= house.x;
            int y= house.y;
            int min_d=(int)1e9;


            for (Node chick : chicken) {
                int cx= chick.x;
                int cy = chick.y;
                int tmp=Math.abs(x-cx)+Math.abs(y-cy);
                min_d = Math.min(min_d, tmp);
            }
            total+=min_d;
        }
        return total;
    }
    public static void combination(int[] now, int start,int depth ){
        // chicken의 개수 중에서 now.length(M개)를 뽑는 조합.
        //여기서 now의 인덱스는 depth 임. now[depth]

        if (depth == now.length) {
            ArrayList<Node> tmp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                tmp.add(chicken.get(now[i]));
            }
            output.add(tmp);

            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i]=true;
                now[depth]=i;
                combination(now, i + 1, depth + 1);
                visited[i]=false;
            }
        }


    }
    public static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

}
