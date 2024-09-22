//using  Trie Ds



class Node{
    Node links[] = new Node[2];

    public boolean containsKey(int bit){
        return links[bit] != null;
    }

    void put(int bit, Node newN){
        links[bit]=newN;
    }

    Node next(int bit){
        return links[bit];
    }
}

class Trie{
    public static Node root;

    public Trie(){
        root= new Node();
    }

    public void insert(int num){
        Node node =root;

        for(int i=31;i>=0;i--){
            int bit= (num>>i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit, new Node());
            }

            node=node.next(bit);
        }
    }


    public int getMax(int num){
        Node node =root;
        int maxNum=0;

        for(int i=31;i>=0;i--){
            int bit =(num>>i) & 1;
            if(node.containsKey(1-bit)){
                maxNum |=(1<<i);
                node=node.next(1-bit);
            }else{
                node=node.next(bit);

            }
        }

        return maxNum;
    }
}



class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int ans[] = new int[queries.length];
        Trie root= new Trie();

        Arrays.sort(nums);

    // create  a list odf pairs(ai(xi,orginal index)); 

        List<int[]> q = new ArrayList<>();

        for(int i=0;i<queries.length;i++){
            q.add(new int[]{queries[i][1],queries[i][0],i});
        } 


        q.sort(Comparator.comparingInt(a -> a[0]));


        int ind =0;

        for(int i=0;i<q.size();i++){
            int ai= q.get(i)[0];
            int xi= q.get(i)[1];
            int qi= q.get(i)[2];


            while(ind < nums.length && nums[ind] <= ai){
                root.insert(nums[ind]);
                ind++;
            }

            if(ind==0){
                ans[qi]=-1;
            }
            else{
                ans[qi]=root.getMax(xi);
            }
        }

        return ans;
    }
}