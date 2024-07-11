package 이코테.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 안테나 {
    //12:32 ~
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        String space = " ";
        int[] input = Arrays.stream(br.readLine().split(space))
                .mapToInt(Integer::parseInt)
                .toArray();

        int min=(int)1e9;
        int t;
        ArrayList<Node> list = new ArrayList<>();

        for(int i=0;i<input.length;i++){
            int target=input[i];
            int sum=0;
            for(int j=0;j<input.length;j++){
                if(i==j){
                    continue;
                }
                sum+=Math.abs(target-input[j]);
            }
            t=Math.min(min,sum);
            if (t != min ) {
                list.add(new Node(input[i],t));
                min=t;
            }
        }

//        Collections.sort(list,new Comparator<Node>(){
//            @Override
//            public int compare(Node o1,Node o2){
//
//                //오름차순 정렬
//                int judge=o1.distance-o2.distance;
//
//                if (judge == 0) {
//                    judge=o1.index-o2.index;
//                    return judge;
//                }
//                return judge;
//            }
//        });




        System.out.println(list.get(0).index);


    }
    static class Node{
        int index;
        int distance;
        public Node(int index,int distance){
            this.index=index;
            this.distance=distance;
        }
        @Override
        public String toString(){
            return String.valueOf(this.index)+" ";
        }
    }
}
