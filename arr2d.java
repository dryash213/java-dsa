package DSA;

import java.util.Arrays;
import java.util.Scanner;

public class arr2d {
    public static void main(String[] args) {
//        int arr[][] = new int[4][4];
//        int arr[][] = {{1,2,3,4},{5,6,7,8},{1,2,3,4},{5,6,7,8}};
//        for (int i = 0; i <4; i++) {
//            for (int j = 0; j < 4; j++) {
//                arr[i][j]=j+1;
//            }
//
//        }
//        exitPath(arr);
//        shells(arr,1,1);
//        SaddlePoint(arr);
        Scanner sc  = new Scanner(System.in);
        int arr[][] =  new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        solveSudoku(arr,0,0);
    }

    public static void rotate(int[][] matrix) {
        String str[] = new String[matrix.length];
        String ans[] = new String[matrix.length];
        String [][] mat= new String[matrix.length][matrix.length];
        Arrays.fill(ans,"");
        int j=0;
        for (int i = matrix.length-1; i >=0; i--) {
            str[j]=Arrays.toString(matrix[i]);
            str[j]=str[j].substring(1,str[j].length()-1);
            str=str[j].split(",");
            for (int k = 0; k < str.length; k++) {
                ans[k]+=str[k]+",";
            }
            j++;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix.length; k++) {
                str = ans[i].split(",");
//                for (int l = 0; l < str.length; l++) {
//                    System.out.println(str[l]);
//                }
                mat[i][k] = (str[k]);
            }
//            System.out.println(str);
        }
//        System.out.println(ans);

        for (int i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[i].length ; j++) {
//                ans.charAt(i)=(matrix[i][j]);
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void traversel(int arr[][]){
        int temp=0;
        for (int i = 0; i < arr.length; i++) {
            if (temp%2!=0){
                for (int j = arr[i].length-1; j >=0 ; j--) {
                    System.out.println(arr[j][i]);
                }
            }
            else {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.println(arr[j][i]);
                }
            }
            temp++;
        }
    }
    public static void exitPath(int arr[][]){
        int i=0,j=0;
        int count=0;
        while (true) {
            count= (count+arr[i][j])%4;
            if (count==0){
                j++;
            }
            else if (count==1){
                i++;
            }
            else if (count==2){
                j--;
            }
            else
                i--;
//            if (count==4)
//                count%=4;

            if (i<0||j<0||j==arr.length||i==arr.length){
                if (i<0){
                    i++;
                }
                if (j<0){
                    j++;
                }
                System.out.println(i+" "+j);
                break;
            }
        }
    }
    public static int[][]shells(int arr[][],int s,int k){

        int[] oneD = fill1DfromShell(arr,s,k);

        printarray1D(oneD);
        oneD = rotate1D(oneD,k);
        printarray1D(oneD);
        arr = Insert1D(arr,oneD,s,k);
        printarray2D(arr);

        return arr;

    }

    private static void printarray2D(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] Insert1D(int[][] arr, int[] oneD, int s, int k) {
        int minrow = s-1;
        int mincol = s-1;
        int maxrow = arr.length-s;
        int maxcol = arr[0].length-s;

        int idx =0;
//        int oneD[] = new int[2*((maxrow-minrow) +(maxcol-mincol)) ];
        for (int i = minrow,j = mincol ; i <=maxrow ; i++) {
            arr[i][j]=oneD[idx++];
        }
        for (int i = maxrow,j = mincol+1 ; j <=maxcol ; j++) {
            arr[i][j] =oneD[idx++];
        }
        for (int i = maxrow-1,j = maxcol ; i >=minrow ; i--) {
           arr[i][j] = oneD[idx++];
        }
        for (int i = minrow,j = maxcol-1 ; j >=mincol+1 ; j--) {
            arr[i][j] = oneD[idx++];
        }
        return arr;
    }

