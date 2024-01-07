class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Set<Integer> s1 = new HashSet<>();
        for (int i : nums1) {
            s1.add(i);
        }
        
        Set<Integer> s2 = new HashSet<>();
        for (int i : nums2) {
            s2.add(i);
        }
        
        Set<Integer> common = new HashSet<>();
        for (int i : s2) {
            if (s1.contains(i)) {
                common.add(i);
            }
        }
        
        int res1 = 0;
        for (int i : s1) {
            if (!common.contains(i)) {
                res1++;
                if (res1 == n / 2) {
                    break;
                }
            }
        }
        int res2 = 0;
        for (int i : s2) {
            if (!common.contains(i)) {
                res2++;
                if (res2 == n / 2) {
                    break;
                }
            }
        }
        
        return res2 + res1 + Math.min(n - res1 - res2, common.size());
    }
}