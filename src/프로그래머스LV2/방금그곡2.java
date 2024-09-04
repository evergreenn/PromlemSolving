package 프로그래머스LV2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 방금그곡2 {
    public static ArrayList<Music> list=new ArrayList<Music>();
    public static ArrayList<Result> result=new ArrayList<Result>();



    public String solution(String m, String[] musicinfos) {
        //2:18~3:58

        String answer = "";

        for(int i=0;i<musicinfos.length;i++){
            concat(musicinfos[i]);
        }
        int idx=0;
        for(int i=0;i<list.size();i++){
            Music str=list.get(i);
            if(check(m,str)){
                result.add(new Result(str.name,str.runningTime,idx++));
            }
        }
        Collections.sort(result,new Comparator<>(){

            @Override
            public int compare(Result o1, Result o2){

                int judge = o2.time -o1.time; // 내림차순

                if(judge==0){

                    judge=o1.index-o2.index; //오름차순 (디폴트) 순서대로 빼는 것 !
                    return judge;
                }
                return judge;
            }
        });

        if(result.isEmpty()){
            answer="(None)";
        }else{
            answer=result.get(0).name;
        }


        return answer;
    }
    public static void concat(String str){
        //배열 분리 역할.
        //"12:00,12:14,HELLO,CDEFGAB"
        int startMinute=
                Integer.valueOf(str.substring(0,2))*60
                        +
                        Integer.valueOf(str.substring(3,5));

        int endMinute =
                Integer.valueOf(str.substring(6,8))*60
                        +
                        Integer.valueOf(str.substring(9,11));

        int runningTime = endMinute-startMinute;
        int[] coma=new int[3];
        int idx=0;
        for(int i=0;i<3;i++){
            idx=str.indexOf(",",idx+1);
            coma[i]=idx;
        }
        String Title=str.substring(coma[1]+1,coma[2]);
        String melody=str.substring(coma[2]+1);
        String TotalMelody="";
        if(runningTime<=melody.length()){
            TotalMelody=melody.substring(0,runningTime+1);
        }else{
            for(int i=0;i<runningTime/melody.length();i++){

                TotalMelody+=melody;
            }
            TotalMelody+=melody.substring(0,runningTime%melody.length()+1);

        }
        list.add(new Music(Title,TotalMelody,runningTime));
    }
    public static boolean check(String target,Music music){
        String melody=music.melody;
        if(melody.contains(target)){
            int index=melody.indexOf(target)+target.length();
            if(index<melody.length()){
                if(melody.charAt(index)=='#'){

                    return false;
                }

            }

            return true;



        }
        return false;



    }
    public static class Music{

        String name;
        String melody;
        int runningTime;
        public Music(String name,String melody, int time){

            this.name=name;
            this.melody=melody;
            this.runningTime=time;

        }
    }
    public static class Result{

        String name;
        int time;
        int index;
        public Result(String name, int time, int index){

            this.name=name;
            this.time=time;
            this.index=index;

        }
    }
}
