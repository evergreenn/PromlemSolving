package 이코테.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 감시피하기 {

    static int N;
    static char[][] map;
    static ArrayList<Node> teachers = new ArrayList<>();
    static ArrayList<Node> empty = new ArrayList<>();
    static ArrayList<ArrayList<Node>> output = new ArrayList<ArrayList<Node>>();
    static boolean[] visit;

    //7:39 ~ 8: 38 1시간 컷.
    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        map = new char[N][N];

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {
                String input = s.next();
                if (input.equals("T")) {
                    teachers.add(new Node(i, j));
                }
                if (input.equals("X")) {
                    empty.add(new Node(i, j));
                }
                map[i][j] = input.charAt(0);
            }
        }
        visit = new boolean[empty.size()];
        dfs(new int[3], 0, empty.size(), 0);
        String answer = "NO";


        for (int i = 0; i < output.size(); i++) {
            //각 조합 하나별로 감시유무 판단., 여기서 조합은 3개의 장애물임.
            ArrayList<Node> obsject = output.get(i);
            //감시물 설치
            for (int j = 0; j < obsject.size(); j++) {
                Node node = obsject.get(j);
                map[node.x][node.y] = 'O';
            }

            int cnt=0;
            //선생님이 탐지 가능한지 판단.
            for (int k = 0; k < teachers.size(); k++) {
                Node teacher = teachers.get(k);
                if (!checkStudent(teacher)) {
                    //학생들을 탐지하지 못하였을 경우 cnt 증가.
                    cnt++;
                }
            }
            if (cnt == teachers.size()) {
                //모든 선생님이 학생을 탐지하지 못하였을경우.
                answer="YES";
            }
            //감시물 해제
            for (int j = 0; j < obsject.size(); j++) {
                Node node = obsject.get(j);
                map[node.x][node.y] = 'X';
            }


        }
        System.out.println(answer);
    }

    public static boolean checkStudent(Node node) {
        int x= node.x;
        int y= node.y;
        int[] dx = {-1, 0, +1, 0}; //상 우 하 좌
        int[] dy = {0, +1, 0, -1};

        //상
        while (true) {

            int nx = x + dx[0];
            int ny = y + dy[0];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                x= node.x;
                y= node.y;
                break;
            }
            x=nx;
            y=ny;

            if (map[x][y] == 'O') {
                x=node.x;
                y= node.y;
                break;
            }
            if (map[x][y] == 'S') {
                return true;
            }
        }
        //우
        while (true) {

            int nx = x + dx[1];
            int ny = y + dy[1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                x= node.x;
                y= node.y;
                break;
            }
            x=nx;
            y=ny;

            if (map[x][y] == 'O') {
                x=node.x;
                y= node.y;
                break;
            }
            if (map[x][y] == 'S') {
                return true;
            }
        }
        //하
        while (true) {

            int nx = x + dx[2];
            int ny = y + dy[2];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                x= node.x;
                y= node.y;
                break;
            }
            x=nx;
            y=ny;

            if (map[x][y] == 'O') {
                x=node.x;
                y= node.y;
                break;
            }
            if (map[x][y] == 'S') {
                return true;
            }
        }
        //좌
        while (true) {

            int nx = x + dx[3];
            int ny = y + dy[3];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                x= node.x;
                y= node.y;
                break;
            }
            x=nx;
            y=ny;

            if (map[x][y] == 'O') {
                x=node.x;
                y= node.y;
                break;
            }
            if (map[x][y] == 'S') {
                return true;
            }
        }

        return false;

    }

    public static void dfs(int[] now, int start, int end, int depth) {
        //start ~ end 범위에서 depth 개를 뽑는 조합
        //now는 최종 output에 저장할 배열 , depth는 해당 now배열의 인덱스

        if (depth == 3) {
            ArrayList<Node> tmp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                //뽑힌 조합의 인덱스를 이용하여 해당 인덱스의 empty를조회하여 output에 저장
                Node node = empty.get(now[i]);
                tmp.add(node);

            }
            output.add(tmp);
            return;
        }
        for (int i = start; i < end; i++) {
            if (!visit[i]) {
                visit[i] = true;
                //start ~ end 까지의 인덱스 값을 조합으로 뽑아서 저장.
                now[depth] = i;
                dfs(now, i + 1, end, depth + 1);
                visit[i] = false;
            }
        }


    }

    public static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void printmap() {
        System.out.println("=================================");
        for (int index = 0; index < map.length; index++) {
            System.out.println(Arrays.toString(map[index]));
        }
        System.out.println("=================================");

    }
}
