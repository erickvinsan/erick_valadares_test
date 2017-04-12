/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author erick
 */
public class Edge {
    
    private Vertex v1;
    private Vertex v2;
    
    private int weight;
    
    //Edge(v1, v2, 5) == v1---5-->v2  != Edge(v2, v1, 3) == v2---3-->v1
    public Edge(Vertex v1, Vertex v2, int weight){
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }
    
    public Vertex getV1(){
        return this.v1;
    }
    
    public Vertex getV2(){
        return this.v2;
    }

    public int getWeight() {
        return weight;
    }
    
    
    
    
    
}
