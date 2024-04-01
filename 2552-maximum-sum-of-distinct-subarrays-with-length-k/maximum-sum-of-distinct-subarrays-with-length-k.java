class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        // int n=nums.length;
        // if(n<k) return 0;
        // long ans=0;
        // long sum=0;
        // HashMap<Integer,Integer> map=new HashMap<>();
        // int i=0;
        // while(i<k-1){
        //     sum+=nums[i];
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        //     i++;
        // }
        // for(;i<n;i++){
        //     sum+=nums[i];
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        //     if(map.size()==k){
        //         ans=Math.max(ans,sum);
        //     }

            
        //     if(map.get(nums[i-k+1])==1) map.remove(nums[i-k+1]);
        //     else map.put(nums[i-k+1],map.get(nums[i-k+1])-1);

        //     sum-=nums[i-k+1];
        // }
        // return ans;
        int size = nums.length;
        int minNum = nums[0];
        int maxNum = nums[0];
        for (int idx = 1; idx < size; idx++) {
            if (nums[idx] < minNum) {
                minNum = nums[idx];
            } else if (nums[idx] > maxNum) {
                maxNum = nums[idx];
            }
        }

        if (k == 1) {
            return maxNum;
        }

        if (minNum == maxNum) {
            return 0L;
        }

        int range = maxNum - minNum + 1; // 9
        int[] windowSet = new int[range]; // [1,0,0,0,0,0,0,0,0]
        int windowSize = 0;
        int minIdx = 0;
        long windowSum = 0L;
        long maxWindowSum = 0L;
        for (int idx = 0; idx < size; idx++) {
            while (windowSet[nums[idx] - minNum] != 0) {
                windowSet[nums[minIdx] - minNum] = 0;
                windowSize--;
                windowSum -= nums[minIdx];
                minIdx++;
            }
            windowSet[nums[idx] - minNum] = idx + 1;
            windowSize++;
            windowSum += nums[idx];
            if (windowSize == k) {
                if (maxWindowSum < windowSum) {
                    maxWindowSum = windowSum;
                }
                windowSet[nums[minIdx] - minNum] = 0;
                windowSize--;
                windowSum -= nums[minIdx];
                minIdx++;
            }
        }
        return maxWindowSum;
        
    }
}