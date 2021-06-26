package DSA;

//import java.util.*;

import java.util.*;

public class recur {
    static int n=0;
    public static void main(String[] args) {
//        int arr[][]= new int[4][3];
//        List<String > lst = new ArrayList<>();/**/
//        int arr[] = {1, 2,3};
//
//        createAbrevation("YASH","",0,0);
//        System.out.println(subsets(arr));
//        lst = nqueens(arr,0,"");
//        System.out.println(lst);
//        List<List<String>> ans =new ArrayList<>();
//        ans = pattern(lst,4);
//        System.out.println(ans);
//        System.out.println(KnightTour1(arr,0,0,0,1));
//        boolean[][] arr= new boolean[4][4];
//        nQueensOptimized(arr);
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            l.add(LexographicalOrder( i,13));
        }
        for(List<Integer> i:l){
            for (int j:i){
                temp.add(j);
            }
        }
        System.out.println(temp);



    }
    public static int CountPath(int n){
        if (n==0)
            return 1;
        if (n<0){
            return 0;
        }
        int res1 = CountPath(n-1);
        int res2 = CountPath(n-2);
        int res3 = CountPath(n-3);
        int sum = res1+res2+res3;
        return sum;
    }
    public static void fillMaze(int arr[][], int row, int col, String s, boolean[][] visited){
        if (row<0||col<0||row>arr.length||col>arr[0].length||visited[row][col]==true){
            return;
        }
        if (row==(arr.length-1) && col==(arr[0].length-1)){
            System.out.println(s);
            n++;
            return;
        }
        visited[row][col]=true;
        fillMaze(arr,row-1,col,s+"u",visited);
        fillMaze(arr,row,col-1,s+"l",visited);
        fillMaze(arr,row+1,col,s+"d",visited);
        fillMaze(arr,row,col+1,s+"r",visited);
        visited[row][col]= false;

    }
    public void subset(int arr[],int idx,String s,int target,int sum){
        if (idx==arr.length)
            return;
        if (target==sum){
            System.out.println(s);
        }
        subset(arr,idx+1,arr[idx]+" ",target,sum+arr[idx]);
        subset(arr,idx+1,s,target,sum);
    }
    public static List<String> nqueens(int[][] arr, int row, String s){
        if (row==arr.length){
//            System.out.println(s);
            List<String > lst = new ArrayList<>();
            lst.add(s);
            return lst;
        }
        List<String > ls = new ArrayList<>();
        List<String > res = new ArrayList<>();

        for (int col = 0; col < arr.length; col++) {
                if (isSafeforQueen(arr,row,col)) {
                    arr[row][col] = 1;
                ls = nqueens(arr, row + 1, s + row + "-" + col+" ");
                for(String str:ls){
                    res.add(str);
                }
                arr[row][col] = 0;
            }
        }

        return res;
    }
    private static boolean isSafeforQueen(int[][] arr, int row, int col) {
        for (int i = row-1; i >=0; i--) {
            if (arr[i][col]==1)
                return false;
        }
        for (int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if (arr[i][j]==1)
                return false;
        }
        for (int i=row-1,j=col+1;i>=0&&j<arr[0].length;i--,j++){
            if (arr[i][j]==1)
                return false;
        }
        return true;

    }

    public static List<List<String>> pattern(List<String> lst,int len){
        char[] chars = new char[len];
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
//            ls.clear();
            List<String > ls = new ArrayList<>();

            String str [] =lst.get(i).split(" ");
//            System.out.println(str.length);
            for (int j = 0; j < len; j++) {
                int n = Integer.parseInt(str[j].split("-")[1]);
                Arrays.fill(chars, '.');
//                System.out.println(n);
                chars[n]='Q';
                String s = new String(chars);
                ls.add(s);
            }

            ans.add(ls);
            System.out.println(ls);
//            ls.();
        }
        return ans;
    }

    public static void KnightTour(int arr[][],int row,int col,int move){
        if (row>=0||col>=0||row<arr.length||col<arr[0].length||arr[row][col]>0){
//            System.out.println();
            return ;
        } else if (move == arr.length * arr[0].length) {
            arr[row][col]=1;
            displayarr(arr);
            arr[row][col]=0;
        }
        arr[row][col]=1;
        KnightTour(arr,row-2,col+1,move+1);
        KnightTour(arr,row-1,col+2,move+1);
        KnightTour(arr,row+1,col+2,move+1);
        KnightTour(arr,row+2,col+1,move+1);
        KnightTour(arr,row+2,col-1,move+1);
        KnightTour(arr,row+1,col-2,move+1);
        KnightTour(arr,row-1,col-2,move+1);
        KnightTour(arr,row-2,col-1,move+1);
        arr[row][col]=0;



    }

    private static void displayarr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int a = 0; a < arr[0].length; a++) {
                System.out.print(arr[i][a]);
            }
            System.out.println();
        }
    }
    public static int KnightTour1(int arr[][],int row,int col,int move,int len){
        int count=0;
        if (row<0||col<0||row>=arr.length||col>=arr[0].length||arr[row][col]>0||((row==3)&&(col==0||col==2))){
            return count;
        }
        else if (len==move) {
            arr[row][col]=1;
//            displayarr(arr);
            arr[row][col]=0;
            count+=1;
            return count;
        }
//        arr[row][col]=1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if(isValidKnight(arr,i,j)){
                    count++;
                    System.out.println("here");

                }
