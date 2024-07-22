// class Solution {
//     public static void reverse(int[] array)
//     {
//         // Length of the array
//         int n = array.length;

//         // Swapping the first half elements 
//         // With last Half Elements
//         for (int i = 0; i < n / 2; i++) {

//             // Storing the first half elements temporarily
//             int temp = array[i];

//             // Assigning the first half
//               // to the last half
//             array[i] = array[n - i - 1];

//             // Assigning the last half
//             // to the first half
//             array[n - i - 1] = temp;
//         }
//     }
//     public String[] sortPeople(String[] n, int[] h) {
//         Map<Integer,Integer> map=new HashMap<>();
//         for(int i=0;i<n.length;i++){
//             map.put(h[i],i);
//         }
//         Arrays.sort(h);
//         reverse(h);
//         String[] ans=new String[n.length];
//         for(int i=0;i<n.length;i++){
//             ans[i]=n[map.get(h[i])];
//         }
//         return ans;
//     }
// }

// class Solution {
//     private <T> void insertionSortReverseOrder(int[] main, T[] side, int left, int right) {
//             for(int i = left+1; i <= right; i++) {
//                 for(int j = i - 1; j >= 0; j--) {
//                     if(main[j+1] > main[j]) { // reverse order
//                         int t = main[j+1];
//                         main[j+1] = main[j];
//                         main[j] = t;

//                         T tT = side[j+1];
//                         side[j+1] = side[j];
//                         side[j] = tT;
//                     }else break;
//                 }
//             }
//         }
//         private <T> void quickSortReverseOrder(int[] main, T[] side, int left, int right) {
//             if(left >= right) return;
//             if(right - left <= 11) {
//                 // Do insertion sort
//                 insertionSortReverseOrder(main, side, left, right);
//                 return;
//             }
//             // Choose pivot of median between left, left+1, left+2
//             int pivot;
//             {
//                 int aV = main[left], bV = main[left+1], cV = main[left+2];
//                 if(aV <= bV && aV <= cV) {
//                     // a is smallest
//                     pivot = bV <= cV ? (left+1) : (left+2);
//                 }else if(bV <= aV && bV <= cV) {
//                     // b is smallest
//                     pivot = aV <= cV ? (left) : (left+2);
//                 }else {
//                     // c is smallest
//                     pivot = aV <= bV ? (left) : (left+1);
//                 }
//             }

//             int val = main[pivot];
//             { // swap pivot with right
//                 main[pivot] = main[right];
//                 main[right] = val;
//             }
//             {
//                 T x = side[pivot];
//                 side[pivot] = side[right];
//                 side[right] = x;
//             }
//             int L = left, R = right - 1;
//             while(true) {
//                 while(L <= R && main[L] >= val) L++; // Reverse order
//                 while(L <= R && main[R] <= val) R--;
//                 if(L < R) {
//                     { // swap idx L and R
//                         int z = main[L];
//                         main[L] = main[R];
//                         main[R] = z;
//                     }
//                     {
//                         T z = side[L];
//                         side[L] = side[R];
//                         side[R] = z;
//                     }
//                     L++; R--;
//                 }else {
//                     break;
//                 }
//             }
//             { // swap idx L and right
//                 int z = main[L];
//                 main[L] = main[right];
//                 main[right] = z;
//             }
//             {
//                 T z = side[L];
//                 side[L] = side[right];
//                 side[right] = z;
//             }
//             quickSortReverseOrder(main, side, left, L-1);
//             quickSortReverseOrder(main, side, L+1, right);
//         }
//     public String[] sortPeople(String[] names, int[] heights) {
//         quickSortReverseOrder(heights, names, 0, names.length-1);
//         return names;
//     }
// }

class Solution {

    public String[] sortPeople(String[] names, int[] heights) {
        mergeSort(names, heights, 0, heights.length - 1);
        return names;
    }

    private void mergeSort(String[] names, int[] heights, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(names, heights, start, mid);
            mergeSort(names, heights, mid + 1, end);
            merge(names, heights, start, mid, end);
        }
    }

    private void merge(
        String[] names,
        int[] heights,
        int start,
        int mid,
        int end
    ) {
        int leftSize = mid - start + 1;
        int rightSize = end - mid;

        // Create temporary arrays
        int[] leftHeights = new int[leftSize];
        int[] rightHeights = new int[rightSize];
        String[] leftNames = new String[leftSize];
        String[] rightNames = new String[rightSize];

        // Copy data to temporary arrays
        for (int i = 0; i < leftSize; i++) {
            leftHeights[i] = heights[start + i];
            leftNames[i] = names[start + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightHeights[j] = heights[mid + 1 + j];
            rightNames[j] = names[mid + 1 + j];
        }

        // Merge the temporary arrays
        int leftIndex = 0, rightIndex = 0;
        int mergeIndex = start;
        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftHeights[leftIndex] >= rightHeights[rightIndex]) { // Descending order
                heights[mergeIndex] = leftHeights[leftIndex];
                names[mergeIndex] = leftNames[leftIndex];
                leftIndex++;
            } else {
                heights[mergeIndex] = rightHeights[rightIndex];
                names[mergeIndex] = rightNames[rightIndex];
                rightIndex++;
            }
            mergeIndex++;
        }

        // Copy remaining elements of leftHeights[], if any
        while (leftIndex < leftSize) {
            heights[mergeIndex] = leftHeights[leftIndex];
            names[mergeIndex] = leftNames[leftIndex];
            leftIndex++;
            mergeIndex++;
        }

        // Copy remaining elements of rightHeights[], if any
        while (rightIndex < rightSize) {
            heights[mergeIndex] = rightHeights[rightIndex];
            names[mergeIndex] = rightNames[rightIndex];
            rightIndex++;
            mergeIndex++;
        }
    }
}