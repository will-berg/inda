package se.kth.graph;

import java.util.*;

/**
 * A graph with a fixed number of vertices implemented using adjacency maps.
 * Space complexity is &Theta;(n + m) where n is the number of vertices and m
 * the number of edges.
 *
 * @author [William Berg]
 * @version [2020-02-19]
 */
public class HashGraph implements Graph {

    public static void main(String[] args) {

    }
    /**
     * The map edges[v] contains the key-value pair (w, c) if there is an edge
     * from v to w; c is the cost assigned to this edge. The maps may be null
     * and are allocated only when needed.
     */
    // Array of maps storing integer keys (edge endpoint) and integer values (edge cost)
    // The array indices represent vertices. Array index 1 represents vertex number 1.
    private final Map<Integer, Integer>[] edges;
    private final static int INITIAL_MAP_SIZE = 4;

    /** Number of edges in the graph. */
    private int numEdges;

    /**
     * Constructs a HashGraph with n vertices and no edges. Time complexity:
     * O(n)
     *
     * @throws IllegalArgumentException
     *             if n < 0
     */
    public HashGraph(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n = " + n);

        // The array will contain only Map<Integer, Integer> instances created
        // in addEdge(). This is sufficient to ensure type safety.
        @SuppressWarnings("unchecked") Map<Integer, Integer>[] a = new HashMap[n];
        edges = a;
    }

    /**
     * Add an edge without checking parameters.
     */
    private void addEdge(int from, int to, int cost) {
        // If there is no map at from index in the array, create one. This happens when the from vertex doesn't exist.
        if (edges[from] == null)
            edges[from] = new HashMap<Integer, Integer>(INITIAL_MAP_SIZE);
        // If edge didn't exist, add it and increment.
        if (edges[from].put(to, cost) == null)
            numEdges++;
    }

    /**
     * {@inheritDoc Graph} Time complexity: O(1).
     */
    @Override
    public int numVertices() {
        return edges.length;
    }

    /**
     * {@inheritDoc Graph} Time complexity: O(1).
     */
    @Override
    public int numEdges() {
        return numEdges;
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public int degree(int v) throws IllegalArgumentException {
        checkVertexParameter(v);

        if (edges[v] != null) {
            return edges[v].size();
        } else {
            return 0;
        }
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public VertexIterator neighbors(int v) {
        checkVertexParameter(v);

        return new NeighborIterator(v);
    }

    private class NeighborIterator implements VertexIterator {
        int n;
        int nextPos = 0;
        int[] keyArray;

        NeighborIterator(int v) {
            if (edges[v] != null) {
                keyArray = toInt(edges[v].keySet());
                n = keyArray.length;
            }
        }

        // Convert integer set to int array.
        private int[] toInt(Set<Integer> set) {
            int[] array = new int[set.size()];
            int i = 0;
            for (Integer key : set) {
                array[i++] = key;
            }
            return array;
        }

        @Override
        public boolean hasNext() {
            return nextPos < n;
        }

        @Override
        public int next() {
            if (hasNext()) {
                return keyArray[nextPos++];
            }
            else throw new NoSuchElementException("This iterator has no more elements.");
        }
    }



    /**
     * {@inheritDoc Graph}
     */
    @Override
    public boolean hasEdge(int from, int to) {
        checkVertexParameters(from, to);

        if (edges[from] == null) {
            return false;
        }
        else return edges[from].containsKey(to);
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public int cost(int from, int to) throws IllegalArgumentException {
        checkVertexParameters(from, to);

        if (hasEdge(from, to)) {
            return edges[from].get(to);
        }
        else return NO_COST;
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void add(int from, int to){
        checkVertexParameters(from,to);

        addEdge(from, to, NO_COST);
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void add(int from, int to, int c) {
        checkVertexParameters(from,to);
        if (c < 0) {
            throw new IllegalArgumentException("Invalid cost");
        } else {
            addEdge(from, to, c);
        }
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void addBi(int v, int w) {
        checkVertexParameters(v, w);

        addEdge(v, w, NO_COST);
        if (v == w) {
            return;
        }
        addEdge(w, v, NO_COST);
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void addBi(int v, int w, int c) {
        checkVertexParameters(v, w);
        if (c < 0) {
            throw new IllegalArgumentException("Invalid cost");
        }
        addEdge(v, w, c);
        if (v == w) {
            return;
        }
        addEdge(w, v, c);
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void remove(int from, int to) {
        checkVertexParameters(from, to);

        removeEdge(from, to);
    }

    /**
     * {@inheritDoc Graph}
     */
    @Override
    public void removeBi(int v, int w) {
        checkVertexParameters(v, w);

        removeEdge(v, w);
        if (v == w) {
            return;
        }
        removeEdge(w, v);
    }

    /**
     * Removes the edges between the given vertices, if it exists.
     */
    private void removeEdge(int from, int to) {
        if (hasEdge(from, to)) {
            edges[from].remove(to);
            numEdges--;
        }
    }

    /**
     * Returns a string representation of this graph.
     *
     * Should represent the graph in terms of edges (order does not matter).
     * For example, if a graph has edges (2,3) and (1,0) with NO_COST, the
     * representation should be:
     *
     * "{(1,0), (2,3)}" or "{(2,3), (1,0)}"
     *
     * If an edge has a cost (say, 5), it is added as a third value, like so:
     *
     * "{(1,0,5)}"
     *
     * An empty graph is just braces:
     *
     * "{}"
     *
     * @return a String representation of this graph
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (edges.length == 0) {
            return "{}";
        } else {
            for (int i = 0; i < edges.length; i++) {
                Map<Integer, Integer> adjacencyMap = edges[i];
                if (adjacencyMap != null) {
                    for (Map.Entry<Integer, Integer> entry : adjacencyMap.entrySet()) {
                        Integer key = entry.getKey();
                        Integer value = entry.getValue();
                        if (entry.getValue() == NO_COST) {
                            sb.append("(" + i + "," + key + "), ");
                        } else {
                            sb.append("(" + i + "," + key + "," + value + "), ");
                        }
                    }
                }
            }
        }
        if (numEdges > 0)
            sb.setLength(sb.length() - 2); // Remove trailing ", "
        sb.append("}");
        return sb.toString();
    }

    /**
     * Checks a single vertex parameter v.
     *
     * @throws IllegalArgumentException
     *             if v is out of range
     */
    private void checkVertexParameter(int v) {
        if (v < 0 || v >= numVertices())
            throw new IllegalArgumentException("Out of range: v = " + v + ".");
    }

    /**
     * Checks two vertex parameters v and w.
     *
     * @throws IllegalArgumentException
     *             if v or w is out of range
     */
    private void checkVertexParameters(int v, int w) {
        if (v < 0 || v >= numVertices() || w < 0 || w >= numVertices())
            throw new IllegalArgumentException("Out of range: v = " + v + ", w = " + w + ".");
    }
}

