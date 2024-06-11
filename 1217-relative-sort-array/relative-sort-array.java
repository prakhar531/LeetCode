class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> remaining = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        // Initialize count map with relative order elements
        for (int value : arr2) {
            countMap.put(value, 0);
        }

        // Count occurrences of elements in target array
        for (int value : arr1) {
            if (countMap.containsKey(value)) {
                countMap.put(value, countMap.get(value) + 1);
            } else {
                remaining.add(value);
            }
        }

        // Sort the remaining elements
        Collections.sort(remaining);

        // Add elements as per relative order
        for (int value : arr2) {
            for (int j = 0; j < countMap.get(value); j++) {
                result.add(value);
            }
        }

        // Add remaining elements
        result.addAll(remaining);

        // Convert ArrayList to array
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}