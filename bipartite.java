import java.util.*;

public class Bipartite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Input class...
        int n = sc.nextInt(); // Number of nodes...
        int m = sc.nextInt(); // Number of edges...
        sc.nextLine();
        // Graph defined (key - int), (values - list of neighbors (int))...
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++)
            graph.put(i, new ArrayList<>());    // Creating or Initialising a graph...
        // Filling the edges...
        for (int i = 0; i < m; i++) {
            String str[] = sc.nextLine().split(" ");
            int node1 = Integer.parseInt(str[0]), node2 = Integer.parseInt(str[1]);
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        // dfs algorithms
        System.out.println(bipartite(graph, 1, new boolean[n+1], n));
        sc.close();
    }

    public static boolean bipartite(Map<Integer, List<Integer>> graph, int node, boolean visited[], int n) {
        bfs: {      // BFS Algorithm...
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(node);
            int color[] = new int[n+1];     // Color array to store color of every nodes...
            boolean redColor = true;        // Current color...
            while(!queue.isEmpty()) {
                int size = queue.size();    //! Size of the queue...
                for(int i = 0; i < size; i++) {
                    int current = queue.poll();     // Extracting first element of the queue...
                    visited[current] = true;
                    color[current] = redColor ? 1 : -1;     // Assign color to the node...
                    for(int neighbor : graph.get(current)) {
                        //! If neighbors get same color, then not a bipartite graph...
                        if(color[neighbor] == color[current])
                            return false;
                        if(!visited[neighbor])      // If neighbor is not visited, push into the queue...
                            queue.add(neighbor);
                    }
                }
                redColor = !redColor;       //! Reverse the color for next nodes...
            }
            break bfs;
        }
        return true;
    }
}

/*
 * 1 -- 2 -- 3
 * |    |
 * 5 -- 4
 *
 * Input-
5
5
1 2
2 3
2 4
1 5
4 5

1 -- 2 --
|       |
|       3
|       |
4 -- 5 --

5
5
1 2
2 3
3 5
4 5
4 1

 *
 */
