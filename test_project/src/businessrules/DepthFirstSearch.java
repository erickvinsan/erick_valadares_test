/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessrules;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erick
 */
public class DepthFirstSearch {

    private Graph g;
    private int numberOfPaths;
    private ArrayList<ArrayList<Vertex>> paths;

    public int getNumberOfPaths() {
        return numberOfPaths;
    }

    public DepthFirstSearch(Graph g) {
        this.g = g;
        this.paths = new ArrayList<>();
        this.paths.add(new ArrayList<>());
    }

    public void findRoutesByStops(Vertex v1, Vertex v2, int level) {
        if (level >= 0) {
            --level;
            for (Edge e : g.getNeighbours(v1)) {
                if (e.getV2().getLabel().equals(v2.getLabel())) {
                    numberOfPaths++;
                }
                if ((level - 1) >= 0) {
                    findRoutesByStops(e.getV2(), v2, level);
                }
            }
        }
    }

    public void findRoutesExactlyStops(Vertex v1, Vertex v2, int level) {
        if (level >= 0) {
            --level;
            for (Edge e : g.getNeighbours(v1)) {
                if (e.getV2().getLabel().equals(v2.getLabel()) && level == 0) {
                    numberOfPaths++;
                }
                if ((level - 1) >= 0) {
                    findRoutesExactlyStops(e.getV2(), v2, level);
                }
            }
        }
    }
    
    

    
}
