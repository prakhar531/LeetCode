// class Solution {
//     public boolean isNStraightHand(int[] hand, int groupSize) {
//         if(hand.length%groupSize!=0) return false;
//         PriorityQueue<Integer> pq=new PriorityQueue<>();

//         for(int it:hand){
//             pq.add(it);
//         }
//         while(pq.size()!=0){
//             int last=pq.poll();
//             int s=groupSize-1;
//             List<Integer> list=new ArrayList<>();
//             while(s!=0 && pq.size()!=0){
//                 int curr=pq.poll();
//                 if(curr==last){
//                     list.add(curr);
//                 }else if(curr==last+1){
//                     last=curr;
//                     s--;
//                 }else{
//                     return false;
//                 }
//             }
//             while(list.size()!=0) pq.add(list.remove(list.size()-1));
//             if(s!=0) return false;
//         }
//         return true;
//     }
// }

class Solution {
    public boolean findsucessors(int[] hand, int groupSize, int i, int n) {
        int f = hand[i] + 1;
        hand[i] = -1;
        int count = 1;
        i += 1;
        while (i < n && count < groupSize) {
            if (hand[i] == f) {
                f = hand[i] + 1;
                hand[i] = -1;
                count++;
            }
            i++;
        }
        if (count != groupSize)
            return false;
        else
            return true;
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0)
            return false;
        Arrays.sort(hand);
        int i = 0;
        for (; i < n; i++) {
            if (hand[i] >= 0) {
                if (!findsucessors(hand, groupSize, i, n))
                    return false;
            }
        }
        return true;
    }
}