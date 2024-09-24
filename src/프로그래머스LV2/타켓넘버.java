package 프로그래머스LV2;

public class 타켓넘버 {
    public static int size;
    public static int plus;
    public static int minus;
    public static int[] nums;
    public static int target;
    public static int cnt=0;


    public int solution(int[] numbers, int target) {

        int answer = 0;
        size= numbers.length;
        nums=numbers;
        this.target=target;
        plus = size-1;
        minus=size-1;

        dfs(0,0);
        answer=cnt;
        return answer;

    }
    public void dfs(int depth,int sum){
        if(depth==size){

            if(sum==target){
                cnt++;
            }

            return;
        }
        if(plus>0){
            plus-=1;
            dfs(depth+1,sum+nums[depth]);
            plus+=1;
        }
        if(minus>0){
            minus-=1;
            dfs(depth+1,sum-nums[depth]);
            minus+=1;
        }




    }
}