    private static int[] rotate1D(int[] oneD, int k) {
        k=k%oneD.length;
        if (k<0){
            k=oneD.length+k;
        }
        oneD = reverse(oneD,0,oneD.length-k-1);
        oneD = reverse(oneD,oneD.length-k, oneD.length-1);
        oneD = reverse(oneD,0,oneD.length-1);
        return oneD;
    }

    private static int[] reverse(int[] oneD, int left, int right) {
        while (left<right){
            int temp =oneD[left];
            oneD[right]=oneD[left];
            oneD[left]=temp;
            left++;
            right--;
        }
        return oneD;
    }


    private static void printarray1D(int[] oneD) {
        for (int i = 0; i < oneD.length; i++) {
            System.out.println(oneD[i]);

        }
    }

    private static int[] fill1DfromShell(int[][] arr, int s, int k) {
        int minrow = s-1;
        int mincol = s-1;
        int maxrow = arr.length-s;
        int maxcol = arr[0].length-s;

        int idx =0;
        int oneD[] = new int[2*((maxrow-minrow) +(maxcol-mincol)) ];
        for (int i = minrow,j = mincol ; i <=maxrow ; i++) {
            oneD[idx++] = arr[i][j];
        }
        for (int i = maxrow,j = mincol+1 ; j <=maxcol ; j++) {
            oneD[idx++] = arr[i][j];
        }
        for (int i = maxrow-1,j = maxcol ; i >=minrow ; i--) {
            oneD[idx++] = arr[i][j];
        }
        for (int i = minrow,j = maxcol-1 ; j >=mincol+1 ; j--) {
            oneD[idx++] = arr[i][j];
        }

//        int i=arr.length;
//        int j = arr[0].length;
//        i=i-s+1;
//        j=j-s+1;
//        System.out.println(i+"  "+j);
//
//        int temp=0;
//        int ret[] =new int[i*j];
//        for (int l = s-1; l <i ; l++) {
//            ret[temp++]=arr[l][s-1];
//        }
////        printarray1D(ret);
//
//        for (int l = s; l <j ; l++) {
//            ret[temp++]=arr[arr.length-s][l];
//        }
////        printarray1D(ret);
//
//        for (int l = arr.length-s-1; l >=s-1 ; l--) {
//            ret[temp++]=arr[l][arr.length-s];
//        }
//        printarray1D(ret);
//        for (int l = j-s-1; l >= s-1; l--) {
//            ret[temp++]=arr[s-1][l];
//        }
//        return ret;
        return oneD;
    }
    public static void SaddlePoint(int arr[][]){
        for (int i = 0; i < arr.length; i++) {
            int svj=0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j]<arr[i][svj]){
                    svj=j;
                }
            }
            boolean flag = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][svj]>arr[i][svj]){
                    flag=false;
                    break;
                }
            }
            if (flag == true) {
                System.out.println(arr[i][svj] +" "+i+" "+svj);
                return;
            }
        }
        System.out.println("Invalid");
    }

    public static void solveSudoku(int[][]arr, int i,int j){
        if (i==arr.length){
            printarray2D(arr);
            return;
        }
        int ni=0;
        int nj=0;
        if (j==arr[0].length-1){
            ni=i+1;
            nj=0;
        }
        else {
            ni=i;
            nj=j+1;
        }
        if (arr[i][j]!=0){
            solveSudoku(arr,ni,nj);
        }
        else {
            for (int pos = 1; pos <= 9; pos++) {
                if (isValidSudoku(arr,i,j,pos)){
                    arr[i][j] = pos;
                    solveSudoku(arr,ni,nj);
                    arr[i][j]=0;
                }
            }
        }
    }

    private static boolean isValidSudoku(int[][] arr, int i, int j, int val) {
        for (int k = 0; k < arr.length; k++) {
            if (arr[k][j]==val){
                return false;
            }
        }
        for (int k = 0; k < arr.length; k++) {
            if (arr[i][k]==val){
                return false;
            }
        }
        int sr= (i/3) *3;
        int sc= (j/3) *3;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (arr[sr+k][sc+l]==val){
                    return false;
                }
                
            }
            
        }
        return true;
    }
}

