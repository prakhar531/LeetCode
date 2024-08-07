// class Solution {
//     // Arrays to store words for numbers less than 10, 20, and 100
//     private static final String[] belowTen = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
//     private static final String[] belowTwenty = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
//     private static final String[] belowHundred = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

//     // Main function to convert a number to English words
//     public String numberToWords(int num) {
//         // Handle the special case where the number is zero
//         if (num == 0) {
//             return "Zero";
//         }
//         // Call the helper function to start the conversion
//         return convertToWords(num);
//     }

//     // Recursive function to convert numbers to words
//     // Handles numbers based on their ranges: <10, <20, <100, <1000, <1000000, <1000000000, and >=1000000000
//     private String convertToWords(int num) {
//         if (num < 10) {
//             return belowTen[num];
//         }
//         if (num < 20) {
//             return belowTwenty[num - 10];
//         }
//         if (num < 100) {
//             return belowHundred[num / 10] + (num % 10 != 0 ? " " + convertToWords(num % 10) : "");
//         }
//         if (num < 1000) {
//             return convertToWords(num / 100) + " Hundred" + (num % 100 != 0 ? " " + convertToWords(num % 100) : "");
//         }
//         if (num < 1000000) {
//             return convertToWords(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + convertToWords(num % 1000) : "");
//         }
//         if (num < 1000000000) {
//             return convertToWords(num / 1000000) + " Million" + (num % 1000000 != 0 ? " " + convertToWords(num % 1000000) : "");
//         }
//         return convertToWords(num / 1000000000) + " Billion" + (num % 1000000000 != 0 ? " " + convertToWords(num % 1000000000) : "");
//     }
// }

class Solution {
    public String numberToWords(int num) {
        // Handle the special case where the number is zero
        if (num == 0) return "Zero";

        // Arrays to store words for single digits, tens, and thousands
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = {"", "Thousand", "Million", "Billion"};

        // StringBuilder to accumulate the result
        StringBuilder result = new StringBuilder();
        int groupIndex = 0;

        // Process the number in chunks of 1000
        while (num > 0) {
            // Process the last three digits
            if (num % 1000 != 0) {
                StringBuilder groupResult = new StringBuilder();
                int part = num % 1000;

                // Handle hundreds
                if (part >= 100) {
                    groupResult.append(ones[part / 100]).append(" Hundred ");
                    part %= 100;
                }

                // Handle tens and units
                if (part >= 20) {
                    groupResult.append(tens[part / 10]).append(" ");
                    part %= 10;
                }

                // Handle units
                if (part > 0) {
                    groupResult.append(ones[part]).append(" ");
                }

                // Append the scale (thousand, million, billion) for the current group
                groupResult.append(thousands[groupIndex]).append(" ");
                // Insert the group result at the beginning of the final result
                result.insert(0, groupResult);
            }
            // Move to the next chunk of 1000
            num /= 1000;
            groupIndex++;
        }

        return result.toString().trim();
    }
}