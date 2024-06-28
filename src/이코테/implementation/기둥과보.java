package 이코테.implementation;

import java.util.ArrayList;
import java.util.Collections;

public class 기둥과보 {
    public static ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();

    //4: 37 ~
    public int[][] solution(int n, int[][] build_frame) {

        for(int i=0;i<build_frame.length;i++){
            int x=build_frame[i][0];
            int y=build_frame[i][1];
            int a=build_frame[i][2];
            int b=build_frame[i][3];
            ArrayList<Integer> list = new ArrayList<>();
            if(b==0){//설치일경우 일단 설치


                list.add(x);
                list.add(y);
                list.add(a);
                answer.add(list);
                if(!possible()){
                    answer.remove(answer.size()-1);

                }
            }
            if(b==1){//삭제일 경우 일단 삭제
                int index;

                for(int j=0;j<answer.size();j++){
                    if(x==answer.get(j).get(0)&&y==answer.get(j).get(1)&&a==answer.get(j).get(2)){
                        index=j;
                    }
                } //삭제할 노드의 인덱스를 검색
                ArrayList<Integer> erased= answer.remove(index);  //우선적으로 인덱스 삭제

                if(!possible()){
                    answer.add(erased); //작업취소
                }
            }
        }


        ArrayList<Stuff> sortlist=new ArrayList<>();

        for(int i=0;i<answer.size();i++){
            int x=answer.get(i).get(0);
            int y=answer.get(i).get(1);
            int a=answer.get(i).get(2);
            Stuff s=new Stuff(x,y,a);
            sortlist.add(s);
        }
        Collections.sort(sortlist);

        int[][] answer = {};
        answer =new int[sortlist.size()][3];
        for(int i=0;i<sortlist.size();i++){
            Stuff s=sortlist.get(i);
            answer[i][0]=s.x;
            answer[i][1]=s.y;
            answer[i][2]=s.a;

        }


        return answer;
    }
    public boolean possible(){

        for(int i=0;i<answer.size();i++){



            int x=answer.get(i).get(0);
            int y=answer.get(i).get(1);
            int a=answer.get(i).get(2);
            int b= answer.get(i).get(3);


            if(a==0){//기둥인경우
                boolean check=false;

                //바닥위에 있거나.
                if(y==0){
                    check=true;

                }

                for(int j=0;j<answer.size();j++){

                    int t_x=answer.get(j).get(0);
                    int t_y=answer.get(j).get(1);
                    int t_a=answer.get(j).get(2);
                    int t_b= answer.get(j).get(3);

                    //보 위에 있거나.
                    if(x==t_x&&y==t_y&&t_a==1){
                        check =true;
                    }
                    if(x==t_x+1&&y==t_y&&t_a==1){
                        check=true;
                    }
                    //다른 기둥위에 있는경우
                    if(x==t_x&&y==t_y-1&&t_b==0){
                        check=true;
                    }

                }
                if(!check){
                    return false;
                }

            }else if(a==1){//보 인 경우
                boolean check=false;

                boolean left=false;
                boolean right=false;

                for(int j=0;j<answer.size();j++){

                    int t_x=answer.get(j).get(0);
                    int t_y=answer.get(j).get(1);
                    int t_a=answer.get(j).get(2);
                    int t_b= answer.get(j).get(3);

                    //한쪽 끝 부분이 기둥위에 있는 경우
                    if(x==t_x&&y==t_y-1&&t_a==0){
                        check=true;
                    }
                    if(x==t_x+1&&y==t_y-1&&t_a==0){
                        check=true;
                    }
                    //양쪽 끝 부분이 다른 보와 동시에 연결되어 있는 경우
                    if(x-1==t_x&&y==t_y&&t_a==1){
                        left=true;
                    }
                    if(x+1==t_x&&y==t_y&&t_a==1){
                        right=true;
                    }

                }
                if(left&&right){
                    check=true;
                }
                if(!check){
                    return false;
                }


            }
        }


        return true;
    }
}
class Stuff implements Comparable<Stuff>{
    int x;
    int y;
    int a;
    public Stuff(int x, int y,int a ){
        this.x=x;
        this.y=y;
        this.a=a;
    }
    @Override
    public int compareTo(Stuff o2){

        if(this.x==o2.x){
            if(this.y==o2.y){
                return this.a-o2.a;
            }
            return this.y-o2.y;
        }
        return this.x-o2.x;
    }
}
