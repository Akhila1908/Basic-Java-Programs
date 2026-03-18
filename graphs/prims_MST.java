import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    int n=4;
	    ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
	    for(int i=0;i<n;i++){
	        adj.add(new ArrayList<>());
	    }
	    
	    adj.get(0).add(new int[]{1,2});
        adj.get(1).add(new int[]{0,2});

        adj.get(0).add(new int[]{2,4});
        adj.get(2).add(new int[]{0,4});

       adj.get(2).add(new int[]{1,2});
       adj.get(1).add(new int[]{2,2});

       adj.get(1).add(new int[]{3,3});
       adj.get(3).add(new int[]{1,3});

       adj.get(3).add(new int[]{2,1});
       adj.get(2).add(new int[]{3,1});
	    
		System.out.println(mst(adj,n));
	}
	public static int mst(ArrayList<ArrayList<int[]>> adj, int n){
	    int res=0;
	    boolean visited[]=new boolean[n];
	    PriorityQueue<int []> pq=new PriorityQueue<>((a,b)-> a[0]-b[0]);
	    pq.add(new int[]{0,0});
	   
	    while(!pq.isEmpty()){
	        int[] curr=pq.poll();
	        int d=curr[0];
	        int u=curr[1];
	        
	        if(visited[u]){
	        continue;}
	        else{
	            visited[u]=true;
	            res+=d;
	        }
	        
	        for(int i[]:adj.get(u)){
	            
	            int v=i[0];
	            int wt=i[1];
	            if(!visited[v]){
	            pq.add(new int[]{wt,v});
	            }
	        }
	        }
	    return res;
	}
}
