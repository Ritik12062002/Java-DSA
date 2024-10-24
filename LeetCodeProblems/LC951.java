class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {

            TreeNode currNode1 = q1.remove();
            TreeNode currNode2 = q2.remove();

            if (currNode1.val != currNode2.val) return false;

            TreeNode left1 = currNode1.left, right1 = currNode1.right;
            TreeNode left2 = currNode2.left, right2 = currNode2.right;

            // Check for equivalence in both normal and flipped states
            if ((areNodesEqual(left1, left2) && areNodesEqual(right1, right2)) ||
                (areNodesEqual(left1, right2) && areNodesEqual(right1, left2))) {

                if (areNodesEqual(left1, left2)) {
                    if (left1 != null) q1.add(left1);
                    if (right1 != null) q1.add(right1);
                    if (left2 != null) q2.add(left2);
                    if (right2 != null) q2.add(right2);
                } else {
                    if (left1 != null) q1.add(left1);
                    if (right1 != null) q1.add(right1);
                    if (right2 != null) q2.add(right2);
                    if (left2 != null) q2.add(left2);
                }
            } else {
                return false;
            }
        }
        return q1.isEmpty() && q2.isEmpty();
    }

    private boolean areNodesEqual(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        return node1.val == node2.val;
    }
}