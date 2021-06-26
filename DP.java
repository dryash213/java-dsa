package DSA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DP {
    public static void main(String[] args ) {
//        System.out.println(FibonaciMemoized(10,new int[10+1]));
                int arr[] ={8,3,1,2};
//        KnapsackUnbounded(arr)
//                int arr[] ={10,15,17,20,16,18,22,20,22,23,25};
//                SellStock4(arr);
//        SumNonAdjactentElementMaxGreedy(arr);
//        int [][] arr ={{1,5,7},{5,8,4},{3,2,9},{1,2,4}};
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        long dp[][] = new long[3][n];
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < n; j++) {
//                dp[i][n] = sc.nextInt();
//            }
//
//        }
//        PaintHouseManyHouse(arr);
//        PiantFence(8,3);
//        System.out.println(Tiling2X1(4));
//        Pairing(5);

//        System.out.println(Partions_Subsets(5,4));
//        System.out.println(CountPathMemoization(0,arr,0));
//        System.out.println(CountPathTabulation(10));
//        int arr2[] ={15,14,10,45,30};
//        int n = 5;
//        int a[] = {1,1,1};
//        System.out.println(NumberofTargetSumSubsetMEMO(a,0,0,0,2,new int[4][3]));

//        int sum = 12;
//        boolean dp[][] = new boolean[n + 1][sum + 1];
//        if (SubsetSumMemoization(a, sum,n,dp))
//        {
//            System.out.println("yes");
//        }
//        else {
//            System.out.println("No");
//        }
//        int arr[][] ={{0,1,4,2,8,2},{4,3,6,5,0,4},{1,2,4,1,4,6},{2,0,7,3,2,2},{3,1,5,9,2,4},{2,7,0,8,5,1}};
//        jumpsTabulation(arr);
//        maxJumpsTabulation(arr);
//        System.out.println(MinCostMemoization(arr));
//        System.out.println(DigMine(arr));
//        System.out.println(TargetSum(arr,10));
        System.out.println(CoinChangeCombinaton(arr,3));
//        System.out.println(Knapsack01Tabulation(arr,arr2,7  ));
//        System.out.println(KnapsackUnbounded(arr,arr2,7  ));
//        System.out.println(CoinChangePermutation(arr,7));
//        countEncoding("21123");


    }
    public static int FibonaciMemoized(int n,int [] qb){
        if (n == 1 || n == 0) {
            return n;
        }
        if (qb[n]!=0){
            return qb[n];
        }
        int n1 = FibonaciMemoized(n-1,qb);
        int n2 = FibonaciMemoized(n-2,qb);
        int sum = n1+n2;

        qb[n] = sum;
        return sum;
    }
    public static int CountPathMemoization(int n,int qb[]){
        if (n==0)
            return 1;
        if (n<0){
            return 0;
        }
        if (qb[n]>0){
            return qb[n];
        }
        int res1 = CountPathMemoization(n-1,qb);
        int res2 = CountPathMemoization(n-2,qb);
        int res3 = CountPathMemoization(n-3,qb);
        int sum = res1+res2+res3;
        qb[n]=sum;
        return sum;
    }
    public int minCostClimbingStairs(int[] cost) {
        Integer[] memo = new Integer[cost.length+1];
        return Math.min(minClimb(cost, 0, memo), minClimb(cost, 1, memo));
    }

    private int minClimb(int[] cost, int index, Integer[] memo) {
        if(index >= cost.length) {
            return 0;
        }

        if(memo[index] == null) {
            memo[index] = Math.min(minClimb(cost, index+1, memo), minClimb(cost, index+2, memo)) + cost[index];
        }

        return memo[index];

    }
    public static int CountPathTabulation(int n){
        int qb[] =  new int[n+1];
        qb[0]=1;
        for (int i = 1; i <=n ; i++) {
            if (i==1){
                qb[i]=qb[i-1];
            }
            else if (i==2){
                qb[i]=qb[i-1]+qb[i-2];
            }else {
                qb[i] = qb[i - 1] + qb[i - 2] + qb[i - 3];
            }

        }
        return qb[n];
    }

    public static void jumpsTabulation(int []arr){
        int qb [] = new int[arr.length+1];
        qb[arr.length] = 1;
        System.out.println(qb.length);
        for (int i = arr.length-1; i >=0 ; i--) {
            int temp=0;
            for (int j = 0; j <= arr[i]; j++) {
                if (i+j<qb.length){
                    temp+=qb[i+j];
                }
                else break;
            }
            qb[i]=temp;
        }
        for (int i = 0; i < qb.length; i++) {
            System.out.println(qb[i]);

        }
    }

    public static void maxJumpsTabulation(int arr[]){
        Integer res[]= new Integer[arr.length+1];
        res[arr.length]=0;
        for (int i = arr.length-1; i >=0 ; i--) {
            if (arr[i]>0){
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= arr[i]&& i+j <res.length; j++) {
                    if (res[i+j]!=null){
                        min=Math.min(min,res[i+j]);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    res[i]=min+1;
                }
//                else res[i]=0;

            }
        }
        System.out.println(res[0]);
    }

    public static int MinCostMemoization(int [][]arr){
        int dp[][] = new int[arr.length][arr[0].length];
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j =arr[0].length-1;j>=0; j--) {
                if (i==arr.length-1 && j==arr[0].length-1){
                    dp[i][j]=arr[i][j];
                }
                else if (i == arr.length-1){
                    dp[i][j]=dp[i][j+1]+arr[i][j];
                }
                else if( j ==arr[0].length-1){
                    dp[i][j] = dp[i+1][j]+arr[i][j];
                }
                else {
                    dp[i][j] = Math.min(arr[i][j]+dp[i+1][j],arr[i][j]+dp[i][j+1]);
                }
            }
//            System.out.println(dp[0][0]);
        }
        return dp[0][0];
    }
    public static int DigMine(int arr[][]) {
        int[][] dp = new int[arr.length][arr[0].length];
        int ans =0;
        for (int i = arr[0].length - 1; i >= 0; i--) { //column
            for (int j = 0; j < arr.length; j++) { //row
                if (i == arr.length - 1) {
                    dp[j][i]=arr[j][i];
                }
                else {
                    if (j-1>=0 && j+1<arr.length){
                        dp[j][i] = arr[j][i]+Math.max(dp[j][i+1],Math.max(dp[j-1][i+1],dp[j+1][i+1]));
                    }
                    else if (j==0){
                        dp[j][i] = arr[j][i]+Math.max(dp[j][i+1],dp[j+1][i+1]);
                    }
                    else {
                        dp[j][i] = arr[j][i]+Math.max(dp[j-1][i+1],dp[j][i+1]);
                    }
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            ans= Math.max(ans,dp[i][0]);
        }
        return ans;
    }

    public static boolean TargetSum(int []arr,int n){
        boolean dp [][] = new boolean[arr.length+1][n+1];
        for (int i = 0; i <= n; i++) {
            dp[0][i]=false;
        }
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0]=true;
        }
//                int arr[] ={4,2,7,1,3};
        for (int i = 1; i <=arr.length ; i++) {
            int temp =arr[i-1];
            dp[i][temp]=true;
            for (int j = 1; j <=n ; j++) {
                if (dp[i-1][j]){
                    dp[i][j]=true;
                }
                else if (dp[i-1][j]){
                    dp[i][j]=true;
                }
                else if (j-temp>=0 && dp[i-1][j-temp]){
                    dp[i][j]=true;
                }
            }
        }


//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        return dp[arr.length][n];
    }

    public static int NumberofTargetSumSubsetMEMO(int []arr,int count,int sum,int n,int target,int dp[][]){
        if (sum==target){
            count++;
            return count;
        }
        if (sum>target||n==arr.length)
            return 0;

        if (dp[n][sum]!=0)
            return dp[n][sum];
        count = NumberofTargetSumSubsetMEMO(arr, count, sum+arr[n],n+1, target,dp)+NumberofTargetSumSubsetMEMO(arr, count, sum,n+1, target,dp);;
//        count =
        dp[n][sum]=count;
        return count;
    }

    public static int NumberofTargetSumSubsetTAB(int []arr,int n) {
        int dp[][] = new int[arr.length + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = 1;
        }
//                int arr[] ={4,2,7,1,3};
        for (int i = 1; i <= arr.length; i++) {
            int temp = arr[i - 1];
            dp[i][temp] = 1;
            for (int j = 1; j <= n; j++) {
                if (arr[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];

                else {
                    dp[i][j] = dp[i - 1][j] +
                            dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[arr.length][n];
    }

    public static boolean SubsetSumMemoization(int set[],int sum,int n, boolean arr[][]) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (arr[n - 1][sum]){
            return arr[n-1][sum];
        }
//        boolean dp[][] = new boolean[n + 1][n + 1];

//        boolean b = false;
        System.out.println(sum);
        if (set[n - 1] > sum) {
            return arr[n-1][sum] = SubsetSumMemoization(set, sum, n - 1,arr);

        } else {
            return arr[n-1][sum] = SubsetSumMemoization(set, sum - set[n - 1], n - 1,arr) || SubsetSumMemoization(set, sum, n - 1,arr);
        }
//        return b;
    }

    public static int CoinChangeCombinaton(int []arr,int sum){
        int dp[] = new int[sum+1];
        dp[0]=1;
        //For combination we will iterate on the array first
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j < dp.length; j++) {
//                if(dp[j-arr[i]]>0){
                    dp[j]+=dp[j-arr[i]];
//                System.out.print(dp[j]+" ");
            }
//            System.out.println();
        }
//        System.out.println(dp[sum]);
        return dp[sum];
    }

    public static long getWays(int sum, List<Long> c) {

        long dp[] = new long[sum+1];
        dp[0]=1;
        //For combination we will iterate on the array first
        for (int i = 0; i < c.size(); i++) {
            for (int j = Math.toIntExact(c.get(i)); j < dp.length; j++) {
//                if(dp[j-arr[i]]>0){
                dp[j]+=dp[(int) (j-c.get(i))];
//                System.out.print(dp[j]+" ");
            }
//            System.out.println();
        }
//        System.out.println(dp[sum]);
        return dp[sum];
        // Write your code here

    }



    public static int CoinChangeCombinaton2(int []arr,int sum){
        int dp[] = new int[sum+1];
        String len[] = new String[sum+1];
        Arrays.fill(len,"");
        int ans=0;
        dp[0]=1;
        if (arr.length==1 && sum>arr[0]){
            return -1;
        }
        //For combination we will iterate on the array first
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j < dp.length; j++) {
//                if(dp[j-arr[i]]>0){
                dp[j]+=dp[j-arr[i]];
                len[j]+=i;
                System.out.print(len[j]+" ");
//                System.out.print(dp[j]+" ");
            }
            ans=Math.max(ans,len[dp.length-1].length());

            System.out.println();
        }
        System.out.println(ans);
        return dp[sum];
    }
    public static int CoinChangePermutation(int []arr,int sum){
        int dp[] = new int[sum+1];
        dp[0]=1;
        //For combination we will iterate on the array first
        for (int i = 1; i <= sum; i++) {
            for (int coin : arr) {
                if (coin <= i) {
                    int ret = i - coin;
                        dp[i] += dp[ret];
                }
//
            }
        }
//        System.out.println(dp[sum]);
        return dp[sum];
    }
    public static int Knapsack01Tabulation(int wt[], int val[],int cap){
        int dp[][] = new int[wt.length+1][cap+1];
        for (int i = 1; i <dp.length ; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j]=dp[i-1][j];
                if (j>=wt[i-1]){
                    if(dp[i-1][j-wt[i-1]] + val[i-1]>dp[i-1][j]){
                        dp[i][j] =dp[i-1][j-wt[i-1]]+val[i-1];
                    }
                    else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
                else {
                    dp[i][j]=dp[i-1][j];
                }
            }

        }
        return dp[wt.length][cap];

    }
