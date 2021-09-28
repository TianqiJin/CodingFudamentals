package org.tianqj.fundamentals.dfs;

import org.junit.Test;
import org.tianqj.fundamentals.models.Graph;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

public class DepthFirstSearchTest {

    @Test
    public void test() {
        Graph graph = new Graph();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        List<Integer> result = depthFirstSearch.solution(graph, 0);
    }
}
