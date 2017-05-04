package dijkstra;

import java.util.*;

/**
 * Created by vaibhav.soni on 5/3/2017.
 */
public class DijkstraAlgorithmImpl {
    private static final int INFINITE_VALUE = 999999;

    public static void main(String[] args) {
        int graph[][] = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        DijkstraAlgorithmImpl dijkstraAlgorithm = new DijkstraAlgorithmImpl();
        int[] shortestPath = dijkstraAlgorithm.dijkstra(graph, 0);
        for (int i = 0; i < shortestPath.length; i++) {
            System.out.println(shortestPath[i]);
        }

    }

    public int[] dijkstra(int graph[][], int rootNode) {
        int[] distanceArray = new int[graph.length];
        //duplicates are not allowed and insertion order is preserved
        LinkedHashSet vertex = new LinkedHashSet();
        distanceArray = DijkstraAlgorithmImpl.initializeDistanceArray(distanceArray, rootNode);

        while (vertex.size() != graph.length) {
            int nodeWithMinimumDistance = DijkstraAlgorithmImpl.findMinimumInDistanceArray(distanceArray, vertex);
            vertex.add(nodeWithMinimumDistance);
            HashMap<Integer, Integer> adjacentVertices = DijkstraAlgorithmImpl.getAdjacentVertices(graph, nodeWithMinimumDistance);
            Set adjacentVerticesSet = adjacentVertices.entrySet();
            Iterator itr = adjacentVerticesSet.iterator();
            while (itr.hasNext()) {
                Map.Entry map = (Map.Entry) itr.next();
                int key = (Integer) map.getKey();
                int value = (Integer) map.getValue();
                if (distanceArray[key] > value) {
                    distanceArray[key] = value;
                }
            }
        }
        return distanceArray;
    }

    private static HashMap<Integer, Integer> getAdjacentVertices(int[][] graph, int nodeWithMinimumDistance) {
        HashMap<Integer, Integer> adjacentVertices = new HashMap<Integer, Integer>();
        for (int i = 0; i < graph[nodeWithMinimumDistance].length; i++) {
            if (graph[nodeWithMinimumDistance][i] != 0) {
                adjacentVertices.put(i, graph[nodeWithMinimumDistance][i]);
            }
        }
        return adjacentVertices;
    }

    private static int findMinimumInDistanceArray(int[] distanceArray, LinkedHashSet vertex) {
        int min = INFINITE_VALUE;
        for (int i = 0; i < distanceArray.length; i++) {
            if (distanceArray[i] < min && !vertex.contains(i)) {
                min = distanceArray[i];
            }
        }
        for (int i = 0; i < distanceArray.length; i++) {
            if (distanceArray[i] == min) {
                return i;
            }
        }
        return -1;
    }

    private static int[] initializeDistanceArray(int[] distanceArray, int rootNode) {
        for (int i = 0; i < distanceArray.length; i++) {
            distanceArray[i] = INFINITE_VALUE;
        }
        distanceArray[rootNode] = 0;
        return distanceArray;
    }
}
