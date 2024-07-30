// // class Solution {

// //     public int minimumDeletions(String s) {
// //         int n = s.length();
// //         Stack<Character> charStack = new Stack<>();
// //         int deleteCount = 0;

// //         // Iterate through each character in the string
// //         for (int i = 0; i < n; i++) {
// //             // If stack is not empty, top of stack is 'b',
// //             // and current char is 'a'
// //             if (
// //                 !charStack.isEmpty() &&
// //                 charStack.peek() == 'b' &&
// //                 s.charAt(i) == 'a'
// //             ) {
// //                 charStack.pop(); // Remove 'b' from stack
// //                 deleteCount++; // Increment deletion count
// //             } else {
// //                 charStack.push(s.charAt(i)); // Push current character onto stack
// //             }
// //         }

// //         return deleteCount;
// //     }
// // }

// class Solution {

//     public int minimumDeletions(String s) {
//         int n = s.length();
//         int minDeletions = 0;
//         int bCount = 0;

//         // minDeletions variable represents dp[i]
//         for (int i = 0; i < n; i++) {
//             if (s.charAt(i) == 'b') {
//                 bCount++;
//             } else {
//                 // Two cases: remove 'a' or keep 'a'
//                 minDeletions = Math.min(minDeletions + 1, bCount);
//             }
//         }

//         return minDeletions;
//     }
// }

class Solution {
    public int minimumDeletions(String s) {
        char[] letters = s.toCharArray();
        int aCount = 0;
        int bCount = 0;
        int output = Integer.MAX_VALUE;
        for (int i = 0; i < letters.length; i++)
            aCount += ('b' - letters[i]);

        for (int i = 0; i < s.length(); i++)
        {
            output = Math.min(output, aCount + bCount);
            aCount -= ('b' - letters[i]);
            bCount += (letters[i] - 'a');
        }

        output = Math.min(output, aCount + bCount);
        return output;
    }
}