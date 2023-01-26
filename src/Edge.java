class Edge implements Comparable<Edge> {
    int x;
    int y;
    int weight;
    
    public int compareTo( Edge compareEdge ) {
        return this.weight - compareEdge.weight;
    }
    
    @Override
    public String toString() {
        return String.format("%d %d %d",
                             x,
                             y,
                             weight);
    }
}
