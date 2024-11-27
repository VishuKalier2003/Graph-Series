# ${\color{lightblue} Graph \space Series \space - \space Part \space 4}$

This readme contains the code and the link to the notes created during the video. Before reading through the code, please watch the video on ***youtube*** and read the notes. It will be much beneficial and better that way. I have also created a video for explaining the code as well. Please feel free to access the video to learn how the code actually works.

- ***Youtube video*** - [link](https://lnkd.in/gJ4tBbn9)
- ***Code explanation video** - [link](https://lnkd.in/gJ4tBbn9)
- ***Notes link*** - [notes](https://1drv.ms/b/c/a04cbeb414585193/EXJsX1z8_5dLk2M9rLjk2GcBTnenC4F3AbauYSSA-AjLRg?e=99ghAH)

Also subscribe to the channel for more such content. Channel link - [MasterTheCodes](https://youtube.com/@masterthecodes?si=fS2NrxPe7BNftfdO)

### ${\color{lightblue} Code \space for \space Breadth \space First \space Search}$

## Java

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DFS {
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
        dfs(graph, 1, new boolean[n+1]);
        sc.close();
    }

    public static void dfs(Map<Integer, List<Integer>> graph, int source, boolean visited[]) {
        visited[source] = true;     // Marking the node as visited...
        System.out.print(source+" ");
        for(int neighbor : graph.get(source))
            if(!visited[neighbor])  // If the neighbor is not visited...
                dfs(graph, neighbor, visited);   //! Extract the neighbor branch...
        return;     // Backtrack when all neighbors are explored...
    }
}

/*
 * 1 -- 2 -- 3 -- 4
 * |    |
 * 5 -- 6 -- 7
 *      |
 *      8 -- 9
 *
 * Input-
9
9
1 2
2 3
3 4
1 5
2 6
5 6
6 7
6 8
8 9
 *
 */


```

## C++

```cpp
#include <iostream>
#include <vector>
#include <map>
using namespace std;

void dfs(map<int, vector<int>> &graph, int source, vector<bool> &visited) {
    visited[source] = true; // Mark the node as visited
    cout << source << " ";
    for (int neighbor : graph[source]) {
        if (!visited[neighbor]) { // If the neighbor is not visited
            dfs(graph, neighbor, visited); // Recur for the neighbor
        }
    }
}

int main() {
    int n, m; // Number of nodes and edges
    cin >> n >> m;

    map<int, vector<int>> graph; // Graph represented as adjacency list
    for (int i = 1; i <= n; i++) {
        graph[i] = vector<int>(); // Initialize the graph
    }

    // Filling the edges
    for (int i = 0; i < m; i++) {
        int node1, node2;
        cin >> node1 >> node2;
        graph[node1].push_back(node2);
        graph[node2].push_back(node1);
    }

    vector<bool> visited(n + 1, false); // Visited array initialized to false
    dfs(graph, 1, visited); // Perform DFS starting from node 1

    return 0;
}


```
