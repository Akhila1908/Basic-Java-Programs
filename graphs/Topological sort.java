import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    int V = 6;   // number of vertices

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        // u -> v (weight)
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(4).add(5);
        adj.get(5).add(1);
        adj.get(5).add(2);

        List<Integer> result = topo(adj);

        System.out.println(result);

	}
	public static List<Integer> topo(ArrayList<ArrayList<Integer>> adj){
	    List<Integer> list=new ArrayList<>();
	    Queue<Integer> queue=new LinkedList<>();
	    int[] indegree=new int[adj.size()];
	    for(int j=0;j<adj.size();j++){
	    for(int i:adj.get(j)){
	        indegree[i]++;
	    } 
	    }
	    for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
	    while(!queue.isEmpty()){
	       int curr= queue.poll();
	       list.add(curr);
	       for(int i:adj.get(curr)){
            indegree[i]--;
	        if(indegree[i]==0){
	            queue.add(i);
	        }
	    }
	    }
	    return list;
	}
}
