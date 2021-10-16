package Graph;
import java.util.*;
import java.util.ArrayList;



public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] matrix = {
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0}

        };
        System.out.print("\nAdjacency Matrix: ");
        printMatrix(matrix);
        System.out.println();
        
//********************************* Convert Matrix to Adjacency List ***************************************************
        List<VertexNode> vertices = convertMatrixToList(matrix);
        System.out.println("\nAdjacency List from Adjacency matrix: ");
        for(int i = 0; i < vertices.size(); i++){
            System.out.print(vertices.get(i).vertexVal + " : ");
            for(int j = 0; j < vertices.get(i).list.size(); j++){
                System.out.print(vertices.get(i).list.get(j) + ", ");
            }
            System.out.println();
        }
        System.out.println();


//******************************** Convert Adjacency List to Incidence Matrix ******************************************
        //store edges from the adjacency list. Three pointer to track edges.
        List<Integer[]> edges = new ArrayList<Integer[]>();
        int count = 0;
        for(int i = 0; i < vertices.size(); i++){
            for(int j = 0; j < vertices.get(i).list.size(); j++){
                if(i <= vertices.get(i).list.get(j)){
                    edges.add(new Integer[2]);
                    edges.get(count)[0] = i;
                    edges.get(count)[1] = vertices.get(i).list.get(j);
                    count++;
                }

            }
        }

        int[][] incidenceMatrix = new int[vertices.size()][edges.size()];
        for(int i = 0; i < vertices.size(); i++){
            int j = 0;
            for(Integer[] edge : edges){
                if(edge[0] == vertices.get(i).vertexVal || edge[1] == vertices.get(i).vertexVal){
                    incidenceMatrix[i][j++] = 1;
                    //j++;
                }else{
                    incidenceMatrix[i][j++] = 0;
                   // j++;
                }
            }
        }
        System.out.print("Incidence Matrix from Adjacency List: ");
        printMatrix(incidenceMatrix);
        System.out.println();


//******************************  Convert Incidence Matrix to Adjacency List *******************************************
        List<VertexNode> adList = new ArrayList<VertexNode>();
        for(int i = 0; i < incidenceMatrix.length; i++){
            VertexNode vNode = new VertexNode(i);
            for(int j = 0; j < incidenceMatrix[i].length; j++){
                if(incidenceMatrix[i][j] == 1){
                    int adListj = edges.get(j)[0] == i ? edges.get(j)[1] : edges.get(j)[0];
                    vNode.list.add(adListj);
                }
            }
            adList.add(vNode);
        }

        System.out.println("\nAdjacency List from Incidence Matrix: ");
        for(int i = 0; i < adList.size(); i++){
            System.out.print(adList.get(i).vertexVal + ": ");
            for(int j = 0; j < adList.get(i).list.size(); j++){
                System.out.print(adList.get(i).list.get(j) + ", ");
            }
            System.out.println();
        }
    }





    public static List<VertexNode> convertMatrixToList(int[][] matrix){
        List<VertexNode> adjacencyList = new ArrayList();      // List of vertex
        for(int i = 0; i < matrix.length; i++){
            VertexNode vertex = new VertexNode(i);                  // each row represents a vertex
            adjacencyList.add(vertex);                              //
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 1){
                    vertex.list.add(j);
                }
            }
        }
        return adjacencyList;
    }

    public static void printMatrix(int[][] matrix){
         for(int i = 0; i < matrix.length; i++){
             System.out.println();
             for(int j = 0; j < matrix[i].length; j++){
                 if(j == matrix[i].length - 1){
                     System.out.print(matrix[i][j]);
                 }else{
                     System.out.print(matrix[i][j] + ", ");
                 }
             }
         }
    }

}









