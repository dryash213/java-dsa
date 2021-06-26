package DSA;


import java.util.*;

public class GenericTree {
    public static class GenericTreeIterator implements Iterable<Integer>{
        Node root;
        GenericTreeIterator(Node root){
            this.root=root;
        }
        public Iterator<Integer> iterator(){
            Iterator<Integer> obj =new GTPreOrderIterator(root);
            return obj;
        }
    }

    public static class GTPreOrderIterator implements Iterator<Integer>{
        Integer nval;
//        int initializes to zero,Int initializes with null

        Stack<Pair> st;

        GTPreOrderIterator(Node root){
            st = new Stack<>();
            st.push(new Pair(root,-1));
            next();

        }

        public boolean hasNext() {
            if (nval==null)
                return false;
            else {
                return true;
            }
        }

        @Override

        public Integer next() {
            Integer toRetur = nval;
//            Moves next value forward
            nval=null;
            while (st.size()>0){
                Pair top = st.peek();
                if (top.state==-1){
//                    nval = top.node.data;
                    top.state++;
//                    break;
                }
                else if(top.state==top.node.children.size()){
//                  nval = top.node.data;
//                    Post order
                    nval = top.node.data;
                    st.pop();
                    break;
                }
                else {
                    Pair cp = new Pair(top.node.children.get(top.state),-1);
                    st.push(cp);
                    top.state++;
                }
            }

            return toRetur;
        }
    }
    private static class Pair{
        Node node;
        int state;
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void IterativePreandfPostOrder(Node node){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node,-1));
        String pre ="";
        String post ="";

