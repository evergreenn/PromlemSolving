package 이코테.implementation;

import java.util.*;
//8:29 ~
class 자물쇠와열쇠 {


    public static int M;
    public static int N;
    public boolean solution(int[][] key, int[][] lock) {
        M=key.length;
        N=lock.length;
        int[][] new_lock=new int[N*3][N*3];
        // 새로운 배열 초기화
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                new_lock[N+i][N+j]=lock[i][j];
            }
        }

        //시작 값을 기준으로 완전탐색
        for(int i=0;i<(2*N);i++){
            for(int j=0;j<(2*N);j++){
                //총 4회 회전
                for(int r=0;r<4;r++){
                    key=rotate(key);

                    for(int k=0;k<M;k++){
                        for(int l=0;l<M;l++){
                            new_lock[i+k][j+l]+=key[k][l];
                        }
                    }

                    if(check_all_clear(new_lock)){

                        return true;
                    }
                    //넣었던 것 다시 빼기
                    for(int k=0;k<M;k++){
                        for(int l=0;l<M;l++){
                            new_lock[i+k][j+l]-=key[k][l];
                        }
                    }
                }

            }
        }


        boolean answer = false;
        return answer;
    }

    public boolean check_all_clear(int[][] lock){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(lock[N+i][N+j]!=1){
                    return false;
                }
            }
        }
        return true;
    }
    // 키만 90도로 1회 돌리는 함수.
    public int[][] rotate(int[][] key){
        int[][] temp_key=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                temp_key[j][N-i-1]=key[i][j];
            }
        }
        return temp_key;

    }
}