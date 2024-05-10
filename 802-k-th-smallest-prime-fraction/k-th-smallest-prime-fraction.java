// class Solution {
//     public int[] kthSmallestPrimeFraction(int[] arr, int k) {
//         int n = arr.length;
//         double left = 0, right = 1.0;
        
//         // Binary search for finding the kth smallest prime fraction
//         while (left < right) {
//             // Calculate the middle value
//             double mid = (left + right) / 2;
            
//             // Initialize variables to keep track of maximum fraction and indices
//             double maxFraction = 0.0;
//             int totalSmallerFractions = 0, numeratorIdx = 0, denominatorIdx = 0;
//             int j = 1;
            
//             // Iterate through the array to find fractions smaller than mid
//             for (int i = 0; i < n - 1; i++) {
//                 while (j < n && arr[i] >= mid * arr[j]) {
//                     j++;
//                 }

//                 // Count smaller fractions
//                 totalSmallerFractions += (n - j);

//                 // If we have exhausted the array, break
//                 if (j == n) break;

//                 // Calculate the fraction
//                 double fraction = (double) arr[i] / arr[j];

//                 // Update maxFraction and indices if necessary
//                 if (fraction > maxFraction) {
//                     numeratorIdx = i;
//                     denominatorIdx = j;
//                     maxFraction = fraction;
//                 }
//             }

//             // Check if we have found the kth smallest prime fraction
//             if (totalSmallerFractions == k) {
//                 return new int[]{arr[numeratorIdx], arr[denominatorIdx]};
//             } else if (totalSmallerFractions > k) {
//                 right = mid; // Adjust the range for binary search
//             } else {
//                 left = mid; // Adjust the range for binary search
//             }
//         }
//         return new int[]{}; // Return empty array if kth smallest prime fraction not found
//     }
// }

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // Create a priority queue to store pairs of fractions
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Push the fractions formed by dividing each element by
        // the largest element into the priority queue
        for (int i = 0; i < arr.length; i++) {
            pq.offer(new double[] {
                -1.0 * arr[i] / arr[arr.length - 1], 
                i, 
                arr.length - 1
            });
        }

        // Iteratively remove the top element (smallest fraction) 
        // and replace it with the next smallest fraction
        while (--k > 0) {
            double[] cur = pq.poll();
            int numeratorIndex = (int) cur[1];
            int denominatorIndex = (int) cur[2] - 1;
            if (denominatorIndex > numeratorIndex) {
                pq.offer(new double[] {
                        -1.0 * arr[numeratorIndex] / arr[denominatorIndex], 
                        numeratorIndex, 
                        denominatorIndex
                });
            }
        }

        // Retrieve the kth smallest fraction from 
        // the top of the priority queue
        double[] result = pq.poll();
        return new int[]{arr[(int) result[1]], arr[(int) result[2]]};
    }
}