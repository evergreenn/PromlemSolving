package 이코테.implementation;

import java.util.ArrayList;
import java.util.Arrays;

public class 외벽점검 {
    //순열 저장list
    public static ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
    public static boolean[] visited;
    public static int[] now ;
    //5:50 ~ 7: 36
    public int solution(int n, int[] weak, int[] dist) {
        ArrayList<Integer> weaklist=new ArrayList<>();
        for(int i=0;i<weak.length;i++){
            weaklist.add(weak[i]);
        }
        for(int i=0;i<weak.length;i++){
            weaklist.add(weak[i]+n);
        }


        visited=new boolean[dist.length];
        now=new int[dist.length];
        Arrays.fill(visited,false);

        permutation(dist,dist.length,0);
        int answer=dist.length+1;

        //작업 시작 위치에 따른 최소인원 구하기.
        for(int start=0;start<weak.length;start++){
            //사람의 조합.
            for(int i=0;i<list.size();i++){
                int cnt=1;
                int position=weaklist.get(start)+list.get(i).get(cnt-1);


                for(int j=start;j<start+weak.length;j++){

                    if(position<weaklist.get(j)){
                        cnt+=1;

                        if(cnt>=dist.length){
                            break;
                        }
                        position=weaklist.get(j)+list.get(i).get(cnt-1);
                    }
                }


                answer=Math.min(answer,cnt);
            }
        }
        if(answer>dist.length){
            return -1;
        }
        else{
            return answer;
        }


    }
    public void permutation(int[] dist, int end, int depth){
        //0~ end 범위에서 dist.length개를 뽑아서 나열하는 경우의 수
        if(depth==dist.length){
            ArrayList<Integer> temp=new ArrayList<Integer>();
            for(int i=0;i<now.length;i++){
                temp.add(now[i]);
            }
            list.add(temp);

            return;
        }
        for(int i=0;i<end;i++){
            if(!visited[i]){
                visited[i]=true;
                now[depth]=dist[i]; //depth 인덱스에 저장(뽑는 인덱스)
                permutation(dist,end,depth+1);
                visited[i]=false;
            }
        }
    }
}
