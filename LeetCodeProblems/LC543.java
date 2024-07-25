class Solution {
    static class TreeInfo {
        int ht;
        int diam;

        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return diameterHelper(root).diam;
    }

    private TreeInfo diameterHelper(TreeNode root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameterHelper(root.left);
        TreeInfo right = diameterHelper(root.right);

        int height = Math.max(left.ht, right.ht) + 1;

        int dia1 = left.diam;
        int dia2 = right.diam;
        int dia3 = left.ht + right.ht;

        int diameter = Math.max(Math.max(dia1, dia2), dia3);

        return new TreeInfo(height, diameter);
    }
}