package DSA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graphs {
    static class Edge{
        int src;
        int nbr;
        int wt;
        Edge(int src,int nbr,int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
/*
*
* Sample input
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2
*
* */

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vrtcs = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph=new ArrayList[vrtcs];
        for (int i = 0; i < vrtcs; i++) {
            graph[i] = new ArrayList<>();
        }
        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String parts[] = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }
//        BFS IS CYCLIC Graph includes is connected
//        boolean visited[] = new boolean[vrtcs];
//        for(int v=0;v<vrtcs;v++){
//            if(visited[v]==false){
////              traverse
//                boolean cycle = CyclicGraph(graph,v,visited);
//                if(cycle){
//                    System.out.println(true);
//                    return;
//                }
//            }
//        }
//        System.out.println(false);


        int src = Integer.parseInt(br.readLine());

//        DIJKHETRA
        Dijkstra(graph,src);

//        int des = Integer.parseInt(br.readLine());
//        boolean visited[] =  new boolean[vrtcs];
//        boolean ispath = haspath(graph,src,des,vis);
//        printPath(graph,src,des,vis,src+"");



// ***************************************************************************



//        GetConnected
//        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
//        for (int v = 0; v <vrtcs ; v++) {
//              if (visited[v]==false){
//                  ArrayList<Integer> comp = new ArrayList<>();
//                  GetConnected(graph,v,comp,visited);
//                  comps.add(comp);
//              }
////        }
//        System.out.println(comps);
////        Is grapgh connected means comps.length==1
//        ==================================================================
//        System.out.println(comps.size()==1);

//        ------------------------------------------------------------------
//        Get all Pairs in the GetConnected
//        int pairs = 0;
//        for (int i = 0; i < comps.size(); i++) {
//            for (int j = i+1; j < comps.size(); j++) {
//                int count = comps.get(i).size()*comps.get(j).size();
//                pairs+=count;
//            }
//        }
//        System.out.println(pairs);

//        /////////////////////////////////////////////////////////////////
//        HashSet<Integer> visited = new HashSet<>();
//        Hamiltonoiian_Path(graph,src,visited,""+src,src);
//
//        BFS(graph,src,vrtcs);

//        *-----BIPARTED----*
//        int visited[] = new int[vrtcs];
//        Arrays.fill(visited,-1);
//        for(int v=0;v<vrtcs;v++){
//            if(visited[v]==-1){
////              traverse
//                boolean isbipartide = checkBipartide(graph,v,visited);
//                if(isbipartide==false){
//                    System.out.println(false);
//                    return;
//                }
//            }
//        }
//        System.out.println(true);
    }

    private static void printPath(ArrayList<Edge>[] graph, int src, int des, boolean[] visited, String s) {
        if (src==des){
            System.out.println(s);
            return;
        }
        visited[src]=true;
        for (Edge e:graph[src]) {
            if (visited[e.nbr]==false){
                printPath(graph,e.nbr,des,visited,s+e.nbr);
            }
        }
        visited[src]=false;

    }

    public static boolean haspath(ArrayList<Edge>[] graph,int src,int des,boolean[] visited){
        if (src==des){
            return true;
        }
        visited[src]=true;
        for (Edge e:graph[src]) {
            if (visited[e.nbr]==false){
                if(haspath(graph,e.nbr,des,visited))
                    return true;
            }
        }
        return false;
    }

    public static void GetConnected(ArrayList<Edge>[] Graph, int src, ArrayList<Integer> comp, boolean[] visited){
        visited[src]= true;
        comp.add(src);
        for (Edge e:Graph[src]){
            if (visited[e.nbr]==false){
                GetConnected(Graph,e.nbr,comp,visited);
            }

        }

    }

    public static void dfs(int [][] graph,int source,int target,
                           List<Integer>comp,List<List<Integer>> lst){
        if (source==target){
            lst.add(new ArrayList<>(comp));
            return;
        }
        for(int child:graph[source]){
            comp.add(child);
            dfs(graph, child, target, comp, lst);
            comp.remove(comp.size()-1);
        }
    }

//    public static void NumberOfComponent()

    public int numIslands(char[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int count =0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='0' && !vis[i][j]){
//                    vis[i][j]=true;
                    DFSspecial(grid,i,j,vis);
                    count++;
                }

            }

        }
        return count;
    }

    private void DFSspecial(char[][] grid, int i, int j, boolean[][] vis) {
        if (i<0||j<0||i==grid.length||j==grid[0].length||vis[i][j]||grid[i][j]=='1')
            return;
        vis[i][j]=true;
        DFSspecial(grid, i+1, j, vis);
        DFSspecial(grid, i-1, j, vis);
        DFSspecial(grid, i, j-1, vis);
        DFSspecial(grid, i, j+1, vis);
    }

//    Important Hamiltonoiian Path
    public static void Hamiltonoiian_Path(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited,String psf,int orgsrc){
        if (visited.size()==graph.length-1){
            System.out.print(psf);
            boolean closingEgdeFound = false;
            for (Edge e:graph[src]){
                if (e.nbr==orgsrc){
                    closingEgdeFound = true;
                    break;
                }
            }
            if (closingEgdeFound){
                System.out.print(" it is a cycle");
            }

            else {
                System.out.println(" Not a cycle");
            }
            System.out.println();
        }
        visited.add(src);
        for(Edge e :graph[src]){
            if (visited.contains(e.nbr)==false){
                Hamiltonoiian_Path(graph, e.nbr, visited, psf+e.nbr, orgsrc);
            }
        }
        visited.remove(src);
    }