//    repetion allowed
    public static int KnapsackUnbounded(int wt[], int val[],int cap){
        int dp[] = new int[cap+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < wt.length; j++) {
                if (i-wt[j]>=0){
                    dp[i] =Math.max(dp[i],Math.max(val[j],val[j]+ dp[i-wt[j]]));
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]+" ");
        }
        return dp[cap];
    }




    /*
    * ------------------KnapSack Over-------------------
    *
    * */

    public static int CountBinaryString(int n){
        int Count_zero_Before = 1;
        int Count_ones_Before = 1;
        for (int i = 2; i <=n; i++) {
            int Count_zero_next = Count_zero_Before;
            int Count_ones_next = Count_ones_Before+Count_zero_Before;
            Count_ones_Before =Count_ones_next;
            Count_zero_Before =Count_zero_next;
        }
        System.out.println(Count_ones_Before+Count_zero_Before);
        return (Count_ones_Before+Count_zero_Before);
    }


    public static void ArrangeBinaryStrings(int n){
        System.out.println(n*n);
    }

    public static void countEncoding(String str){
        int dp[]= new int[str.length()];
        dp[0]=1;
        for (int i = 1; i <dp.length ; i++) {
            if (str.charAt(i-1)=='0' && str.charAt(i)=='0'){
                break;
            }
            else if (str.charAt(i-1)!='0' && str.charAt(i)=='0'){
                if (str.charAt(i)=='1'&&str.charAt(i)=='2')
                    dp[i]=i>1?dp[i-2]:1;
                else
                    dp[i]=0;
            }
            else if (str.charAt(i-1)=='0' && str.charAt(i)!='0'){
                dp[i]=dp[i-1];
            }
            else {
                dp[i]=dp[i-1]+(i>1?dp[i-2]:1);
            }
        }
        System.out.println(dp[str.length()-1]);
    }

    public static void Countsubseq(String str){
        int a=0;
        int ab=0;
        int abc=0;
        for (int i = 0; i <str.length() ; i++) {
            char ch = str.charAt(i);
            if (ch=='a')
                a= 2*a+1;
            else if (ch=='b')
                ab= 2*ab+1;
            else if (ch=='c')
                abc= 2*abc+1;
        }
        System.out.println(abc);
    }

    public static void SumNonAdjactentElementMaxGreedy(int[]arr){
//        int dpinc[] = new int[arr.length];
//        int dpexc[] = new int[arr.length];
        int inc=arr[0];
        int exc=0;
//        dpinc[= arr[0];
        for (int i = 1; i <arr.length ; i++) {
            int necx = Math.max(inc,exc);
            int ninc = arr[i]+exc;

            exc=necx;
            inc=ninc;
//            dpexc=Math.max(dpinc,dpexc);
//            dpinc[i]=dpexc[i-1]+arr[i];
        }
        System.out.println(Math.max(inc,exc));
    }

