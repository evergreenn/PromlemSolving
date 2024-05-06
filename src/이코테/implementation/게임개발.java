package 이코테.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class 게임개발 {
    public static int d;
    public static void main(String[] args){

        //N ,M 0부터 시작
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int M=s.nextInt();
        s.nextLine();
        String space = " ";
        int[] now = Arrays.stream(s.nextLine().split(space))
                .mapToInt(Integer::parseInt)
                .toArray();
        int x=now[0];
        int y=now[1];
        d = now[2];

        int[][] arr=new int[N][];

        for (int i=0;i< arr.length;i++) {
            arr[i] = Arrays.stream(s.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        for (int[] a : arr //실수주의 : 여기서 a 는 지역 변수일 뿐임. 참조 주소값이 아님. 그래서 배열이 저장이 안되는 것임.
        ) {
            System.out.println(Arrays.toString(a));

        }
        int[] direction={0,1,2,3}; // 북 동 남 서 인덱스 순서로 배열 저장.
        int[] dx={-1,0,+1,0};// 상 우 하 좌
        int[] dy = {0,+1,0,-1};

//        System.out.println((-1%4));
        int turn_cnt=0;
        int visit_cnt=1; //첫방문 입력하기.
        arr[x][y]=2;

        while (true) {
            if (turn_cnt == 4) {
                int nx=x-dx[d];
                int ny=y-dy[d];
                if (arr[nx][ny] == 1) {
                    break;
                }
                x=nx;
                y=ny;
                arr[x][y]=2;
                turn_cnt=0;

            }

            turn_left();
            turn_cnt++;
            int nx=x+dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx > N || ny > M) {
                continue;
            }
            if (arr[nx][ny] == 1||arr[nx][ny]==2) {
                continue;
            }
            x=nx;
            y=ny;
            turn_cnt=0;
            visit_cnt++;
            arr[x][y]=2;
            System.out.printf(" 방문 x=%d, y=%d ",x,y );

        }
        System.out.println(visit_cnt);

    }
    static void turn_left() {
//        direction= (direction-1)%4;
        d-=1;
        if (d < 0) {
            d=3;
        }

    }

}

