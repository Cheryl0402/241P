package Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        int num = 6, source, dest;
       // Graph g = new Graph();
        Graph graph = new Graph();
        graph.addEdge("A","B");
        graph.addEdge("A","D");
        graph.addEdge("A","I");
        graph.addEdge("B","C");
        graph.addEdge("B","D");
        graph.addEdge("B","E");
        graph.addEdge("C","E");
        graph.addEdge("C","F");
        graph.addEdge("D","E");
        graph.addEdge("D","G");
        graph.addEdge("E","F");
        graph.addEdge("E","G");
        graph.addEdge("E","H");
        graph.addEdge("F","H");
        graph.addEdge("G","H");
        graph.addEdge("G","I");
        graph.addEdge("G","J");
        graph.addEdge("H","J");
        graph.addEdge("I","J");

        System.out.println("BFS:");
        graph.bfs("A");
        System.out.println();

        HashSet<String> visited = new HashSet<String>();
        System.out.println("DFS: ");
        graph.dfs("A", visited);
    }

}
