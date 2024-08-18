// class Solution {
//     public int nthUglyNumber(int n) {
//         PriorityQueue<Long> pq=new PriorityQueue<>();
//         pq.add(1l);
//         for(int i=0;i<n-1;i++){
//             long val=pq.remove();
//             while(!pq.isEmpty() && pq.peek()==val) pq.poll();
//             pq.add(val*2);
//             pq.add(val*3);
//             pq.add(val*5);
//         }
//         return pq.remove().intValue();    
//     }
// }

class Ugly{
public int[] nums = new int[1690];
Ugly(){
    nums[0] = 1;
    int ugly,i2 = 0,i3=0,i5=0;

    for(int i=1;i<1690;i++){
        ugly = Math.min(Math.min(nums[i2]*2,nums[i3]*3),nums[i5]*5);
        nums[i] = ugly;

        if(ugly == nums[i2]*2) ++i2;
        if(ugly == nums[i3]*3) ++i3;
        if(ugly == nums[i5]*5) ++i5;
        
    }
}
}
class Solution {
    public static Ugly u = new Ugly();
    public int nthUglyNumber(int n) {
        return u.nums[n-1];
    }
}