//    PaintHouse Important
    public static void PaintHouse(int[][]arr){
//        3House
        int red_cost=arr[0][0];
        int blue_cost=arr[0][1];
        int green_cost=arr[0][2];
        System.out.println(red_cost+" "+blue_cost+ " "+green_cost);


        for (int i = 1; i < arr.length; i++) {
            int nrc = arr[i][0] + Math.min(blue_cost,green_cost);
            int nbc = arr[i][1]+ Math.min(red_cost,green_cost);
            int ngc =arr[i][2] +Math.min(blue_cost,red_cost);
            red_cost =nrc;
            blue_cost = nbc;
            green_cost = ngc;
            System.out.println(red_cost+" "+blue_cost+ " "+green_cost);
        }
        System.out.println(Math.min(red_cost,Math.min(blue_cost,green_cost)));
    }

    public static void PaintHouseManyHouse(int[][]arr) {
        int min=Integer.MAX_VALUE,secmin=Integer.MAX_VALUE;
        int dp[][] = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr[0].length; i++) {
            dp[0][i] = arr[0][i];
            if (arr[0][i]<=min){
                secmin=min;
                min = arr[0][i];
            }
            else if (arr[0][i]<=secmin){
                secmin = arr[0][i];
            }
        }
//        System.out.println(min+" "+ secmin);
        for (int i = 1; i < arr.length; i++) {
            int newleast=Integer.MAX_VALUE,newsecleaast=Integer.MAX_VALUE;
            for (int j = 0; j < arr[0].length; j++) {
                if (dp[i-1][j]==min){
                    dp[i][j]=arr[i][j]+secmin;
                }
                else {
                    dp[i][j]=arr[i][j]+min;
                }
//                System.out.println(min+" "+ secmin);


                if (dp[i][j]<=newleast){
                    newsecleaast=newleast;
                    newleast = dp[i][j];
                }
                else if (dp[i][j]<=newsecleaast){
                    newsecleaast = dp[i][j];
                }
            }
//            System.out.println(newleast+" "+newsecleaast);
            min=newleast;
            secmin= newsecleaast;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }


        System.out.println(min);

    }

