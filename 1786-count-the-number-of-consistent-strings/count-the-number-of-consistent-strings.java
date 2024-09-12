class Solution {

    public int countConsistentStrings(String allowed, String[] words) {
        // Create a set to store the allowed characters
        Set<Character> allowedChars = new HashSet<>();

        // Populate the set with characters from the 'allowed' string
        for (int i = 0; i < allowed.length(); i++) {
            allowedChars.add(allowed.charAt(i));
        }

        int consistentCount = 0;

        // Iterate through each word in the 'words' array
        for (String word : words) {
            boolean isConsistent = true;

            // Check each character of the current word
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);

                // If the character is not in the allowedChars set, mark as inconsistent and break
                if (!allowedChars.contains(currentChar)) {
                    isConsistent = false;
                    break;
                }
            }

            // If the word is consistent, increment the count
            if (isConsistent) {
                consistentCount++;
            }
        }

        // Return the total count of consistent strings
        return consistentCount;
    }
}