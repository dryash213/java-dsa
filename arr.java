package DSA;

import java.util.*;

public class arr {
    public static void main(String[] args) {
//        char arr[] = {'a','b'};
//        arr =twoSum(arr,6);
//        System.out.println(arr[0]+" "+arr[1]);
//        Collections.reverse(Arrays.asList(arr));
////        String s = new String(arr);
//        StringBuilder str = new StringBuilder(String.valueOf(arr));
//        String s = new String(str.reverse());
//        arr = s.toCharArray();
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        int arr[][] = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
//        rotate(arr);
        int arr[] ={1,2,3,4,5,6};
////        System.out.println(numSubarrayProductLessThanK(arr,100));
//        System.out.println();
//        rearrange(arr,6);
//        List<Integer> lst =  new ArrayList<>();
//        for(int i :arr){
//            lst.add(i);
//        }
//        System.out.println(lst);
//        for (int i = lst.size()-1; i >=0; i--) {
//            if (isPrime(lst.get(i)))
//                lst.remove(i);
//        }
//        System.out.println(lst);
//        System.out.println(asciiDifference("acdeb"));
        Pemutations("abc");

    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println(nums[i] + nums[j]);
                if (nums[i] + nums[j] == target) {
                    System.out.println(i + " " + j);
                    int[] ints = {i, j};
                    return ints;
                }

            }

        }
        int[] ints = {0, 0};
        return ints;
    }

    //    i
//    abcabcbb
//    j
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0, tempmax = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            j = i;
            while (j < s.length()) {
                if (set.contains(s.charAt(j))) {
                    set.clear();
                    break;
                }
                set.add(s.charAt(j));
                j++;
            }
            if (set.size() > max) {
                max = set.size();
            }
//            if (set.contains(s.charAt(i))) {
//                set.clear();
//                i = s.indexOf(s.charAt(0))+1;
//                tempmax=0;
//            }
//                set.add(s.charAt(i));
//                tempmax += 1;
//            if (max<tempmax){
//                max=tempmax;
//            }
//            System.out.println(set);
//        }
        }
        return max;
    }

    //       i
//    [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]
//     j
    public static int maxConsecutiveOne(int[] arr) {
        if (arr.length == 0) return 0;
        int ans = 0;
        int left = -1;
        int right = 0;
        int lastZeroIdx = -1; // initially -1 is important remember that

        int result = 0;
//        while (right<arr.length){
//            if (arr[right]==0){
//                result=0;
//            }
//            else {
//                result++;
//            }
//            ans = Math.max(result,ans);
//        }
//        return ans;


        while (right != arr.length) {
            if (arr[right] == 0) {
                left = right;
            }
            result = Math.max(result, right - left);  //both right and left included in window
            System.out.println(result);
            right++;
        }
        return result;

    }

    public int longestOnes(int[] A, int K) {
        Queue<Integer> que = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        int ans = 0;


        while (i != A.length) {
            if (A[i] == 0) {
                que.add(i);
            }
            if (que.size() == K + 1) {
                j = que.remove() + 1;
            }
            ans = Math.max(i - j + 1, ans);
            i++;
        }
        return ans;
    }
    public int maxPower(String s) {
        TreeMap<Character,Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            treeMap.put(s.charAt(i),treeMap.getOrDefault(s.charAt(i),0)+1);
        }
        int max=0;
        for(Map.Entry<Character,Integer> e : treeMap.entrySet()){
            if (e.getValue()>max)
                max=e.getValue();
        }
        System.out.println(treeMap);
        return max;
    }
