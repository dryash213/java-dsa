package DSA;

import java.util.Arrays;
import java.util.List;

public class GFG_ARR {
    static int arr[];
    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 3};
//        RearrangeSumLessThanK(arr,3);
        String str ="012";
        System.out.println(Integer.parseInt(str));
//        int arr[] = {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
//        RearrangeZEROS2(arr);

    }

//    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
//
////        int w1=0,w2=0,target=0;
////        for (int i = 0; i < firstWord.length(); i++) {
////            w1=w1*10+firstWord.charAt(i)-97;
////        }
//    }

    static void leftRotate(int arr[], int d)
    {

        if (d == 0)
            return;

        int n = arr.length;
        // in case the rotating factor is
        // greater than array length
        d = d % n;
        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, n - 1);
        reverseArray(arr, 0, n - 1);
    }

    static void rightRotate(int arr[], int d, int n)
    {
        reverseArray(arr, 0, n - 1);
        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, n - 1);
    }



    /*Function to reverse arr[] from index start to end*/
    static void reverseArray(int arr[], int start, int end)
    {
        int temp;
        while (start<end){
            temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;

        }
    }

//    Rotation multiple times
// Function to left rotate
// an array k times
    static void leftRotate(int arr[],
                           int n, int k)
    {
        // Print array after
        // k rotations
        for (int i = k; i < k + n; i++)
            System.out.print(arr[i % n] + " ");
    }

        // Driver Code
//        public static void main (String[] args)
//        {
//            int arr[] = {1, 3, 5, 7, 9};
//            int n = arr.length;
//
//            int k = 2;
//            leftRotate(arr, n, k);
//            System.out.println();
//
//            k = 3;
//            leftRotate(arr, n, k);
//            System.out.println();
//
//            k = 4;
//            leftRotate(arr, n, k);
//            System.out.println();
//        }




    /*
    *
    * Let arr = [A0, A1, A2, A3]

    R0 = 0*A0 + 1*A1 + 2*A2 + 3*A3
    R1 = 0*A3 + 1*A0 + 2*A1 + 3*A2

    R1 - R0 = A0 + (2*A1 - 1*A1) + (3*A2 - 2*A2) - 3*A3
    = A0 + A1 + A2 - 3*A3 -> This has missing A3 in arrSum
    = A0 + A1 + A2 + (A3 - A3) - 3*A3 -> Adding Subtracting A3
    = A0 + A1 + A2 + A3 - 4*A3
    = arrSum - n*arr[n-j]
    * */
    public static int maxSumRotation(int arr[]){
        // Find array sum and i*arr[i] with no rotation
        int arrSum = 0;  // Stores sum of arr[i]
        int currVal = 0;  // Stores sum of i*arr[i]
        for (int i=0; i<arr.length; i++)
        {
            arrSum = arrSum + arr[i];
            currVal = currVal+(i*arr[i]);
        }

        // Initialize result as 0 rotation sum
        int maxVal = currVal;

        // Try all rotations one by one and find
        // the maximum rotation sum.
        for (int j=1; j<arr.length; j++)
        {
            currVal = currVal + arrSum-arr.length*arr[arr.length-j];
            if (currVal > maxVal)
                maxVal = currVal;
        }

        // Return result
        return maxVal;
    }


    public static void RearangeAiEqulasi(int arr[]){
        int i=0;
        while (i<arr.length){
            if (arr[i]>0 && arr[i]!=i ){
                int temp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] =temp;
            }
            else {
                i++;
            }
        }
    }


    public static int[] rightRotateby1(int arr[],int from,int to){
        int temp=arr[arr.length-1];
        for (int i =1; i <arr.length-1 ; i++) {
            arr[i]=arr[i-1];
        }
        arr[0]=temp;
        return (arr);
    }
//    odd-positive
//    even-negative
    public static void RearrangePOSNEGAlternateOrderMaintained(int arr[]){
        int ErrorIndex=-1;
        for (int i = 0; i < arr.length; i++) {
            if (ErrorIndex!=-1){
                if ((arr[ErrorIndex]>=0 && arr[i]<0 )||(arr[ErrorIndex]<0 && arr[i]>=0)){
                    arr = rightRotateby1(arr,ErrorIndex,i);
                }
                if (i-ErrorIndex>=2){
                    ErrorIndex+=2;
                }
                else {
                    ErrorIndex=-1;
                }
            }
            else if ((arr[i]<0&&i%2==1) || (arr[i]>0&& i%2==0)){
                ErrorIndex=i;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void RearrangePOSNEGAlternateNoOrder(int arr[]) {
        int i=-1;
        int temp;
        for (int j = 0; j < arr.length; j++) {
//            Shift all nonzero Forward
            if (arr[j]<0){
                i++;
                temp = arr[i];
                arr[i] =arr[j];
                arr[j]=temp;
            }
        }


        int pos=i+1,neg=0;
//        Arrays.sort(arr);
        while (pos<arr.length && neg<pos){
            temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] =temp;
            pos++;
            neg+=2;
        }
    }

    public static void RearrangeZEROS(int arr[]) {
        int i=-1;
        for (int j = 0; j <arr.length ; j++) {
            if (arr[j]==0){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]= temp;
            }
        }
        /**
         *
         * int end=arr.length-1,start=0;
         *         while (start<end){
         *             while (arr[start]==0){
         *                 int temp = arr[start];
         *                 arr[start]= arr[end];
         *                 arr[end]= temp;
         *                 end--;
         *             }
         *             start++;
         *         }
         */

        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
    }

    public static void RearrangeZEROS2(int arr[]) {
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=0){
                int temp = arr[count];
                arr[count]=arr[i];
                arr[i] =temp;
                count++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
    }

    public static void RearrangeSumLessThanK(int arr[],int k){
        int start =0,end=0;
        int swap=0;

        while (end<arr.length){
            if (arr[end]<=k){
                int temp = arr[end];
                arr[end]=arr[start];
                arr[start] =temp;
                start++;
                if (arr[start]!=arr[end])
                    swap++;
            }
            end++;
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }
        System.out.println(swap);
    }

    public static void RearangePOSNEG(int arr[]){
//        all negative before positive while maintaing the order
        int pos =0,neg=0;

    }

    }
