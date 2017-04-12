package file;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GraphFileReader {

    private File file;
    private Scanner reader;

    public GraphFileReader(String path) {
        this.file = new File(path);
        try {
            this.reader = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.err.println("The file cannot be found!");
            this.reader.close();
        }
    }

    public Graph readGraph() throws Exception {
        ArrayList<Edge> edges = new ArrayList<>();
        String newEdge = reader.nextLine();
        Set vertex = new HashSet();
        do {
            if (newEdge.length() != 3) {
                throw new Exception("Wrong Edge Input! Fix the file!");
            } else {
                Vertex v1 = new Vertex(newEdge.substring(0, 1));
                Vertex v2 = new Vertex(newEdge.substring(1, 2));
                int weight = Integer.parseInt(newEdge.substring(2));
                Edge e = new Edge(v1, v2, weight);
                edges.add(e);
                
                vertex.add(newEdge.substring(0, 1));
                vertex.add(newEdge.substring(1, 2));                
            }
            newEdge = reader.nextLine();
        } while (!newEdge.equals("ENDGRAPH"));
        
        Graph g = new Graph(vertex.size());
        
        for (int i = 0; i < edges.size(); i++) {
            g.addEdge(edges.get(i));
        }
        return g;
    }

}
