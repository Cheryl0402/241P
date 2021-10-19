package Graph;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    int v; //number of vertices
    private Map<String, ArrayList<String>> adList;

    public Graph(){
        this.v = 0;
        this.adList = new HashMap<String, ArrayList<String>>();
    }

    public Graph(int vertices){
        this.v = vertices;
        adList = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i < vertices; i++){
            ArrayList<String> neighbours = new ArrayList<>();
            adList.put("", neighbours);
        }
    }

    public void addEdge(String v, String neighbour){
//        // check if the vertex is out of bound
        if(!adList.containsKey(v)){
            ArrayList<String> list = new ArrayList<>();
            list.add(neighbour);
            adList.put(v, list);
        }
        if(!adList.containsKey(neighbour)){
            ArrayList<String> list = new ArrayList<>();
            list.add(v);
            adList.put(neighbour, list);
        }
        // For undirected graph, add each node as neighbour.
        adList.get(v).add(neighbour);
        adList.get(neighbour).add(v);
    }

    public ArrayList<String> getNeighbours(String vertex){
        //check if vertex is a part of graph.
        if(adList.containsKey(vertex)){
            return null;
        }
        return new ArrayList<String>(adList.get(vertex));
    }

    public void bfs(String vertex){
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(vertex);
        visited.add(vertex);

        while(!queue.isEmpty()){
            String v = queue.poll();
            System.out.print(v + ", ");
            List<String> neighbours = this.getNeighbours(v);
            Collections.sort(neighbours);
            for(String neighbour : neighbours){
                if(!visited.contains(neighbour)){
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
    }

    public void dfs(String vertex, Set<String> visited){
        if(visited.contains((vertex))) return;
        visited.add(vertex);
        System.out.print(vertex + ", ");
        List<String> neighbours = this.getNeighbours(vertex);
        Collections.sort(neighbours);
        for(String neighbour :  neighbours){
            dfs(neighbour, visited);
        }
    }
}


