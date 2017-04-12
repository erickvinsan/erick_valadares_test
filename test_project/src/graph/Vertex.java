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
public class Vertex {
    private String label;
    private Vertex Parent;
    private int costFromParent;
    
    public Vertex(String label){
        this.label = label;
    }
    
    public String getLabel(){
        return this.label;
    }

    public Vertex getParent() {
        return Parent;
    }

    public void setParent(Vertex Parent) {
        this.Parent = Parent;
    }

    public int getCostFromParent() {
        return costFromParent;
    }

    public void setCostFromParent(int costFromParent) {
        this.costFromParent = costFromParent;
    }
}
