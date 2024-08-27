class DisjointSet {
    int[] parent, size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; 
            size[i] = 1;    
        }
    }

    public int findUpar(int node) {
        if (node == parent[node]) {
            return node;  
        }
        return parent[node] = findUpar(parent[node]);  
    }

    public void unionBySize(int u, int v) {
        int rootU = findUpar(u);
        int rootV = findUpar(v);

        if (rootU != rootV) {
            if (size[rootU] < size[rootV]) {
                parent[rootU] = rootV; 
                size[rootV] += size[rootU];  
            } else {
                parent[rootV] = rootU;  
                size[rootU] += size[rootV];  
            }
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> mapMail = new HashMap<>();

        // Step 1: Build the Disjoint Set
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!mapMail.containsKey(mail)) {
                    mapMail.put(mail, i);  // Associate this email with the current index
                } else {
                    ds.unionBySize(i, mapMail.get(mail));  // Union current index with the index stored in map
                }
            }
        }

        // Step 2: Merge the emails
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++)
            mergedMail[i] = new ArrayList<>();

        for (Map.Entry<String, Integer> it : mapMail.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUpar(it.getValue());
            mergedMail[node].add(mail);
        }

        // Step 3: Prepare the result
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0) continue;

            Collections.sort(mergedMail[i]);  // Sort the emails
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));  // Add the account name

            temp.addAll(mergedMail[i]);  // Add all the emails
            ans.add(temp);
        }
        return ans;
    }
}