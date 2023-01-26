import java.util.ArrayList;
import java.util.Arrays;

class Graph {
    
    int noNodes;
    int noEdges;
    Edge[] edges;
    Node[] nodes;
    
    Graph( int noNodes,
           int noEdges ) {
        this.noNodes = noNodes;
        this.noEdges = noEdges;
        
        initEdges();
    }
    
    private void initEdges() {
        edges = new Edge[noEdges];
        for (int i = 0; i < noEdges; ++i) {
            edges[i] = new Edge();
        }
    }
    
    public ArrayList<Edge> getKruskalMST() {
        ArrayList<Edge> mst = new ArrayList<>();
        initNodes();
        sortEdges();
        for (Edge edge : edges) {
            if (mst.size() >= nodes.length - 1) {
                break;
            }
            int xTop = findTopSimple(edge.x);
            int yTop = findTopSimple(edge.y);
            if (xTop != yTop) {
                mst.add(edge);
                mergeClouds(xTop, yTop);
            }
        }
        return mst;
    }
    
    private void initNodes() {
        nodes = new Node[noNodes];
        for (int i = 0; i < noNodes; i++) {
            nodes[i] = new Node(i, 0);
        }
    }
    
    private void sortEdges() {
        Arrays.sort(edges);
    }
    
    private int findTopSimple( int v ) {
        int top = v;
        while (top != nodes[top].next) {
            top = nodes[top].next;
        }
        return top;
    }
    
    /**
     * find root using Path Compression method
     *
     * @param v start node
     * @return top number
     */
    private int findTop( int v ) {
        if (nodes[v].next == v) {
            return v;
        }
        int top = findTop(nodes[v].next);
        nodes[v].next = top;
        return top;
    }
    
    private void mergeClouds( int xTop,
                              int yTop ) {
        Node x = nodes[xTop];
        Node y = nodes[yTop];
        
        if (x.rank < y.rank) {
            x.next = yTop;
        } else if (x.rank > y.rank) {
            y.next = xTop;
        } else {
            x.next = yTop;
            y.rank++;
        }
    }
    
}
