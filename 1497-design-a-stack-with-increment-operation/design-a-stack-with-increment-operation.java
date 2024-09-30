class CustomStack {

    // Array to store stack elements
    private int[] stackArray;
    // Index of the top element in the stack
    private int topIndex;

    public CustomStack(int maxSize) {
        stackArray = new int[maxSize];
        topIndex = -1;
    }

    public void push(int x) {
        if (topIndex < stackArray.length - 1) {
            stackArray[++topIndex] = x;
        }
    }

    public int pop() {
        if (topIndex >= 0) {
            return stackArray[topIndex--];
        }
        return -1; // Return -1 if the stack is empty
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, topIndex + 1);
        for (int i = 0; i < limit; i++) {
            stackArray[i] += val;
        }
    }
}