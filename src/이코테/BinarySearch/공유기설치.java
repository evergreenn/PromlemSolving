package 이코테.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class 공유기설치 {
    static int[] house;
    //2:09 ~ 3:30
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int C=s.nextInt();
        house=new int[N];
        int min=(int)1e9;
        int max=(int)-1e9;
        for(int i=0;i<N;i++){
            int input=s.nextInt();
            house[i]=input;
        }
        Arrays.sort(house);

        min=1;
        max=house[N-1]-house[0];
        int start=min;
        int end=max;
        int answer=0;


        while(start<=end){
            //공유기 사이의 거리
            int mid=(start+end)/2;
            int cnt=1;

            int first=house[0];
            //공유기를 설치
            for(int i=1;i<N;i++){
                int gap=house[i]-first;

                if(gap>=mid){
                    //인접한 거리가 정한 공유기 거리보다 클시에 설치.
                    cnt++;
                    // 계산 기준 변경. 그 다음 인접한 공유기를 계산
                    first=house[i];
                }

            }


            if(cnt<C){
                //공유기 가 덜 설치됨. 간격을 줄여야 함.

                end=mid-1;
            }
            if(cnt>=C){
                //공유기가 많이 설치됨. 간격을 늘리기.
                answer=Math.max(answer,mid);
                start=mid+1;
            }

        }

        System.out.println(answer);

    }
}
