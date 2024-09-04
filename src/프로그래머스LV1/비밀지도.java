package 프로그래머스LV1;

public class 비밀지도 {
    public static String[][] map;
    public static int[][] binaryArr1;
    public static int[][] binaryArr2;
    public static int size;

    public String[] solution(int n, int[] arr1, int[] arr2) {
        //11:22 ~ 11:49
        String[] answer = new String[n];
        size=n;
        map=new String[n][n];
        binaryArr1=new int[n][n];
        binaryArr2=new int[n][n];

        convertBinaryArr1(arr1);
        convertBinaryArr2(arr2);

        union();

        for(int i=0;i<map.length;i++){

            String tmp="";
            for(int j=0;j<map[i].length;j++){
                tmp+=map[i][j];
            }
            answer[i]=tmp;
        }

        return answer;
    }
    public static void convertBinaryArr1(int[] arr){
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            int[] tmp= new int[size];
            int idx=size-1;

            while(num!=0){

                tmp[idx--]=num%2;
                num/=2;

            }
            while(idx>0){
                tmp[idx--]=0;
            }
            binaryArr1[i]=tmp;
        }

    }
    public static void convertBinaryArr2(int[] arr){
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            int[] tmp= new int[size];
            int idx=size-1;

            while(num!=0){

                tmp[idx--]=num%2;
                num/=2;

            }
            while(idx>0){
                tmp[idx--]=0;
            }
            binaryArr2[i]=tmp;
        }

    }
    public static void union(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(binaryArr1[i][j]==1 || binaryArr2[i][j]==1){

                    map[i][j]="#";
                }else{
                    map[i][j]=" ";
                }
            }
        }
    }
}