//    --------------************************************--------------------------------------
//    BFS Important
//    Remove Mark* Print/Work Add*  * means to break the program at that step.
//    static class Pair{
//        int v; String psf;
//        Pair(int v,String psf){
//            this.v = v;
//            this.psf =psf;
//        }
//}
//    public static void BFS(ArrayList<Edge>[] graph, int src,int vrtces){
//        ArrayDeque<Pair> queue = new ArrayDeque<>();
//        boolean vis[] = new boolean[vrtces];
//        queue.add(new Pair(src,src + ""));
//        while (queue.size()>0){
//            Pair rem = queue.remove();
//            if (vis[rem.v]==true){
//                continue;
//            }
//            vis[rem.v] = true;
//            System.out.println(rem.v+"@"+rem.psf);
//            for (Edge e:graph[rem.v]){
//                if (vis[e.nbr]==false){
//                    queue.add(new Pair(e.nbr, rem.psf+e.nbr));
//                }
//            }
//        }
//    }
//    ------------------------------*----------------------------------------------

//    public static boolean CyclicGraph(ArrayList<Edge>[] graph,int src,boolean visited[]){
//        ArrayDeque<Pair> q = new ArrayDeque<>();
//        q.add(new Pair(src ,src+""));
//
//        while(q.size()>0){
//            Pair rem = q.removeFirst();
//            if(visited[rem.v])
//                return true;
//            visited[rem.v] = true;
//            for(Edge e : graph[rem.v]){
//                if(visited[e.nbr]==false){
//                    q.add(new Pair(e.nbr, rem.psf+e.nbr));
//                }
//            }
//        }
//        return false;
//    }

//---------------------------------------------------------------------------------------------------------


    /*
    Biquardite Important
    if it is possible to divide vertices int o 2 mutually exclusive
    & echaustive sets such that  all edges are across sets
    0---------3
    |         |
    |         |
    1---------4

    {0,2} {1,3} ---- true
    Acyclic-----true
    cycle with even size----true
    cycle with odd size-----false

    * */
//    public static class Pair{
//        int v;
//        String psf;
//        int level;
//        Pair(int v,String psf,int level){
//            this.v = v;
//            this.psf = psf;
//            this.level = level;
//        }
//    }
//
//    public static boolean checkBipartide(ArrayList<Edge>[] graph,int src,int[] visited){
//        ArrayDeque<Pair> q = new ArrayDeque<>();
//        q.add(new Pair(src,src+"",0));
//        while(q.size()>0){
//            Pair rem = q.removeFirst();
//            if(visited[rem.v] != -1){
////
//                if(rem.level!=visited[rem.v])
//                    return false;
//            }
//            else{
//                visited[rem.v] = rem.level;
//            }
//            for(Edge e: graph[rem.v]){
//                if(visited[e.nbr]==-1){
//                    q.add(new Pair(e.nbr,rem.psf+e.nbr,rem.level+1));
//                }
//            }
//        }
//        return true;
//
//    }
//    ----------------------------------------------------------------------------------------------------

//    static class Pair {
//        int v;
//        int time;
//        Pair(int v, int time){
//            this.v= v;
//            this.time = time;
//        }
//    }
//    public static void Spread(ArrayList<Edge>[] graph,int src,int t){
//        ArrayDeque<Pair> q = new ArrayDeque<>();
//        q.add(new Pair(src,1));
//        int visited[] = new int[graph.length];
//        int count =0;
//        while (q.size()>0){
//            Pair rem = q.removeFirst();
//            if (rem.v>0)
//                continue;
//            else {
//                 visited[rem.v] = rem.time;
//            }
//            if (rem.time>t)
//                break;
//            for (Edge e: graph[rem.v]){
//                if (visited[e.nbr]==0){
//                    q.add(new Pair(e.nbr,rem.time+1));
//                }
//            }
//        }
//        System.out.println(count);
//    }

//    Dijkstra Algorithm
//    Same as bfs only with priority Queue.
    public static class Pair{
        int v;
        int wsf;
        String psf;
        Pair(int v,String psf,int wsf){
            this.v=v;
            this.psf=psf;
            this.wsf = wsf;
        }

}
    public static void Dijkstra(ArrayList<Edge>[] graph,int src){

        boolean[] visited= new boolean[graph.length];
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) ->a.wsf-b.wsf);
        q.add(new Pair(src,src +"",0));
        while (q.size()>0){
            Pair rem =q.remove();
            if (visited[rem.v]==true)
                continue;
            visited[rem.v]=true;
            System.out.println(rem.v+" via "+rem.psf+"@ "+rem.psf);

            for (Edge e:graph[rem.v]){
                if (visited[e.nbr]==false){
                    q.add(new Pair(e.nbr,rem.psf+e.nbr,rem.wsf+e.wt));
                }
            }

        }
    }
}
