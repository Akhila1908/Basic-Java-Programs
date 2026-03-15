import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    ArrayList<Integer> list=new ArrayList<>();
	    Queue<Integer> queue=new LinkedList<>();
//use of queue -  inorder to find the adjacent element which is not visited
	    int vertice=5;
	    int[][] edges={{0,1},{0,2},{1,2}};
	    boolean visited[]={false,false,false,false,false};
	    queue.offer(0);  // we can also change this src node , which is ‘0’.
	    visited[0]=true;
	    while(!queue.isEmpty()){
	        
	        int n=queue.poll();
	        list.add(n);
	   for(int[] node:edges){
	        int u=node[0];
	        int v=node[1];
	   
	       if(!visited[v]){
	                visited[v]=true;
	        queue.offer(v);
	         }
	            }
	        }
	    
	    for(int i=0;i<list.size();i++){
		System.out.println(list.get(i)+" ");
	    }
  }
