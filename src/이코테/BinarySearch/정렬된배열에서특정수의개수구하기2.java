package 이코테.BinarySearch;

import java.util.Scanner;

public class 정렬된배열에서특정수의개수구하기2 {
    static int[] arr;
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int N=s.nextInt();
        int X=s.nextInt();
        arr=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=s.nextInt();
        }

        System.out.println(upperbound(0,N,X)-
                lowerbound(0,N,X));

        System.out.println("binarysearch(0,N-1,3) = " + binarysearch(0, N - 1, 3));




    }
    public static int binarysearch(int start,int end,int target){


        while(start<=end){
            int mid=(start+end)/2;

            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]>target){
                //왼쪽탐색

                end=mid-1;

            }
            if(arr[mid]<target){

                //오른쪽 탐색

                start=mid+1;
            }
        }
        return -1;
    }

    public static int lowerbound(int start,int end,int target){


        while(start<end){
            int mid=(start+end)/2;
            // <- 이쪽으로 당기기. 최종적으로 end를 반환해야 하므로 등호 붙임.
            if(arr[mid]>=target){
                end=mid;
            }else{
                start=mid+1;
            }


        }
        return end;
    }
    public static int upperbound(int start,int end,int target){


        while(start<end){
            int mid =(start+end)/2;
            // <- 이쪽으로 당기기 그런데 최종적으로는 end를 반환해야 함으로 < 가 맞음.
            if(arr[mid]>target){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return end;
    }
}

/*
7 2
1 1 2 2 2 2 3
 */