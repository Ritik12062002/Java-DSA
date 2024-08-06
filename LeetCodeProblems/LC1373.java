class NodeValue {
    public int maxNode, minNode, sum;

    NodeValue(int maxNode, int minNode, int sum) {
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.sum = sum;
    }
};

class Solution {
    private int maxSum = 0;

    private NodeValue maxSumBSTHelper(TreeNode root) {
        if (root == null) {
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        NodeValue left = maxSumBSTHelper(root.left);
        NodeValue right = maxSumBSTHelper(root.right);

        if (left.maxNode < root.val && root.val < right.minNode) {
            int currentSum = left.sum + root.val + right.sum;
            maxSum = Math.max(maxSum, currentSum);
            return new NodeValue(
                Math.max(root.val, right.maxNode),
                Math.min(root.val, left.minNode),
                currentSum
            );
        }

       
        return new NodeValue(
            Integer.MAX_VALUE, 
            Integer.MIN_VALUE, 
            0 
        );
    }

    public int maxSumBST(TreeNode root) {
        maxSumBSTHelper(root);
        return maxSum;
    }
}
