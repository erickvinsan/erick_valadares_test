/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import businessrules.CalculatePathWeight;
import businessrules.DepthFirstSearch;
import graph.Edge;
import graph.Graph;
import graph.Vertex;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erick
 */
public class Main {

    public static void main(String[] args) {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");

        Edge e1 = new Edge(a, b, 5);
        Edge e2 = new Edge(b, c, 4);
        Edge e3 = new Edge(c, d, 8);
        Edge e4 = new Edge(d, c, 8);
        Edge e5 = new Edge(d, e, 6);
        Edge e6 = new Edge(a, d, 5);
        Edge e7 = new Edge(c, e, 2);
        Edge e8 = new Edge(e, b, 3);
        Edge e9 = new Edge(a, e, 7);

        Graph g = new Graph(5);

        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);
        g.addEdge(e5);
        g.addEdge(e6);
        g.addEdge(e7);
        g.addEdge(e8);
        g.addEdge(e9);

        CalculatePathWeight pathCalculator = new CalculatePathWeight();
        
        //Test 1
        List<Edge> pathTest1 = new ArrayList<>();
        pathTest1.add(new Edge(a, b, 0));
        pathTest1.add(new Edge(b, c, 0));
        System.out.println(pathCalculator.calculate(g, pathTest1));

        //Test 2
        List<Edge> pathTest2 = new ArrayList<>();
        pathTest2.add(new Edge(a, d, 0));
        System.out.println(pathCalculator.calculate(g, pathTest2));

        //Test 3
        List<Edge> pathTest3 = new ArrayList<>();
        pathTest3.add(new Edge(a, d, 0));
        pathTest3.add(new Edge(d, c, 0));
        System.out.println(pathCalculator.calculate(g, pathTest3));
        
        //Test 4
        List<Edge> pathTest4 = new ArrayList<>();
        pathTest4.add(new Edge(a, e, 0));
        pathTest4.add(new Edge(e, b, 0));
        pathTest4.add(new Edge(b, c, 0));
        pathTest4.add(new Edge(c, d, 0));
        System.out.println(pathCalculator.calculate(g, pathTest4));

        //Test 5
        List<Edge> pathTest5 = new ArrayList<>();
        pathTest5.add(new Edge(a, e, 0));
        pathTest5.add(new Edge(e, d, 0));
        System.out.println(pathCalculator.calculate(g, pathTest5));
        
        DepthFirstSearch dfs = new DepthFirstSearch(g); 
        dfs.findRoutesByStops(c, c, 3);
        System.out.println(dfs.getNumberOfPaths());
        
        /*DepthFirstSearch dfs2 = new DepthFirstSearch(g);
        dfs2.findRoutesExactlyStops(a, c, 4);
        System.out.println(dfs2.getNumberOfPaths());
        
        System.out.println(dfs.lowerCostBetweenTwoVertex(a, c));
        */
    }

}