//    Important
    public static void PiantFence(int n,int k){
        if (n==1)
            return;
//        int[] arr = new int[n];
        int same=k;
        int diff=k*(k-1),total=0;
        for (int i = 1; i < n; i++) {
            total=same+diff;
            same=diff;
            diff=total*(k-1);
        }
        System.out.println(total);

    }

    public static int Tiling2X1(int n){
        int one=1;
        int two=1;
        int ans=one+two;
        for (int i = 3; i <=n; i++) {
            two=one;
            one=ans;
            ans=one+two;

        }
        return ans;
    }
    public static int Tiling_MXN(int m, int n){
        int dp[]= new int[n+1];
        for (int i = 1; i <=n ; i++) {
            if (i<m){
                dp[i]=1;
            }
            else if (i==m){
                dp[i]=2;
            }
            else {
                dp[i]=dp[i-1]+dp[i-m];
            }
        }
        return dp[n];
    }

    public static void Pairing(int n){
        int dp[]=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <=n ; i++) {
            dp[i] = dp[i-1]+ dp[i-2]*(i-1);
        }
        System.out.println(dp[n]);
    }

    public static int Partions_Subsets(int n,int k){
        int dp[][] = new int[k+1][n+1];
        for (int i = 1; i <=k; i++) {
            for (int j = 1; j <=n; j++) {
                if (i>j){
                    dp[i][j]=0;
                }
                else if (i==j){
                    dp[i][j]=1;
                }
                else {
                    dp[i][j]=dp[i][j-1]*i + dp[i-1][j-1];
                }
            }
        }
        for (int i = 0; i <=k; i++) {
            for (int j = 0; j <=n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();

        }
        return dp[k][n];
    }


// -------------------BUY Sell Stock------------
    public static void SellStock(int arr[]){
        int min=Integer.MAX_VALUE;
        int profit=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<min){
                min=arr[i];
            }
            profit=Math.max(profit,arr[i]-min);
        }
        System.out.println(profit);
    }