//    l
//    ABAA
//    AABABBA
//    r
    public int characterReplacement(String s, int k) {
        char[] char_count= new char[26];
        int ans=0,sum=0,start=0;
        int count=0;
        for(int end=0; end<s.length();end++){
            char_count[s.charAt(end)-'A']++;
            count = char_count[s.charAt(end)-'A'];
            sum = Math.max(count,sum);
            while (end-start-sum+1 > k){
                char_count[s.charAt(start)-'A']--;
                start+=1;
            }
            ans = Math.max(ans,end-start+1);

        }
        return ans;
    }

    public String encode(String longUrl) {
        StringBuilder sb = new StringBuilder(longUrl);
        for (int i = 0; i < longUrl.length(); i++) {
            char temp = (char) (sb.charAt(i)%longUrl.length());
            sb.setCharAt(i,temp);
        }
        return String.valueOf(sb);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        StringBuilder sb = new StringBuilder(shortUrl);
        for (int i = 0; i < shortUrl.length(); i++) {
            char temp = (char) (sb.charAt(i)%shortUrl.length());
            sb.setCharAt(i,temp);
        }
        return String.valueOf(sb);
    }

    public int[] productExceptSelf(int[] arr) {
        int sum =1;
        int containszero=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=0)
                sum*=arr[i];
            else{
                containszero++;
            }
        }
        if (containszero>1) {
            Arrays.fill(arr, 0);
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0){
                Arrays.fill(arr, 0);
                arr[i]=sum;
            }
            else {
                arr[i]=sum/arr[i];
            }

        }
        return arr;
    }
    public static int maxProduct(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//
//        }
        int n =nums.length;
        int sum=1;
        int ans=Integer.MIN_VALUE;

        int prodl[]=new int[nums.length];
        int prodr[]=new int[nums.length];
        for (int i = 0; i < prodl.length; i++) {
            sum*=nums[i];
            prodl[i]=sum;
            if (sum==0){
                sum=1;
//                continue;
            }
        }
//        System.out.println(n);
//        for (int i = 0; i < prodl.length; i++) {
//            System.out.println(prodl[i]);
//        }
        sum=1;
        for (int i = prodr.length-1;i>=0 ;i--) {
            sum*=nums[i];
            prodr[i]= sum;
            if (sum==0){
                sum=1;
//                continue;
            }
        }
        for (int i = 0; i < prodl.length; i++) {
            if (prodl[i]>ans)
                ans=prodl[i];
            if (prodr[i]>ans)
                ans=prodr[i];
//            System.out.println(prodl[i]);
//            System.out.println(prodr[n-1-i]);
        }

//        int csum=1,
//
//        for (int i = 0; i <nums.length ; i++) {
//            if (nums[i]!=0){
//                csum*=nums[i];
//            }
//            if (ans<csum)
//                ans=csum;
//        }
        return ans;

    }
    /*
IMPORTANT
Sliding Window
*/
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int prod = 1;
        int start = 0, end = 0;
        int ans = 0;
        while (end < nums.length) {
            prod *= nums[end];
            System.out.println(prod);
            while (prod >= k) {
                prod = prod / nums[start];
                start++;
            }
            ans += end - start + 1;
            System.out.println(ans);
            end++;
        }
        return ans;
    }
