package DSA;
import java.io.*;
import java.util.*;
//package practiceExercise;
class Test
{
    private static void printSorted(int[] arr, int start,
                                    int end) {
        arr[start] = 0;
        arr[end] = 0;
//        if(start > end)
//            return;
//
//        // print left subtree
//        printSorted(arr, start*2 + 1, end);
//
//        // print root
//        System.out.print(arr[start] + " ");
//
//        // print right subtree
//        printSorted(arr, start*2 + 2, end);
        int x =123;
        System.out.println(Integer.valueOf(String.valueOf((new StringBuilder(String.valueOf(x)).reverse()))));
    }

    // driver program to test above function
    public static void main(String[] args) {
        int arr[] = {1,4,3,2};
        int x=2;
        for (int i = 0; i < arr.length; i++) {
            arr[i] =  arr[i]&x;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 
        }

        printSorted(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}