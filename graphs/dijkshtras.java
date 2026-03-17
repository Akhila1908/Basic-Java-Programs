import java.util.*;

public class Main {

    public static void main(String[] args) {

        int V = 5;   // number of vertices

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        // u -> v (weight)
        adj.get(0).add(new int[]{1, 2});
        adj.get(0).add(new int[]{2, 4});
        adj.get(1).add(new int[]{2, 1});
        adj.get(1).add(new int[]{3, 7});
        adj.get(2).add(new int[]{4, 3});
        adj.get(3).add(new int[]{4, 1});

        int src = 0;

        List<Integer> result = dijkstra(V, adj, src);

        System.out.println(result);
    }

    public static List<Integer> dijkstra(int V, ArrayList<ArrayList<int[]>> adj, int src){

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        pq.add(new int[]{0, src});   // {distance, node}

        while(!pq.isEmpty()){

            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];

            if(d > dist[u]) continue;

            for(int i[] : adj.get(u)){

                int v = i[0];
                int w = i[1];

                if(dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < V; i++){
            result.add(dist[i]);
        }

        return result;
    }
}