//    { 10, 5, 2, 7, 1, 9 }
    public static int numSubarraysumequalK(int[] nums, int k) {
        int start=0,end=0,ans=0,sum=0;
        while (end < nums.length) {
            sum+=nums[end];
            while (sum>k){
                sum-=nums[start];
                start++;
            }
            if (sum==k)
                ans=Math.max(ans,end-start+1);
            end++;
        }
        return ans;
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j < arr.length; j++) {
//
//
//            }
//
//        }
        // Your code here
        int start =0,end=0;
        int ans=0;
        while (end<arr.length){

            while (ans>s){
                ans-=arr[start];
                start++;
            }

            System.out.println(ans);
            if (ans==s){
                ArrayList<Integer> lst = new ArrayList<>();
                lst.add(start+1);
                lst.add(end);
                return lst;
            }
//            if (ans<s)
            ans+=arr[end];
            end++;

        }
        return new ArrayList<>();
    }

    public static int countTriplet(int arr[], int n) {
        // Your code goes here
//        Arrays.sort(arr);
        int count=0;
        Set<Integer> set = new HashSet<>();
        for(int i: arr){
            set.add(i);
        }
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (set.contains(arr[i]+arr[j])){
                    count++;
                }
            }

        }
        return count;
    }

    public static int maxSubarraySum(int arr[], int n){

        // Your code here
        int sum=0,maxsum=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
            if (maxsum<sum){
                maxsum=sum;
            }
            if (sum<0){
                sum=0;
            }
        }
        return maxsum;

    }

    int MissingNumber(int array[], int n) {
        // Your Code Here
        int sum=(n*(n-1))/2;
        for (int i = 0; i < n; i++) {
            sum-=array[i];
        }
        return sum;
    }

    public static void merge(long arr1[], long arr2[], int n, int m) {
        // code here
        int idx1=n-1;
        int idx2=0;
        // System.out.println(arr1[idx1]);
        while ( idx1>=0 && idx2<m && arr1[idx1]>=arr2[idx2]){
            long temp = arr1[idx1];
            arr1[idx1]= arr2[idx2];
            arr2[idx2] = temp;
            idx1--;
            idx2++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

    }

    /*
    IMPORTANT
    Dividend = Questient * Divisor + Remainder
               new val               old val
    Dividend /Divisor = Questient
    dividend % Divisor = Remainder
    Max= arr[n-1]+1;
    index%2==0 arr[i] = (arr[MaxIdx]% Max)*Max +arr[i]
    index%2!=0 arr[i] = (arr[MinIdx]% Max)*Max +arr[i]

    * */
    public static void rearrange(int arr[], int n){

        // Your code here
        int minidx=0,maxidx=n-1;
        int Max=arr[n-1]+1;
        for (int i = 0; i < n; i++) {
            if (i%2==0){
                arr[i] = (arr[maxidx]% Max)*Max +arr[i];
                maxidx--;
            }
            else {
                arr[i] = (arr[minidx]% Max)*Max +arr[i];
                minidx++;
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i]/=Max;
            System.out.println(arr[i]);
        }

    }

    public static long countPairs(int x[], int y[], int M, int N){
        // your code here
        long count=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Math.pow(x[i],y[j])>Math.pow(x[j],y[i])){
                    count++;
                }
            }

        }
        return count;

    }

    public static boolean isPrime(int n){
        if (n==0||n==1)
            return false;
        for (int i = 2; i <= n/2; i++) {
            if (n%i==0)
                return false;
        }
        return true;
    }

    public static String ToggleCase(String str){
        StringBuilder s = new StringBuilder(str);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z'){
                char uch=(char)(ch-32);
                s.setCharAt(i,uch);
            }
            else if(ch>='A' && ch<='Z'){
                char lch=(char)(ch+32);
                s.setCharAt(i,lch);
            }

        }
        return s.toString();
    }

    public static String asciiDifference(String str){
        StringBuilder s = new StringBuilder(str);
        StringBuilder ans = new StringBuilder("");
        int diff=0;
        ans.append(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char prev = s.charAt(i-1);
            char next = s.charAt(i);
            diff = Math.abs((prev-next));
            ans.append(diff);
            ans.append(next);
        }
//        ans.append(diff);
        return ans.toString();
    }

    public static int factorial(int n){
        int fact=1;
        for (int i = 1; i <= n; i++) {
            fact*=i;

        }
        return fact;
    }

    /*
    IMPORTANT
    */
    public static void Pemutations(String str){
        int n = str.length();
        int fact = factorial(n);
        for (int i = 0; i < fact; i++) {
            StringBuilder sb = new StringBuilder(str);
            int temp =i;
            for (int j = n; j >=1 ; j--) {
                int q = temp/n;
                int r = temp%n;
                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);

                temp=q;
            }

            System.out.println();
        }

    }

    public int logestSubString(String str){
        int arr[] = new int[128];
        int start =0;
        int end =0;
        int ans =0;
        for (int i = 0; i < str.length(); i++) {
            char c= str.charAt(i);
            if (arr[c]==0){
                arr[c]++;
                ans= Math.max(ans,i-end+1);
            }
            else {
                while (arr[c]!=0){
                    arr[str.charAt(end)]=0;
                    end++;
                }
                arr[c]=1;
                ans= Math.max(ans,i-end+1);
            }

        }
        return ans;
    }
    public int[][] merge(int[][] intervals) {
        {
            List<int[]> ls = new ArrayList<>();

            if (intervals.length==0||intervals==null)
                return ls.toArray(new int[0][]);

            Arrays.sort(intervals,(a,b)->a[0]-b[0]);

            int start = intervals[0][0];
            int end = intervals[0][1];

            for (int[]i : intervals){
                if (i[0]<=end){
                    end=Math.max(end,i[1]);
                }
                else {
                    ls.add(new int[]{start,end});
                    start=i[0];
                    end=i[1];
                }
            }
            ls.add(new int[]{start,end});
            return ls.toArray(new int[0][]);
        }
    }
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n=0;
        for(int i:nums){
            pq.add(i);
            if (pq.size()>3){
                n=pq.remove();
            }
        }
        if(pq.size()<3){
            while(pq.size()>1)
                pq.poll();
        }
        return pq.peek();
//        return pq.remove();
    }



//    public int[] sortByBits(int[] arr) {
//        for(int i:arr){
//
//        }
//    }

}
