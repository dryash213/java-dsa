package DSA;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class hash {
    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
//        int n= br.read();
//        System.out.println(n);
//        char []ar = new char[5];
//        br.read(ar,0,ar.length);
//        for (int i = 0; i < ar.length; i++) {
//            System.out.println(ar[i]);
//        }
        String name="";
        while(!name.equals("stop")){
            System.out.println("Enter data: ");
            name=br.readLine();
            System.out.println("data is: "+name);
        }
        br.close();
        r.close();
    }
    static class Pair{
        int li;
        int di;
         int val;
         Pair(int li ,int di,int val){
             this.li=li;
             this.di=di;
             this.val=val;
         }
    }
    public static ArrayList MeregeKSortedList(ArrayList<ArrayList<Integer>> lst){
        ArrayList<Integer> ret = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for (int i = 0; i <lst.size(); i++) {
            Pair p  = new Pair(i,0,lst.get(i).get(0));
            pq.add(p);
        }
        while (pq.size()>0){
            Pair p = pq.remove();
            ret.add(p.val);
            if (p.di<lst.get(p.li).size()){
                p.di++;
                pq.add(p);
            }
        }

        return ret;
    }
}
