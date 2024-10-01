package 프로그래머스LV2;

import java.util.ArrayList;
import java.util.HashSet;

public class 의상 {
    public static ArrayList<ArrayList<Cloth>> output=new ArrayList<ArrayList<Cloth>>();
    public static boolean[] visited;
    public static String[][] clothes;
    public int solution(String[][] clothes) {
        int answer = 0;
        visited=new boolean[clothes.length+1];
        this.clothes=clothes;


        for(int i=1;i<=clothes.length;i++){

            visited=new boolean[clothes.length+1];
            combi(new int[i],0,0);
        }

        for(int i=0;i<output.size();i++){
            ArrayList<Cloth> candidate=output.get(i);

            if(judge(candidate)){
                answer++;
            }
        }

        return answer;
    }
    public boolean judge(ArrayList<Cloth> arr){

        HashSet<String> set=new HashSet<String>();

        for(Cloth c : arr){

            if(!set.contains(c.kind)){

                set.add(c.kind);
            }else{
                return false;
            }
        }
        return true;
    }

    public void combi(int[] now, int start,  int depth){
        //depth는 now의 인덱스임. Start ~end 범위중 now.lenght 만큼 뽑는 조합.


        if(depth==now.length){
            ArrayList<Cloth> tmp=new ArrayList<Cloth>();
            for(int i=0;i<now.length;i++){

                Cloth cloth=new Cloth(clothes[now[i]][0],clothes[now[i]][1]);
                tmp.add(cloth);
            }
            output.add(tmp);

            return;
        }
        for(int i=start;i<clothes.length;i++){
            if(!visited[i]){
                visited[i]=true;
                now[depth]=i;
                combi(now,i+1,depth+1);
                visited[i]=false;
            }

        }

    }
    class Cloth{
        String name;
        String kind;
        public Cloth(String name,String kind){
            this.name=name;
            this.kind=kind;
        }
        @Override
        public String toString(){

            return "name";
        }

    }
}
