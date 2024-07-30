package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 수정렬하기 {
    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int N=Integer.parseInt(br.readLine());
        int[] list=new int[N];

        for(int i=0;i<N;i++){

            list[i]=(Integer.parseInt(br.readLine()));
        }
        Arrays.sort(list);

        for(int i : list){
            bw.write(String.valueOf(i));
            bw.write("\n");

        }



        bw.flush();

        bw.close();

    }
}
