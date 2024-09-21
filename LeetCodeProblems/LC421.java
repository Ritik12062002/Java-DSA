class Node {
    Node[] links = new Node[2];

    public boolean containsKey(int ind) {
        return links[ind] != null;
    }

    public void put(int ind, Node newN) {
        links[ind] = newN;
    }

    public Node get(int ind) {
        return links[ind];
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int num) {
        Node node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                maxNum |= (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        for (int num : nums) {
            root.insert(num);
        }
        int xor = 0;
        for (int num : nums) {
            xor = Math.max(xor, root.getMax(num));
        }
        return xor;
    }
}
