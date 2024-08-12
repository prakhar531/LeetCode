class KthLargest {

    private int size = 0;
    private final int k;
    private final int[] heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new int[k + 1];
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        
        if (size == k) {
            if (val < heap[1]) {
                return heap[1];
            }
            pop();
        }

        heap[++size] = val;

        int index = size;
        int parent = size / 2;

        while (heap[parent] > heap[index] && index > 1) {

            int temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;

            index = parent;
            parent = parent / 2;
        }

        return heap[1];
    }

    public void pop() {
        heap[1] = heap[size--];

        int index = 1;
        while (index <= size / 2) {
            int left = index * 2;
            int right = (index * 2) + 1;

            if (heap[index] > heap[left] || heap[index] > heap[right]) {
                if (heap[left] < heap[right]) {
                    int temp = heap[left];
                    heap[left] = heap[index];
                    heap[index] = temp;
                    index = left;
                } else {
                    int temp = heap[right];
                    heap[right] = heap[index];
                    heap[index] = temp;
                    index = right;
                }
            } else {
                break;
            }
        }
    }

}