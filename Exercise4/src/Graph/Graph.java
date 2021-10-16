package Graph;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    int v; //number of vertices
    List<Node> G;

    Graph(int v){
        this.v = v;
        G = new ArrayList<Node>();
        for(int i = 0; i < v; i++){
            G.add(new Node(i));
        }
    }

    public void addEdge(int u, int v){

    }

    public void bfs(int vertex, )

}

class Node{
    int val;
    List<Integer> list = new ArrayList<Integer>();

    Node(int val){
        this.val = val;
    }
}
