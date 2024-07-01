package 이코테.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import org.w3c.dom.Node;

public class 치킨배달 {
    public static ArrayList<Node> house = new ArrayList<>();
    public static ArrayList<Node> chicken = new ArrayList<>();
    public static ArrayList<ArrayList<Node>> combination = new ArrayList<ArrayList<Node>>();
    public static Boolean[] visit;
    public static int M;

    //2:50~ 4:20
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        M = s.nextInt();

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                int check = s.nextInt();
                if (check == 1) {
                    house.add(new Node(i, j));
                    continue;
                }
                if (check == 2) {
                    chicken.add(new Node(i, j));
                    continue;
                }
            }
        }
        visit = new Boolean[chicken.size()];
        Arrays.fill(visit,false);
        //치킨집의 조합을 추출.
        combi(0, chicken.size(), M);

        int min=(int)1e9;

        for (int i = 0; i < combination.size(); i++) {
            //각 치킨집의 조합으로 해당 조합의 치킨거리를 반환
            int city_min = calculate(combination.get(i));
            min=Math.min(min,city_min);
        }
        System.out.println(min);


    }

    public static void combi(int start, int end, int depth) {
        // start ~ end 의 범위에서 depth개를 뽑는 경우

        if (depth == 0) {

            ArrayList<Node> inserted = new ArrayList<>();
            for (int j = 0; j < visit.length; j++) {
                if (visit[j]) {
                    inserted.add(chicken.get(j));
                }
            }
            combination.add(inserted);


            return;
        }
        for (int i = start; i < end; i++) {
            visit[i] = true;
            combi(i + 1, end, depth - 1);
            visit[i] = false;
        }
    }

    public static int calculate(ArrayList<Node> chicken) {
        int sum=0;

        for (int i = 0; i < house.size(); i++) {
            Node house_ = house.get(i);
            int min = (int) 1e9;
            for (int j = 0; j < chicken.size(); j++) {
                Node chicken_ = chicken.get(j);
                int r_cal = house_.r - chicken_.r;
                int r_cal_abs = r_cal < 0 ? -r_cal : r_cal;
                int c_cal = house_.c - chicken_.c;
                int c_cal_abs = c_cal < 0 ? -c_cal : c_cal;

                 min=Integer.min(min,r_cal_abs+c_cal_abs);
            }
            sum+=min;
        }
        return sum;
    }

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        @Override
        public String toString(){
            return "( "+r+" )"+"( "+c+" ) ";
        }
    }
}
