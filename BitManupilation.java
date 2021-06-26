package DSA;

import java.util.*;

public class BitManupilation {
    public static void main(String[] args) {
//        GreyCodeCall(3);
//        int n=5;
//        int ans = 0;
//        System.out.println(Integer.toBinaryString(n));
//        for (int i = 0; i < 32; i++) {
//            System.out.println("Answer= "+Integer.toBinaryString(ans)+" "+i);
//            ans <<= 1;
//            System.out.println("Answer= "+Integer.toBinaryString(ans)+" "+i);
//
//            ans =ans |(n & 1);
//            System.out.println("Answer= "+Integer.toBinaryString(ans)+" "+i);
//
//            n >>= 1;
//            System.out.println("n= "+Integer.toBinaryString(n)+" "+i);
//        }
//        System.out.println(ans);
//        System.out.println(Integer.toBinaryString(ans).length());
        int arr[] ={1,2,3,4,5,5};
//        System.out.println(Integer.highestOneBit(4));
        int a =~5;
        System.out.println(a);


//        findDuplicateinSum1toN(arr);
    }

    public static void RightMostSetBit(int n){
//      -n ==2's Complement
        int rightmostsetbitmask= n & -n;
        System.out.println(Integer.toBinaryString(rightmostsetbitmask));
    }
    public static void CountNumberofSetBit(int n){
//      -n ==2's Complement
        int counter=0;
        while (n!=0){
            int temp = n & -n;
            n-=temp;
            counter++;
        }
        System.out.println(counter);
    }
    public static void JOSEPHESPROBLEM(int n){
//        For n==1;
        int i=1;
        while (i*2<=n){
            i*=2;
        }
        int l =n-i;
        System.out.println(2*l+1);
    }
    public static ArrayList<String> GreyCode(int n){
        if (n==1){
            ArrayList<String> str = new ArrayList<>();
            str.add("0");
            str.add("1");
            return str;
        }
        ArrayList<String> lst = GreyCode(n-1);
        ArrayList<String> st = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            String temp =lst.get(i);
            st.add("0"+temp);
        }
        for (int i = lst.size()-1; i >= 0; i--) {
            String temp =lst.get(i);
            st.add("1"+temp);
        }
        return st;


    }
    public static void GreyCodeCall(int n){
        ArrayList<String> lst =  GreyCode(n);
//        for(String i: lst){
//
//            for (int j = 0; j < i.length(); j++) {
//                System.out.print(i.charAt(j)+" ");
//
//            }
//            System.out.println();
//        }

        for (int i = 0; i < lst.size(); i++) {
            lst.set(i, String.valueOf(Integer.parseInt(lst.get(i))));
        }
        System.out.println(lst);
    }

    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> p) {

        HashMap<String, Integer> smap = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) {
            smap.put(req_skills[i], i);
        }



        int np = p.size();
        int[] people = new int[np];
        for (int i = 0; i < np; i++) {
            int personSkills = p.get(i).size();
            for (int j = 0; j < personSkills; j++) {
                String skill = p.get(i).get(j);
                int snum = smap.get(skill);
                people[i] = people[i] | (1 << snum);
            }
        }
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }

        solution(people, req_skills.length, 0, new ArrayList<>(), 0);
        int[] arr =new int[sol.size()];
        for (int i = 0; i < sol.size(); i++) {
            arr[i]=sol.get(i);
        }
        sol.clear();
        return arr;
    }

    static ArrayList<Integer> sol = new ArrayList<>();
    public static void solution(int[] people, int nskills , int current_preson, ArrayList<Object> onesol, int smask) {

        if (current_preson==people.length){
            if (smask==(1<<nskills)-1){
                if (sol.size()==0||onesol.size()<sol.size()){
                    sol = new ArrayList(onesol);
                }
            }
            return;
        }

        solution(people, nskills, current_preson+1, onesol, smask);

        onesol.add(current_preson);
        solution(people, nskills, current_preson+1, onesol, (smask|people[current_preson]));
        onesol.remove(onesol.size()-1);
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        HashMap<Character,ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i <26; i++) {
            hashMap.put((char)('a'+i),new ArrayList<>());
        }
        for(String word:words){
            int mask=0;
            for (char ch:word.toCharArray()){
                int bit=ch-'a';
                mask = mask|(1<<bit);
            }

            HashSet<Character> unique =  new HashSet<>();
            for (char ch:word.toCharArray()){
                if (unique.contains(ch)){
                    continue;
                }
                unique.add(ch);
                hashMap.get(ch).add(mask);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(String puzzle:puzzles){
            int pmask=0;
            for (char ch:puzzle.toCharArray()){
                int bit=ch-'a';
                pmask = pmask|(1<<bit);
            }
            char fch = puzzle.charAt(0);
            ArrayList<Integer> wordsToCheck = hashMap.get(fch);
            int count=0;
            for (int wmask:wordsToCheck){
                if ((wmask & pmask)==wmask){
                    count++;
                }
            }
            res.add(count);
        }
        return res;
//        Integer.parseInt(Integer.toBinaryString(ans));
    }

    public static void FindNonDuplicate(int arr[]){
        int xor=0;
        for(int i:arr){
            xor^=i;
        }
        int rmsb = xor & -xor;
        int x=0;
        int y=0;
        for(int val:arr){
            if ((val & rmsb)==0){
                x=x^val;
            }
            else {
                y=y^val;
            }
        }
        System.out.println(x+" "+y);
//        xor contais the xor of non duplicate element.
    }
    public static void findDuplicateinSum1toN(int arr[]){
        int xor=0;
        for(int i:arr){
            xor^=i;
        }
        for(int i=1;i<arr.length;i++){
            xor^=i;
        }
        int rmsb = xor & -xor;
        int x=0;
        int y=0;
        for(int val:arr){
            if ((val & rmsb)==0){
                x=x^val;
            }
            else {
                y=y^val;
            }
        }
        System.out.println(x+" "+y);
    }

    public int findComplement(int num) {
        int i=0;
        int j=0;
        while (j<num){
            j+=Math.pow(2,i);
            i++;
        }
        return j-num;
    }
//    IMPORTANT
    public static void ReduceTo1inMinSteps(int n){
        int res=0;
        while(n!=1){
            if (n%2==0){
                n=n/2;
            }
            else if(n==3){
                res=2;
                break;
            }
            else if((n&3)==1){
                n=n-1;
            }
            else if((n&3)==3){
                n = n+1;
            }
            res++;
        }
        System.out.println(res);
    }


}