//Unlimited transaction
    public static void SellStock2(int arr[]){
        int min=Integer.MAX_VALUE;
        int profit=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<min){
                min=arr[i];
            }
            if (arr[i]-min>0)
                profit+=arr[i]-min;
            min=arr[i];
        }
        System.out.println(profit);
    }
// Unlimited transaction + fee
    public static void SellStock3(int arr[]){
        int obsp = -arr[0];
        int ossp = 0;
        int fee=3;
        for (int i = 1; i <arr.length ; i++) {
            obsp=Math.max(obsp,ossp-arr[i]);
            ossp=Math.max(ossp,(obsp+arr[i]-fee));
        }
        System.out.println(ossp);

    }

//    Buy sell with coooldown (rest)
    public static void SellStock4(int arr[]){
        int obsp = -arr[0];
        int ossp = 0;
        int ocsp = 0;
        for (int i = 1; i < arr.length; i++) {
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;
            if (ocsp-arr[i]>obsp){
                nbsp=ocsp-arr[i];
            }
            else {
                nbsp=obsp;
            }
            if (obsp+arr[i]>ossp){
                nssp=obsp+arr[i];
            }
            else {
                nssp=ossp;
            }
            if (ossp>ocsp){
                ncsp=ossp;
            }
            else {
                ncsp=ocsp;
            }
            obsp=nbsp;
            ocsp=ncsp;
            ossp=nssp;
        }
        System.out.println(ossp);
    }

//    IMPORTANT BILLBOARD
    public static void BILLBOARDn2(int[]arr,int rev[],int k){
        int dp[] = new int[arr.length];
        dp[0]=rev[0];
        int ans=0;
        for (int i = 0; i < arr.length; i++) {
            int max=0;
            for (int j = 0; j < i; j++) {
                if (arr[i]-arr[j]>k){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]=max+rev[i];
            ans = Math.max(dp[i],max);
        }
        System.out.println(ans);
    }
    public static void BILLBOARDoptimmized(int m,int[]arr,int rev[],int k){
        HashMap<Integer,Integer> hashMap= new HashMap<>();
        for(int i:arr){
            hashMap.put(arr[i],rev[i]);
        }
        int dp[] = new int[m+1];
        dp[0]=0;
        for (int i = 1; i <=m ; i++) {
            if (!hashMap.containsKey(i))
                dp[i]=dp[i-1];
            else{
                int boardNotInstalled = dp[i-1];
                int boardInstalled=hashMap.get(i);
                if (i>k+1){
                    boardInstalled+=+dp[i-k-1];
                }
                dp[i]=Math.max((boardNotInstalled),(boardInstalled));
            }
        }
        System.out.println(dp[m]);
    }
    /*-------------------------------------------------------------------------------
-------------------------LEEETCODE---------------------
* */
    public int[] countBits(int n) {
        int arr[] = new int[n+1];
        for (int i = 0; i <=n; i++) {
            arr[i] = NoofOnes(i,arr);
        }
        return arr;

    }

    private int NoofOnes(int n,int[]ans) {
        if (n==0){
            return 0;
        }
        if (ans[n]!=0)
            return ans[n];
        int res = NoofOnes(n-1,ans);
        return ans[n]=Integer.bitCount(n);

    }
}
