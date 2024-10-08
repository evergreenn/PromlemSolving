package 이코테.BinarySearch;

import java.util.Scanner;

public class 정렬된배열에서특정수구하기2 {
    public static int[] arr;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N=s.nextInt();
        int x=s.nextInt();
        arr=new int[N+1];

        for(int i=0;i<N;i++){
            arr[i]=s.nextInt();
        }


        int left=leftBound(x);
        int upper=upperBound(x);
        System.out.println(upper-left);



        int end=N;
        int start =0;

        while(start<=end){
            int mid=(start+end)/2;

            if(arr[mid]==x){
                break;
            }
            if(arr[mid]>x){
                end=mid-1;
            }
            if(arr[mid]<x){
                start=mid+1;
            }
        }
    }
    public static int leftBound(int x){
        int start=0;
        int end= arr.length-1;

        while(start<end){
            int mid=(start+end)/2;

            if(arr[mid]>=x){
                end=mid;

            }else{
                start=mid+1;
            }
        }
        return end;

    }
    public static int upperBound(int x){
        int start=0;
        int end=arr.length-1;
        while(start<end){

            int mid=(start+end)/2;

            if(arr[mid]>x){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return end;
    }

}
