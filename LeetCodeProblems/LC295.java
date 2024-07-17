class MedianFinder {
    private Queue<Integer> small; // Max-heap 
    private Queue<Integer> large; // Min-heap

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a); // Max-heap
        large = new PriorityQueue<>(); // Min-heap
    }

    public void addNum(int num) {
        // Add to max-heap
        small.add(num);
        // Balance the heaps
        large.add(small.poll());

        // Ensure the size property
        if (small.size() < large.size()) {
            small.add(large.poll());
        }
    }

    public double findMedian() {
        
        if (small.size() > large.size()) {
            return small.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}