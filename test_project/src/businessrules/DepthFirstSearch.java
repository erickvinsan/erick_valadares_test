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

    private int numberOfPaths;
    private ArrayList<ArrayList<Vertex>> paths;

    public int getNumberOfPaths() {
        return numberOfPaths;
    }
    private Graph g;
    private static List<List<Edge>> answers;

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

    
    //It isn't working
    private void findLowerCost(Vertex v1, Vertex v2, int level) {
        if (level >= 0) {
            --level;
            for (Edge e : g.getNeighbours(v1)) {
                if (e.getV2().getLabel().equals(v2.getLabel())) {
                    numberOfPaths++;
                    if ((level - 1) >= 0) {
                        paths.add(new ArrayList<>());
                        for (int i = 0; i < paths.get(paths.size() - 1).size(); i++) {
                            paths.get(paths.size() - 1).add(paths.get(paths.size() - 2).get(i));
                        }
                    }
                }
                if (e.getV2().getLabel().equals(v2.getLabel()) && level == 0) {
                    paths.add(new ArrayList<>());
                }
                if ((level - 1) >= 0) {
                    findLowerCost(e.getV2(), v2, level);
                    Vertex v = new Vertex(e.getV2().getLabel());
                    v.setParent(e.getV1());
                    v.setCostFromParent(e.getWeight());
                    paths.get(paths.size() - 1).add(v);

                }
            }
        }
    }

    //It isn't working
    public int lowerCostBetweenTwoVertex(Vertex v1, Vertex v2) {
        findLowerCost(v1, v2, g.getNumberOfVertex());
        Vertex aux = null;
        int cost = Integer.MAX_VALUE;
        int costAux = 0;
        for (int i = 0; i < paths.size(); i++) {
            costAux = 0;
            for (int j = 0; j < paths.get(i).size(); j++) {
                costAux += paths.get(i).get(j).getCostFromParent();
            }
            if (costAux <= cost) {
                cost = costAux;
            }
        }

        return cost;
    }

}
