package 이코테.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class 정렬된배열에서특정수의개수구하기 {
    static int[] input;
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int x = s.nextInt();
        s.nextLine();

        input = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(Arrays.toString(input));

        System.out.println(upperbound(0, input.length,x )-
                lowerbound(0, input.length, x));

    }

    public int binarysearch(int start,int end,int target){


        while (start<end){

           int mid=(start+end)/2;
            if(input[mid]==target){
                return mid;
            }
            if(input[mid]<target){
                start=mid+1;
            }
            if(input[mid]>target){
                end=mid-1;
            }

        }
        return -1;


    }
    public static int lowerbound(int start,int end,int target){

        while(start<end){

            int mid=(start+end)/2;
            System.out.println("mid = " + mid);

            if(input[mid]>=target){

                end=mid;
            }
            else{
                start=mid+1;
            }
        }

        return end;

    }
    public static int upperbound(int start,int end,int target){

        while(start<end){


            int mid=(start+end)/2;
            System.out.println("mid = " + mid);
            if(input[mid]>target){
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
