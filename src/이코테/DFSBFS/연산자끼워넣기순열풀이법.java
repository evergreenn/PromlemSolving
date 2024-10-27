package 이코테.DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 연산자끼워넣기순열풀이법 {
    static int[] arr;
    static ArrayList<String> calculate = new ArrayList<>();

    static ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();

    static boolean[] visit;
    static int plus;
    static int minus;
    static int multiplex;
    static int divide;
    //7:37~ 8: 41
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

         arr = new int[N];
        visit = new boolean[N];
        Arrays.fill(visit, false);

        for (int i = 0; i < N; i++) {
            arr[i]=s.nextInt();
        }
         plus=s.nextInt();
         minus=s.nextInt();
         multiplex=s.nextInt();
         divide=s.nextInt();

        for (int i = 0; i < plus; i++) {
            calculate.add("+");
        }
        for (int i = 0; i < minus; i++) {
            calculate.add("-");
        }
        for (int i = 0; i < multiplex; i++) {
            calculate.add("*");
        }
        for (int i = 0; i < divide; i++) {
            calculate.add("/");
        }

        dfs(new int[calculate.size()], calculate.size(), 0);
        int max=-(int)1e9;
        int min=(int)1e9;

        for (int i = 0; i < output.size(); i++) {

            int sum = arr[0];
            //하나의 경우의 수별 최대 최소 계산
            ArrayList<String> list = output.get(i);

            for (int j = 1; j < arr.length; j++) {
                String order = list.get(j - 1);
                if (order.equals("+")) {
                    sum+=arr[j];
                } else if (order.equals("-")) {
                    sum-=arr[j];
                } else if (order.equals("*")) {
                    sum *= arr[j];
                } else if (order.equals("/")) {
                    if (sum < 0) {
                        sum = Math.abs(sum);
                        sum=-(sum/arr[j]);
                    }
                    else {

                        sum/=arr[j];
                    }
                }
            }
            max = Math.max(sum, max);
            min = Math.min(sum, min);

        }

        System.out.println(max);
        System.out.println(min);

    }
    // 순열 개산하기
    public static void dfs(int[] now, int end, int depth){
        //0 ~ end 범위에서 now.length 개의 인덱스를 뽑아서 나열하는 경우의 수 계산
        //(calculate 리스트의 범위) depth가 증가하는 상한은 now.length 개.

        if (depth == now.length) {
            //하나의 경우의 수 씩 해당 인덱스 값에 대응하는 연산자를 삽입.
            ArrayList<String> tmp = new ArrayList<>();
            for (int index = 0; index < now.length; index++) {

                int idx = now[index];

                tmp.add(calculate.get(idx));
            }
            output.add(tmp);
            return;
        }
        for (int i = 0; i < end; i++) {
            if (!visit[i]) {
                visit[i]=true;

                //여기서 나는 뽑아야되는 범위(Calculate 리스트)의 인덱스를 저장할 것임.
                //해당 '인덱스' 값으로 now 배열 완성시 Calculate에서 다시 조회해서 최종 output에 저장.
                now[depth] = i;
                //now -> 하나의 경우의 수 를 저장하기위한 배열
                //실수 주의 !!! depth는 조합을 뽑는 배열의 인덱스임.
                dfs(now, end, depth + 1);
                visit[i]=false;
            }


        }

    }
}
