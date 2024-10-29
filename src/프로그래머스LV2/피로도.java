package 프로그래머스LV2;

import java.util.ArrayList;
import java.util.Arrays;

public class 피로도 {

    public static ArrayList<ArrayList<Dungeon>> output = new ArrayList<ArrayList<Dungeon>>();
    public static int stemina;
    public static int[][] dungeons;
    public static boolean[] visited;
    public static int max;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        this.stemina=k;
        this.dungeons=dungeons;
        visited=new boolean[dungeons.length];
        Arrays.fill(visited,false);
        max=-1;
        dfs(new int[dungeons.length],0);

        // printoutput();

        for(int i=0;i<output.size();i++){

            //하나의 경우의 수 씩 판별
            calc(output.get(i));
            //하나의 경우의 수 끝난 후 다시 스테미나 채우기
            stemina=k;

        }

        answer=max;

        return answer;
    }

    public void printoutput(){


        for(int i=0;i<output.size();i++){

            for(int j=0;j<output.get(i).size();j++){

                System.out.print(output.get(i).get(j));
            }
            System.out.println();
        }

    }
    public void calc(ArrayList<Dungeon> arr){
        int cnt=0;
        for(Dungeon d : arr){

            if(stemina>=d.required){
                cnt++;
                stemina-=d.spend;
            }else{
                break;
            }
            // System.out.print(d);
        }
        // System.out.println(cnt+"개");

        max=Math.max(max,cnt);


    }

    public void dfs(int[] now, int depth){
        //0부터 dungeons 의 수 중 던전의 개수만큼 뽑아서 나열하는 경우의 수

        if(depth==dungeons.length){
            ArrayList<Dungeon> tmp=new ArrayList<>();


            for(int j=0;j<now.length;j++){

                Dungeon d=
                        new Dungeon(dungeons[now[j]][0],dungeons[now[j]][1]);
                //해당 경우의 순열에서 가능한 여러개의 던전들을 담음 1 순열

                tmp.add(d);
            }
            output.add(tmp);

            return;
        }

        for(int i=0;i<dungeons.length;i++){

            if(!visited[i]){
                visited[i]=true;

                now[depth]=i;
                dfs(now,depth+1);
                visited[i]=false;
            }

        }



    }
    class Dungeon{
        int required;
        int spend;

        public Dungeon(int required, int spend){

            this.required=required;
            this.spend=spend;
        }
        @Override
        public String toString(){

            return "["+required+","+spend+"]";
        }
    }
}
