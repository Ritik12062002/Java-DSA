
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class DisjointSet {
    int[] parent, size;

    DisjointSet(int V) {
        parent = new int[V];
        size = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findUpar(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findUpar(parent[node]);
    }

    void unionBySize(int u, int v) {
        int uPar = findUpar(u);
        int vPar = findUpar(v);

        if (uPar == vPar) return;

        if (size[uPar] < size[vPar]) {
            parent[uPar] = vPar;
            size[vPar] += size[uPar];
        } else {
            parent[vPar] = uPar;
            size[uPar] += size[vPar];
        }
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<Edge> edges = new ArrayList<>();

        // Convert adjacency list to edge list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j)[0];
                int wt = adj.get(i).get(j)[1];

                // Since the graph is undirected, add each edge only once
                if (i < adjNode) {
                    Edge temp = new Edge(i, adjNode, wt);
                    edges.add(temp);
                }
            }
        }

        // Sort all edges by their weight
        Collections.sort(edges);

        // Initialize the disjoint set
        DisjointSet ds = new DisjointSet(V);
        int mstWt = 0;

        // Process all edges in order
        for (int i = 0; i < edges.size(); i++) {
            int wt = edges.get(i).weight;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;

            // If u and v are in different components, add the edge to the MST
            if (ds.findUpar(u) != ds.findUpar(v)) {
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }

        return mstWt;
    }
}