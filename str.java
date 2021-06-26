package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class str {
    public static void main(String[] args) {
//        System.out.println(compress("aabbssssddde"));
//        char[] chars= {'a','a','a','a','a','a','a','a','a','a','a','a','a','a'};
//        System.out.println(chars.length);
//        System.out.println(compress2(chars));
//        System.out.println(compress(chars));
//        String arr ="754235116";
//        System.out.println(largestOddNumber(arr));
        System.out.println(numberOfRounds("12:00","12:45"));

    }


    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
    public int numJewelsInStones(String jewels, String stones) {
        int count=0;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i =0; i<jewels.length();i++){
            hashMap.put(jewels.charAt(i),hashMap.getOrDefault(jewels.charAt(i),0)+1);
        }
        for (int i = 0; i < stones.length(); i++) {
            if (!hashMap.containsKey(stones.charAt(i)))
                count++;
        }
        return count;

    }
    public static int compress2(char[] chars) {
        char c = chars[0];
        int count=1;
        int ans =0;
        String str =c+"";
        for (int i = 1; i <chars.length ; i++) {
            char prev = chars[i-1];
            char curr = chars[i];
            if (prev==curr){
                count++;
            }
            else {
                str+=count;
                str+=curr;
//                System.out.println(ans);
                ans=ans+1+(int)Math.log(count)+1;
                count=1;
            }
        }
//        System.out.println(str+count);
        return ans+((int)Math.log(count)+1);
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        int count[]= new int[100001];
        for (int i = 0; i < nums.length; i++) {
            if (count[nums[i]]==1){
                lst.add(nums[i]);
            }
            else count[nums[i]]=1;

        }
        return lst;
    }
    public static String compress(char[] chars) {
        String str = new String(chars);
        String res =str.charAt(0)+"";
        int count=1;
        for (int i = 1; i <str.length() ; i++) {
            char prev = str.charAt(i-1);
            char curr = str.charAt(i);
            if (curr==prev){
                count++;
            }
            else {
                res+=count;
                res+=curr;
                count=1;
            }

        }
        res=res+count;
//        System.out.println(res.length());
        return res;
    }
    public static String largestOddNumber(String num) {
        while ((num.charAt(num.length()-1)-'0')%2==0){
            if (num.length()==1){
                return "";
            }
            num=num.substring(0,num.length()-1);
        }
        return num;
    }
    public static int numberOfRounds(String startTime, String finishTime) {
        String str[] = startTime.split(":");
        int starthour= Integer.parseInt(str[0]),startmin=Integer.parseInt(str[1]);
        str = finishTime.split(":");
        int endHour= Integer.parseInt(str[0]),endMin=Integer.parseInt(str[1]);
        int playhour=0;
        if (endHour-starthour<0){
            playhour=(24-starthour)+endHour;
        }
        else{
            playhour = endHour-starthour;
        }
        int play=0;
        System.out.println(starthour+":"+startmin+" "+endHour+":"+endMin);
        for (int i = 0; i < 3&&startmin<endMin+(playhour*60); i++) {
//            System.out.println("here2");

            if (startmin%15==0 && startmin+15<=endMin){
                play++;
                startmin+=15;
            }
            else if(startmin<15) {
                startmin=15;
            }

        }
        if (playhour>0) {
            startmin = 0;
            for (int i = 0; i < 3 && startmin < endMin + (playhour * 60); i++) {
                if (startmin % 15 == 0) {
                    play++;
                    startmin += 15;
                }
            }
        }
        return play;
    }
}
