package org.tianqj.fundamentals.dfs;

import org.tianqj.fundamentals.models.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Use Depth first search to traverse a graph.
 * For example, the following graph
 * 1 - 2
 * |   |
 * 3 - 4
 * the DFS will produce 1,2,3,4 as the result
 */
public class DepthFirstSearch {

    public List<Integer> solution (Graph graph, int start) {

        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        boolean[] isVisited = new boolean[graph.adjVertices.size()];
        stack.push(start);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            result.add(current);
            isVisited[current] = true;
            for (int dest : graph.adjVertices.get(current)) {
                if (!isVisited[dest]) {
                    stack.push(dest);
                }
            }
        }

        return result;
    }
}
