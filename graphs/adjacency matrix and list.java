import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] edges=new int[m][2];
        for(int i=0;i<m;i++){
           
                edges[i][0]=sc.nextInt();
                 edges[i][1]=sc.nextInt();
            }
        System.out.println(adjmat(n,edges));
        System.out.println(adjlist(n,edges));
    }
    
    public static ArrayList<ArrayList<Integer>> adjmat(int n,int[][] edges){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
       
        for(int i=0;i<n;i++){
             ArrayList<Integer> row=new  ArrayList<>(Collections.nCopies(n,0));
             res.add(row);
        }
        
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            res.get(u).set(v,1); // here we are updating the 0 --> 1
            res.get(v).set(u,1); // if we remove this line then code becomes for directed graphs
        }
        return res;
    }
     public static ArrayList<ArrayList<Integer>> adjlist(int n,int[][] edges){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
       
        for(int i=0;i<n;i++){
             res.add(new ArrayList<>());
        }
        
        for(int e[]:edges){
            int u=e[0];
            int v=e[1];
            res.get(u).add(v); // here we are addind the node to the list thta had edge
            res.get(v).add(u); // if we remove this line then code becomes for directed graphs
        }
        return res;
    }
}
