class Solution {
  public String shortestPalindrome(String s) {
    // Reverse the input string 's'
    final String t = new StringBuilder(s).reverse().toString();

    // Iterate through the reversed string 't'
    for (int i = 0; i < t.length(); i++) {
      // Check if the original string 's' starts with the current suffix of 't'
      // The substring from index 'i' onwards is compared with the start of 's'
      if (s.startsWith(t.substring(i))) {
        // If a matching prefix-suffix is found, return the result by adding
        // the unmatched part of 't' to the front of 's' to form the palindrome
        return t.substring(0, i) + s;
      }
    }

    // If no matching prefix-suffix is found, the entire reversed string 't'
    // is added in front of 's' to form the shortest palindrome
    return t + s;
  }
}