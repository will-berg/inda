package se.kth.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomGraphGenerator {
    static int componentSize;
    static ArrayList<Integer> sizeList = new ArrayList<>();

    public static void main(String[] args) {
        if (args.length == 2) {
            // number of nodes
            String arg = args[0];
            // graph type
            String arg2 = args[1];
            if (Integer.parseInt(arg) > 0) {
                if (arg2.equals("matrix")) {
                    Graph mg = matrixGraphGenerator(Integer.parseInt(arg));
                    long t0 = System.nanoTime();
                    System.out.println("number of components: " + numberOfComponents(mg));
                    System.out.println("vertices in largest component: " + largestComponent(mg));
                    long t1 = System.nanoTime();
                    System.out.println("running time: " + (t1 - t0));
                } else if (arg2.equals("hash")) {
                    Graph hg = hashGraphGenerator(Integer.parseInt(arg));
                    long t2 = System.nanoTime();
                    System.out.println("number of components: " + numberOfComponents(hg));
                    System.out.println("vertices in largest component: " + largestComponent(hg));
                    long t3 = System.nanoTime();
                    System.out.println("running time: " + (t3 - t2));
                } else {
                    System.out.println("available graph types are matrix or hash");
                }
            } else {
                System.out.println("input has to be a positive number");
            }
        } else {
            System.out.println("2 arguments required");
        }
    }

    public static Graph matrixGraphGenerator(int n) {
        Graph mg = new MatrixGraph(n);
        Random R = new Random();
        // Add edges between random vertices n times.
        while (mg.numEdges() < n) {
            mg.add(R.nextInt(n), R.nextInt(n));
        }
        return mg;
    }

    public static Graph hashGraphGenerator(int n) {
        Graph hg = new HashGraph(n);
        Random R = new Random();
        // Add edges between random vertices n times.
        while (hg.numEdges() < n) {
            hg.add(R.nextInt(n), R.nextInt(n));
        }
        return hg;
    }

    public static int numberOfComponents(Graph g) {
        VertexAction nothing = new VertexAction() {
            @Override
            public void act(Graph g, int v) {
            }
        };
        int count = 0;
        int size = g.numVertices();
        boolean[] visited = new boolean[size];
        for (int v = 0; v < size; v++) {
            if (!visited[v]) {
                dfs(g, v, visited, nothing);
                count++;
            }
        }
        return count;
    }

    /**
     *
     * @param g the graph
     * @return the number of nodes in the largest component.
     */
    public static int largestComponent(Graph g) {
        VertexAction increment = new VertexAction() {
            @Override
            public void act(Graph g, int v) {
                componentSize++;
            }
        };
        int n = g.numVertices();
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                dfs(g, v, visited, increment);
                sizeList.add(componentSize);
                componentSize = 0;
            }
        }
        return Collections.max(sizeList);
    }

    private static void dfs(Graph g, int v, boolean[] visited, VertexAction action) {
        if (visited[v])
            return;
        visited[v] = true;
        action.act(g, v);
        for (VertexIterator it = g.neighbors(v); it.hasNext();)
            dfs(g, it.next(), visited, action);
    }
}
