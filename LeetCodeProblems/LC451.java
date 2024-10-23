class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap<>();

        
        for (char ch : s.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        // Max heap to store characters by their frequencies in decreasing order
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> hm.get(b) - hm.get(a));
        pq.addAll(hm.keySet());

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            char currentChar = pq.poll();
            int count = hm.get(currentChar);

            for (int i = 0; i < count; i++) {
                sb.append(currentChar);
            }
        }

        return sb.toString();
    }
}