//                count+=KnightTour1(arr,row-2,col+1,move+1,len);
//                count+=KnightTour1(arr,row-1,col+2,move+1,len);
//                count+=KnightTour1(arr,row+1,col+2,move+1,len);
//                count+=KnightTour1(arr,row+2,col+1,move+1,len);
//                count+=KnightTour1(arr,row+2,col-1,move+1,len);
//                count+=KnightTour1(arr,row+1,col-2,move+1,len);
//                count+=KnightTour1(arr,row-1,col-2,move+1,len);
//                count+=KnightTour1(arr,row-2,col-1,move+1,len);
            }

        }

//        arr[row][col]=0;
        return count;
    }

    private static boolean isValidKnight(int[][] arr, int row, int col ) {
        if (row<0||col<0||row>=arr.length||col>=arr[0].length||arr[row][col]>0||((row==3)&&(col==0||col==2))){
            return false;
        }
        isValidKnight(arr,row-2,col+1);
        isValidKnight(arr,row-1,col+2);
        isValidKnight(arr,row+1,col+2);
        isValidKnight(arr,row+2,col+1);
        isValidKnight(arr,row+2,col-1);
        isValidKnight(arr,row+1,col-2);
        isValidKnight(arr,row-1,col-2);
        isValidKnight(arr,row-2,col-1);
        return true;
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i <Math.pow(2,nums.length); i++) {
            int temp = i;
//            String s = "";
            List<Integer>lst = new ArrayList<>();
            for (int j = nums.length - 1; j >= 0; j--) {
                int r = temp%2;
                temp=temp/2;
                if (r!=0){
                    lst.add(0,nums[j]);
//                    lst.add()
//                    s=""+s;
                }
//                else {
//                    s= nums[j]+s;
//                }
            }
            set.add(lst);
        }
        for (List<Integer> str :set){
//            lst.add(str);
            arr.add(str);
        }
        return arr;
    }
    public List<List<Integer>> subsets1(int[] nums) {
        return subsets2(nums, 0);
    }

    private List<List<Integer>> subsets2(int[] nums, int i) {
        if (i > nums.length - 1) {
            List<List<Integer>> listWithEmptySubset = new ArrayList<>();
            listWithEmptySubset.add(new ArrayList<>());
            return listWithEmptySubset;
        }

        List<List<Integer>> lst = subsets2(nums,i+1);
        List<List<Integer>> ls = new ArrayList<>();
        for (List<Integer> temp:lst){
            List<Integer> t =  new ArrayList<>(temp);
            t.add(nums[i]);
            ls.add(t);
        }
        ls.addAll(lst);

//        for(List<Integer> l :lst){
//            if (!ls.contains(l)){
//                ls.add(l);
//            }
//        }
        return ls;
    }


    //Word Abrevation IMP

    public static void createAbrevation(String str,String res,int idx,int count){
        if (idx==str.length()) {
            if (count==0)
            System.out.println(res);
            else
                System.out.println(res+count);
            return;
        }
        if (count>0) {
            createAbrevation(str,res+count+str.charAt(idx),idx+1,0);
        }
        else
            createAbrevation(str,res+str.charAt(idx),idx+1,0);
            createAbrevation(str,res,idx+1,count+1);
    }
    public static void nQueensOptimized(boolean arr[][]){
        boolean col[]=new boolean[arr[0].length];
        boolean dial2r[] =  new boolean[2*arr.length-1];
        boolean diar2l[] =  new boolean[2*arr.length-1];
        System.out.println(solve_N_Queens(arr,0,col,dial2r,diar2l,0));

    }

    private static int solve_N_Queens(boolean[][] arr, int row, boolean[] column, boolean[] dial2r, boolean[] diar2l, int count)  {
        if (row==arr.length){
//            System.out.println(count);
            count+=1;
            return count;
        }
        for (int col = 0; col < column.length; col++) {
            if (column[col]==false && dial2r[row+col]==false &&diar2l[row-col+arr.length-1]==false ){
                arr[row][col]=true;
                column[col]=true;
                dial2r[row+col]=true;
                diar2l[row-col+arr.length-1]=true;
                count = solve_N_Queens(arr, row+1, column, dial2r, diar2l, count);
                arr[row][col]=false;
                column[col]=false;
                dial2r[row+col]=false;
                diar2l[row-col+arr.length-1]=false;
            }
            
        }
        return count;
    }