        while (st.size()>0){
            Pair top = st.peek();
            if (top.state==-1){
                pre+=top.node.data+" ";
                top.state++;
            }
            else if(top.state==top.node.children.size()){
                post+=top.node.data+" ";
                st.pop();
            }
            else {
                Pair cp = new Pair(top.node.children.get(top.state),-1);
                st.push(cp);
                top.state++;
            }
        }
        System.out.println(pre);
        System.out.println(post);
    }
    private static class Node{
        int data;
        ArrayList <Node> children = new ArrayList<>();
    }
    public static int size(Node node){
        int s =0;
        for (Node child : node.children){
            s+=size(child);
        }
        s+=1;
        return s;
    }
    public static int Max(Node node){
        int max = Integer.MIN_VALUE;
        for (Node child:node.children){
//            System.out.println();
            max=Math.max(max,Max(child));
        }
        max= Math.max(node.data,max);
        return max;
    }
    public static int depth(Node node){
        int level=-1;
        for (Node child:node.children){
            level=Math.max(level,depth(child));
        }
        return level+1;

    }
    public static void Display(Node node){
        String str = node.data+" -> ";
        for (Node child:node.children){
            str+=child.data+", ";
        }
        str+=".";
        System.out.println(str);
        for(Node child:node.children){
            Display(child);
        }
    }
    public static void Traversal(Node node){
        System.out.println("Node Pre "+node.data);
        for(Node child:node.children){
            System.out.println("Edge Pre "+node.data+"-"+child.data);
            Traversal(child);
            System.out.println("Edge Post "+node.data+"-"+child.data);
        }
        System.out.println("Node Post "+node.data);


    }
    public static void LevelOrderTraversal(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (queue.size()>0){
            node=queue.remove();
            System.out.println(node.data);
            for (Node child:node.children){
                queue.add(child);
            }
        }
        System.out.println(".");
    }
    public static void LevelOrderTraversal2(Node node) {
        Queue<Node> temp = new ArrayDeque<>();
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        while (mq.size()>0){
            node=mq.remove();
            System.out.print(node.data + " " );
            for (Node child:node.children){
                temp.add(child);
            }
            if (mq.size()==0){
                mq=temp;
                temp = new ArrayDeque<>();
                System.out.println();
            }
        }
        System.out.println(".");
    }

    public static void LevelOrderTraversalOptimised(Node node) {
        Queue<Node> mq = new LinkedList<>();
        mq.add(node);
        mq.add(null);
        while (mq.size()>0){
            node=mq.remove();
            if (node!=null) {
                System.out.print(node.data + " ");
                for (Node child : node.children) {
                    mq.add(child);
                }
            }
            else{
                if (mq.size()>0){
                    mq.add(null);
                    System.out.println();
                }
            }
        }
        System.out.println(".");
    }

    public static void LevelOrderTraversalOptimised2(Node node) {
        Queue<Node> mq = new LinkedList<>();
        mq.add(node);
//        mq.add(null);
        while (mq.size()>0){
            int size = mq.size();
            for (int i = 0; i < size; i++) {
                node = mq.remove();
                System.out.print(node.data+" ");
                for(Node child : node.children){
                    mq.add(child);
                }
            }
            System.out.println();
        }
        System.out.println(".");
    }
    public static void Mirror(Node node){
        for (Node child:node.children){
            Mirror(child);
        }
        Collections.reverse(node.children);
//        Display(node);
    }

    public static void mirror(Node node){
        Node root = node;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while(queue.size() != 0){
            Node tempNode = queue.poll();
            if(tempNode.children.size() != 0){
                int i = 0, j = tempNode.children.size()-1;
                while(i < j){
                    Node temp = tempNode.children.get(i);
                    tempNode.children.set(i, tempNode.children.get(j));
                    tempNode.children.set(j, temp);
                    i++;
                    j--;
                }
            }

            for(int ctr = 0; ctr < tempNode.children.size(); ctr++){
                queue.offer(tempNode.children.get(ctr));
            }
        }
        Display(root);
    }

    public static void ZigZagTraversal(Node node){
        Stack<Node> ms= new Stack<>();
        Stack<Node> temp= new Stack<>();
        int level=1;
        ms.push(node);
        while (ms.size()>0){
            node=ms.pop();
            System.out.print(node.data+" ");
            if (level%2!=0){
                for (int i = 0; i < node.children.size(); i++) {
                    temp.push(node.children.get(i));
                }
            }
            else {
                for (int i = node.children.size()-1; i >=0 ; i--) {
                    temp.push(node.children.get(i));
                }
            }
            if (ms.size()==0){
                ms=temp;
                temp = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }


    public static void  RemoveTrees(Node node){
        for (int i =node.children.size()-1;i>=0;i--){
            Node child = node.children.get(i);
            if (node.children.size()==0){
                node.children.remove(child);
            }
        }
        for(Node child:node.children){
            RemoveTrees(child);
        }
//        return ret;
    }

    public static void linearize(Node node){
        for (Node child :node.children){
            linearize(child);
        }
        while (node.children.size()>1){
            Node lc = node.children.remove(node.children.size()-1);
            Node sl = node.children.get(node.children.size()-1);
            Node slt = getTail(sl);
            slt.children.add(lc);
        }
    }

    private static Node getTail(Node node) {
        while (node.children.size()==1){
            node = node.children.get(0);
        }
        return node;
    }
    static int ceil ;
    static int floor ;
    public static Node construct(int []arr){
        Node root = null;
        Stack<Node> stack= new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==-1) {
                stack.pop() ;
            }
            else {
                Node t = new Node();
                t.data = arr[i];
                if (stack.size()>0) {
                    stack.peek().children.add(t);
                }
                else {
                    root =t;
                }
                stack.push(t);
            }
        }
        return root;
    }


    private static int KthLargest(Node node, int k) {
//        floor=Integer.MIN_VALUE;
        int factor=Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            ceilandFloor(node,factor);
            factor=floor;
            floor=Integer.MIN_VALUE;
        }
        return factor;
    }

    private static void ceilandFloor(Node node, int data) {
        if (node.data>data){
            if (node.data<ceil){
                ceil=node.data;
            }
        }
        if (node.data < data) {
            if (node.data>floor)
                floor=node.data;
        }
        for(Node child:node.children){
            ceilandFloor(child,data);
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40,100};
//        System.out.println(arr.length);
        Node root=construct(arr);
        Display(root);
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
//        int data=65;
//        ceilandFloor(root,data);
//        System.out.println("Ceil "+ ceil);
//        System.out.println("Floor "+ floor);
//        System.out.println( KthLargest(root,1));
//        System.out.println(size(root));
//        System.out.println(Max(root));
//        System.out.println(depth(root));
//        RemoveTrees(root);


        GenericTreeIterator gt = new GenericTreeIterator(root);
//        for (int val:gt){ //Depends on iterable
//            System.out.println(val);
//        }
//        OR*******************
        Iterator<Integer> gti = gt.iterator();
        while (gti.hasNext()){
            System.out.println(gti.next());
        }


    }

}
