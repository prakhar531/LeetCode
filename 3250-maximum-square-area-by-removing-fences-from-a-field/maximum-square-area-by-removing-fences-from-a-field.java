import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Arrays.sort(hFences);
        Arrays.sort(vFences);

        List<Integer> horizontal = new ArrayList<>();
        for (int fence : hFences) {
            horizontal.add(fence);
        }
        horizontal.add(0, 1);
        horizontal.add(m);

        List<Integer> vertical = new ArrayList<>();
        for (int fence : vFences) {
            vertical.add(fence);
        }
        vertical.add(0, 1);
        vertical.add(n);

        int ans = -1;
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int i = 0; i < horizontal.size(); i++) {
            for (int j = i + 1; j < horizontal.size(); j++) {
                cnt.put(horizontal.get(j) - horizontal.get(i), 1);
            }
        }

        for (int i = 0; i < vertical.size(); i++) {
            for (int j = i + 1; j < vertical.size(); j++) {
                if (cnt.containsKey(vertical.get(j) - vertical.get(i))) {
                    ans = Math.max(ans, vertical.get(j) - vertical.get(i));
                }
            }
        }

        if (ans == -1) return ans;

        int mod = 1000000007;
        return (int) ((1L * ans * ans) % mod);
    }
}