//    public static void LexographicalOrder(int curr,int n){
//        if (curr>n){
//            return;
//        }
//        System.out.println(curr);
//        for (int j = 0; j < 10; j++) {
////            LexographicalOrder(n,curr*10);
//            LexographicalOrder(10*curr+j,n);
////            System.out.println();
//        }
//
//
//
//    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> lst = new ArrayList<>();

        for(int i=1;i<=n;i++){
            List<Integer> l = new ArrayList<>();
            l = LexographicalOrder(i,n);
            lst.addAll(l);
        }
        return lst;

    }
    public static List<Integer> LexographicalOrder(int curr,int n){
        if (curr>n){
            return new ArrayList<>();
        }
        List<Integer> lst = new ArrayList<>();
        lst.add(curr);
        // System.out.println(curr);
        for (int j = 0; j < 10; j++) {
//            LexographicalOrder(n,curr*10);
            List<Integer> l = new ArrayList<>();
            l = LexographicalOrder(10*curr+j,n);
            lst.addAll(l);

//            System.out.println();
        }
        return lst;


    }
    public static boolean SubsetSum(int set[],int sum,int n) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        boolean b = false;
        if (set[n - 1] > sum) {
            b = SubsetSum(set, sum, n - 1);

        } else {
            b = SubsetSum(set, sum - set[n - 1], n - 1) || SubsetSum(set, sum, n - 1);

        }
        return b;
    }

    public static boolean Partition(int arr[],int n, int sum,int calc){
        if (n==arr.length)
            return false;
        if (sum==calc){
            return true;
        }
        boolean b = false;
        b = Partition(arr,n+1,sum-arr[n],calc+arr[n]) || Partition(arr,n+1,sum,calc);
        return b;
    }
    public static boolean Partition2(int arr[],int n){
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
        }
        if (sum%2!=0)
            return false;
        else return Partition2(arr,sum/2);
    }

}
