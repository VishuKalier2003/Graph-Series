# ${\color{lightblue} Graph \space Series \space - \space Part \space 3}$

This readme contains the code and the link to the notes created during the video. Before reading through the code, please watch the video on ***youtube*** and read the notes. It will be much beneficial and better that way. I have also created a video for explaining the code as well. Please feel free to access the video to learn how the code actually works.

- ***Youtube video*** - [link](https://youtu.be/aeOrcsndHxI)
- ***Code explanation video** - [link]()
- ***Notes link*** - [notes](https://1drv.ms/b/c/a04cbeb414585193/EXJsX1z8_5dLk2M9rLjk2GcBTnenC4F3AbauYSSA-AjLRg?e=99ghAH)

Also subscribe to the channel for more such content. Channel link - [MasterTheCodes](https://youtube.com/@masterthecodes?si=fS2NrxPe7BNftfdO)

### ${\color{lightblue} Code \space for \space Breadth \space First \space Search}$

## Java

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
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
        // Bfs algorithms
        bfs(graph, 1, n);
        sc.close();
    }

    public static void bfs(Map<Integer, List<Integer>> graph, int source, int n) {
        bfs: {
            // Queue defined...
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(source);  // Source node added into the queue...
            boolean visited[] = new boolean[n + 1];
            while (!queue.isEmpty()) {
                int size = queue.size();    //! Important line...
                for (int i = 0; i < size; i++) {
                    int node = queue.poll();    // Extracting first element from the queue...
                    System.out.print(node+" ");
                    visited[node] = true;
                    for (int neighbor : graph.get(node))    // Checking all neighbors...
                        if (!visited[neighbor]) {   // If not visited...
                            visited[neighbor] = true;
                            queue.add(neighbor);    // Add into the queue...
                        }
                }
            }
            break bfs;
        }
    }
}

/*
 * 1 -- 2 -- 3 -- 4
 * |    |
 * 5 -- 6 -- 7
 *      |
 *      8
 *
 * Input-
8
8
1 2
2 3
3 4
1 5
2 6
5 6
6 7
6 8
 *
 */

```

## C++

```cpp
#include <iostream>
#include <vector>
#include <queue>
#include <unordered_map>
using namespace std;

void bfs(unordered_map<int, vector<int>>& graph, int source, int n);

int main() {
    // Input handling...
    int n, m; // Number of nodes and edges
    cin >> n >> m;
    cin.ignore();

    // Graph defined (key - int), (values - list of neighbors (int))...
    unordered_map<int, vector<int>> graph;
    for (int i = 1; i <= n; i++)
        graph[i] = vector<int>(); // Creating or Initialising a graph...

    // Filling the edges...
    for (int i = 0; i < m; i++) {
        int node1, node2;
        cin >> node1 >> node2;
        graph[node1].push_back(node2);
        graph[node2].push_back(node1);
    }

    // BFS algorithm
    bfs(graph, 1, n);

    return 0;
}

void bfs(unordered_map<int, vector<int>>& graph, int source, int n) {
    bfs: {
        // Queue defined...
        queue<int> q;
        q.push(source); // Source node added into the queue...
        vector<bool> visited(n + 1, false);

        while (!q.empty()) {
            int size = q.size(); //! Important line...
            for (int i = 0; i < size; i++) {
                int node = q.front(); // Extracting first element from the queue...
                q.pop();
                cout << node << " ";
                visited[node] = true;

                for (int neighbor : graph[node]) { // Checking all neighbors...
                    if (!visited[neighbor]) { // If not visited...
                        visited[neighbor] = true;
                        q.push(neighbor); // Add into the queue...
                    }
                }
            }
        }
        break bfs;
    }
}

/*
 * 1 -- 2 -- 3 -- 4
 * |    |
 * 5 -- 6 -- 7
 *      |
 *      8
 *
 * Input-
8
8
1 2
2 3
3 4
1 5
2 6
5 6
6 7
6 8
 *
 */

```
