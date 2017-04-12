/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erick
 */
public class Graph {

    private List<Edge> graph;
    private int numberOfVertex;

    public Graph(int numOfVertex) {
        this.graph = new ArrayList<>();
        this.numberOfVertex = numOfVertex;
    }
    
    public List<Edge> getGraph() {
        return graph;
    }

    public void addEdge(Edge e) {
        this.graph.add(e);
    }

    public Edge getEdge(int idx) {
        return graph.get(idx);
    }

//    public Edge getEdge(String label){
//        for (int i = 0; i < graph.size(); i++) {
//            if(){
//            }
//        }
//    }
    public List<Edge> getNeighbours(Vertex v) {
        //System.out.println("Vizinhos de " + v.getLabel());
        ArrayList<Edge> neighbours = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).getV1().getLabel().equals(v.getLabel())) {
                neighbours.add(getEdge(i));
                //System.out.println("Novo vizinho adicionado: " + getEdge(i).getV1().getLabel() + ", " + getEdge(i).getV2().getLabel());
            }
        }
        //System.out.println("-----------------------------");
        return neighbours;
    }

    public int getNumberOfVertex() {
        return numberOfVertex;
    }

    public void setNumberOfVertex(int numberOfVertex) {
        this.numberOfVertex = numberOfVertex;
    }

}
