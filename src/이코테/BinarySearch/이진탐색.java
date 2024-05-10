package 이코테.BinarySearch;

public class 이진탐색 {
    public static int binarysearch(int[] arr, int start, int end, int target) {

        if (start > end) {
            return -1;
        }
        int mid=(start+end)/2;

        if (arr[mid] == target) {
            return mid;// 위치한 인덱스 반환
        } else if (arr[mid] < target) {

            return binarysearch(arr, mid + 1, end, target); //중요 중앙값인 mid는 제외한 범위 재귀 호출
        } else {
          return binarysearch(arr,start,mid-1,target);
        }

    }
    public static void main(String[] args) {

        int[] arr ={1,2,3,4,5,6,7,8,9,10,71};
        int result=binarysearch(arr,0,arr.length-1,3);
        if (result == -1) {
            System.out.println("값이 존재하지 않습니다.");
        } else {
            System.out.println(result+"위치에 값이 존재합니다.");
        }

    }
}
