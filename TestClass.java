package DSA;

import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr_A = br.readLine().split(" ");
        int[] A = new int[N];
        for(int i_A = 0; i_A < arr_A.length; i_A++)
        {
            A[i_A] = Integer.parseInt(arr_A[i_A]);
        }

        long out_ = maximumCoins(N, A);
        System.out.println(out_);

        wr.close();
        br.close();
    }
    static long maximumCoins(int N, int[] arr){

        // Write your code here
        long result = 0;
        int i=0;
        while (arr[i]!=0){
            arr[i]--;
            result++;
            i=((i%N)+1);
            if(i>=N){
                i=0;
            }
            for (int j = 0; j < N; j++) {
                System.out.print(arr[j]+" ");
            }
            System.out.println();
        }
        for (int j = 0; j < N; j++) {
            System.out.println(arr[i]);
        }
        return result;

    }
}
