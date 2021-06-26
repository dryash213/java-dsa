package DSA;

public class DPAV {
    public static void main(String[] args) {

    }

    public static int Knapsack01(int[]wt ,int[] val,int w,int n){
        if (w<=0||n==0){
            return 0;
        }
        if (wt[n - 1] > w)
            return Knapsack01(wt, val, w,n - 1);
        else
            return Math.max(val[n - 1]
                            + Knapsack01(wt,val,w - wt[n - 1],n - 1),
                    Knapsack01(wt,val,w,n - 1));
//        int max =Math.max(Knapsack01( wt , val ,w-wt[n-1],n-1),Knapsack01( wt , val ,      w     , n-1));
    }

    public static int Knapsack01Memoized(int[]wt ,int[] val,int w,int n,int[][]arr,int i,int j){
        if (w<=0||n==0){
            return 0;
        }
        if (arr[i][j]!=0){
            return arr[i][j];
        }
        int ans =0;
        if (wt[n - 1] > w)
             ans = Knapsack01(wt, val, w,n - 1);
        else
            ans = Math.max(val[n - 1]
                            + Knapsack01(wt,val,w - wt[n - 1],n - 1),
                    Knapsack01(wt,val,w,n - 1));
        arr[i][j]=ans;
//        int max =Math.max(Knapsack01( wt , val ,w-wt[n-1],n-1),Knapsack01( wt , val ,      w     , n-1));
        return ans;
    }


}
