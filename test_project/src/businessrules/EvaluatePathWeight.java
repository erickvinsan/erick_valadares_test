/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessrules;

import graph.Edge;
import graph.Graph;
import java.util.List;

/**
 *
 * @author erick
 */
public class EvaluatePathWeight {

    /*
    * return 0 if there is not that path
    *    by the other hand, return the path's weight
    *
    *
     */
    public String calculate(Graph g, List<Edge> path) {
        int count = 0;
        int weight = 0;
        for (int i = 0; i < path.size(); i++) {
            for (int j = 0; j < g.getGraph().size(); j++) {
                if (path.get(i).getV1().getLabel().equals(g.getGraph().get(j).getV1().getLabel()) && path.get(i).getV2().getLabel().equals(g.getGraph().get(j).getV2().getLabel())) {
                    count++;
                    weight += g.getGraph().get(j).getWeight();
                }
            }
        }
        if (count == path.size()) {
            return "" + weight;
        } else {
            return "NO SUCH ROUTE";
        }
    }

}
