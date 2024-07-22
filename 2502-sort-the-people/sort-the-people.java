class Solution {
    public static void reverse(int[] array)
    {
        // Length of the array
        int n = array.length;

        // Swapping the first half elements 
        // With last Half Elements
        for (int i = 0; i < n / 2; i++) {

            // Storing the first half elements temporarily
            int temp = array[i];

            // Assigning the first half
              // to the last half
            array[i] = array[n - i - 1];

            // Assigning the last half
            // to the first half
            array[n - i - 1] = temp;
        }
    }
    public String[] sortPeople(String[] n, int[] h) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n.length;i++){
            map.put(h[i],i);
        }
        Arrays.sort(h);
        reverse(h);
        String[] ans=new String[n.length];
        for(int i=0;i<n.length;i++){
            ans[i]=n[map.get(h[i])];
        }
        return ans;
    }
}