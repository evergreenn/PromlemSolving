package 이코테.DynamicPrograming;

import java.util.ArrayList;
import java.util.Scanner;

public class 미래도시1 {
    public static void main(String[] args) {
        //10시 22분 시작

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        int M=s.nextInt();

        ArrayList<ArrayList<Spot>> list = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int start= s.nextInt();
            int end=s.nextInt();
            int cost=s.nextInt();

            list.get(start).add(new Spot(end,cost));
        }

        int X = s.nextInt();
        int K=s.nextInt();
        //1 -> K -> X


    }
}

class Spot implements Comparable<Spot> {
    int target;
    int cost;

    public Spot(int target, int cost) {
        this.target=target;
        this.cost=cost;
    }

    @Override
    public int compareTo(Spot other) {
        return this.cost-other.target;

    }
}
