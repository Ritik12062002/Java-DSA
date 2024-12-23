
class Solution {
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int operations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            operations += countMinSwaps(level);
        }

        return operations;
    }

    private int countMinSwaps(List<Integer> level) {
        int n = level.size();
        int[] arr = level.stream().mapToInt(i -> i).toArray();
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // Map original indices to sorted indices
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) indexMap.put(sorted[i], i);

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || indexMap.get(arr[i]) == i) continue;

            int cycleSize = 0;
            int j = i;

            // Follow the cycle
            while (!visited[j]) {
                visited[j] = true;
                j = indexMap.get(arr[j]);
                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }
}