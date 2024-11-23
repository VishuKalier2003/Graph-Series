# ${\color{lightblue} Graph \space Series \space - \space Part \space 1}$

This readme contains the code and the link to the notes created during the video. Before reading through the code, please watch the video on ***youtube*** and read the notes. It will be much beneficial and better that way. I have also created a video for explaining the code as well. Please feel free to access the video to learn how the code actually works.

- ***Youtube video*** - [link](https://youtu.be/aeOrcsndHxI)
- ***Code explanation video** - [link]()
- ***Notes link*** - [notes](https://1drv.ms/b/c/a04cbeb414585193/EdeEYHWDk0pAr49cyBBUXK8BI0vWFlGE-G0usP-5ycAm9g?e=Y9boTX)

Also subscribe to the channel for more such content. Channel link - [MasterTheCodes](https://youtube.com/@masterthecodes?si=fS2NrxPe7BNftfdO)

### ${\color{lightblue} Code \space for \space Creating \space Graph}$

## Java

```java
import java.util.*;

public class BasicGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Map created (key - int) and (value - list of neighboring nodes (int type))...
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // Create Operation...
        create: {
            for(int i = 1; i <= 5; i++)
                graph.put(i, new ArrayList<Integer>());
            break create;
        }
        // Add / Update Operation...
        add: {
            // Node 1...
            graph.get(1).add(2);    // Connect the neighbors...
            graph.get(1).add(3);
            // Node 2...
            graph.get(2).add(1);
            graph.get(2).add(4);
            graph.get(2).add(5);
            // Node 3...
            graph.get(3).add(1);
            graph.get(3).add(4);
            // Node 4...
            graph.get(4).add(2);
            graph.get(4).add(3);
            // Node 5...
            graph.get(5).add(2);
            System.out.println("Graph : "+graph);
            break add;
        }
        search: {
            System.out.println("Search result of Node 1 : "+graph.containsKey(1));
            System.out.println("Search result of Node 6 : "+graph.containsKey(6));
            break search;
        }
        delete: {
            graph.remove(5);
            System.out.println("Graph after removal of node 5 : "+graph);
            break delete;
        }
        sc.close();
    }
}
```

## C++

```cpp
#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

int main() {
    // Map created (key - int) and (value - list of neighboring nodes (int type))...
    unordered_map<int, vector<int>> graph;

    // Create Operation...
    create: {
        for (int i = 1; i <= 5; i++)
            graph[i] = vector<int>();
        break;
    }

    // Add / Update Operation...
    add: {
        // Node 1...
        graph[1].push_back(2);  // Connect the neighbors...
        graph[1].push_back(3);
        // Node 2...
        graph[2].push_back(1);
        graph[2].push_back(4);
        graph[2].push_back(5);
        // Node 3...
        graph[3].push_back(1);
        graph[3].push_back(4);
        // Node 4...
        graph[4].push_back(2);
        graph[4].push_back(3);
        // Node 5...
        graph[5].push_back(2);
        cout << "Graph: ";
        for (auto &node : graph) {
            cout << node.first << ": [";
            for (size_t i = 0; i < node.second.size(); i++) {
                cout << node.second[i];
                if (i < node.second.size() - 1) cout << ", ";
            }
            cout << "] ";
        }
        cout << endl;
        break;
    }

    // Search Operation...
    search: {
        cout << "Search result of Node 1: " << (graph.find(1) != graph.end() ? "Found" : "Not Found") << endl;
        cout << "Search result of Node 6: " << (graph.find(6) != graph.end() ? "Found" : "Not Found") << endl;
        break;
    }

    // Delete Operation...
    delete_op: {
        graph.erase(5);
        cout << "Graph after removal of node 5: ";
        for (auto &node : graph) {
            cout << node.first << ": [";
            for (size_t i = 0; i < node.second.size(); i++) {
                cout << node.second[i];
                if (i < node.second.size() - 1) cout << ", ";
            }
            cout << "] ";
        }
        cout << endl;
        break;
    }

    return 0;
}

```
