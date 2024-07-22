package 이코테.Sort;

import java.util.ArrayList;
import java.util.Collections;

public class 실패율 {
    //11: 00 ~ 11:53
    public int[] solution(int N, int[] stages) {

        ArrayList<Stage> list=new ArrayList<>();

        int users=stages.length;

        for(int i=1;i<=N;i++){
            int challenge=0;
            int failed=0;
            for(int j=0;j<stages.length;j++){

                if(stages[j]>=i){
                    if(stages[j]==i){
                        failed++;
                    }

                    challenge++;


                }
            }

            double rate=0;
            System.out.println("challenge : "+ challenge+"failed : "+failed);

            if(challenge!=0){



                rate=(double)failed/challenge;
                System.out.println("num : "+ i+"rate : "+rate);
            }


            list.add(new Stage(i,rate));

        }
        Collections.sort(list);
        for(Stage s : list){

            System.out.println(s);
        }




        int[] answer = {};

        answer =new int[list.size()];
        for(int i=0;i<list.size();i++){

            answer[i]=list.get(i).num;
        }
        return answer;
    }
    static class Stage implements Comparable<Stage>{
        int num;
        double rate;
        public Stage(int num, double rate){
            this.num=num;
            this.rate=rate;
        }
        @Override
        public int compareTo(Stage other){
            //실패율 내림차순

            double judge=(other.rate-this.rate);

            //스테이지 넘버 오름차순
            if(judge==0){
                judge=this.num-other.num;
            }

            if(judge<0){
                return -1;
            }

            else if(judge>0){

                return 1;
            }
            else {
                return 0;
            }



        }
        @Override
        public String toString(){
            return "num "+num+" rate :"+rate;
        }

    }


}
