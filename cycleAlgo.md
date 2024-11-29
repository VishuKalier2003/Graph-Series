# ${\color{lightblue} Graph \space Series \space - \space Part \space 5}$

This readme contains the code and the link to the notes created during the video. Before reading through the code, please watch the video on ***youtube*** and read the notes. It will be much beneficial and better that way. I have also created a video for explaining the code as well. Please feel free to access the video to learn how the code actually works.

- ***Youtube video*** - [link](https://youtu.be/tZPbcSNAJN4)
- ***Code explanation video** - [link](https://youtu.be/tZPbcSNAJN4)
- ***Notes link*** - [notes](https://1drv.ms/b/c/a04cbeb414585193/EXJsX1z8_5dLk2M9rLjk2GcBTnenC4F3AbauYSSA-AjLRg?e=99ghAH)

Also subscribe to the channel for more such content. Channel link - [MasterTheCodes](https://youtube.com/@masterthecodes?si=fS2NrxPe7BNftfdO)

### ${\color{lightblue} Code \space for \space Cycle \space Detection \space Algorithm}$

## Java

```java
import java.util.*;

public class Cycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = sc.nextInt(), m;
        m = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= n; i++)
            graph.put(i, new ArrayList<Integer>());     // Initialising the keys...
        for(int i = 0; i < m; i++) {
            String edge[] = sc.nextLine().split(" ");       // 1 2    i.e.  1---2  and 2---1
            int n1 = Integer.parseInt(edge[0]), n2 = Integer.parseInt(edge[1]);
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
        System.out.println(detectCycle(graph, 1, -1, new boolean[n+1]));
        sc.close();
    }

    // dfs(1, -1)  ->  dfs(2, 1)  -->  ...
    public static boolean detectCycle(Map<Integer, List<Integer>> graph, int node, int parent, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {       //! Important code...
                if (detectCycle(graph, neighbor, node, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {    //! Important code...
                // If the neighbor is visited and is not the parent, it is a cycle...
                return true;
            }
        }
        return false;
    }
}


/*
Test case 1-

4
4
1 2
2 3
3 4
4 1

1 --  2
|     |
3 --  4

Test case 2-

4
3
1 2
2 3
3 4

1 -- 2 -- 3 -- 4


 */

```

## C++

```cpp
#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

bool detectCycle(unordered_map<int, vector<int>>& graph, int node, int parent, vector<bool>& visited);

int main() {
    int n, m;
    cin >> n >> m;
    unordered_map<int, vector<int>> graph;

    // Initializing the keys...
    for (int i = 1; i <= n; ++i) {
        graph[i] = vector<int>();
    }

    // Reading edges
    for (int i = 0; i < m; ++i) {
        int n1, n2;
        cin >> n1 >> n2;
        graph[n1].push_back(n2); // 1 --- 2 and 2 --- 1
        graph[n2].push_back(n1);
    }

    // Detect cycle starting from node 1
    cout << (detectCycle(graph, 1, -1, vector<bool>(n + 1, false)) ? "true" : "false") << endl;

    return 0;
}

// dfs(1, -1) -> dfs(2, 1) --> ...
bool detectCycle(unordered_map<int, vector<int>>& graph, int node, int parent, vector<bool>& visited) {
    visited[node] = true;
    for (int neighbor : graph[node]) {
        if (!visited[neighbor]) { // ! Important code...
            if (detectCycle(graph, neighbor, node, visited)) {
                return true;
            }
        } else if (neighbor != parent) { // ! Important code...
            // If the neighbor is visited and is not the parent, it is a cycle...
            return true;
        }
    }
    return false;
}

/*
Test case 1-

4
4
1 2
2 3
3 4
4 1

1 --  2
|     |
3 --  4

Test case 2-

4
3
1 2
2 3
3 4

1 -- 2 -- 3 -- 4
*/

```
