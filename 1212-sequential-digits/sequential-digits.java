// class Solution {
//     public List<Integer> sequentialDigits(int low, int high) {
//         int[] allNums = {12,23,34,45,56,67,78,89,
//                          123,234,345,456,567,678,789,
//                          1234,2345,3456,4567,5678,6789,
//                          12345,23456,34567,45678,56789,
//                          123456,234567,345678,456789,
//                          1234567,2345678,3456789,
//                          12345678,23456789,
//                          123456789};
//         List<Integer> res = new ArrayList<>();
//         int n = allNums.length;
//         for (int i = 0; i < n; i++) {
//             if (allNums[i] < low) continue;
//             if (allNums[i] > high) break;
//             res.add(allNums[i]);
//         }
//         return res;
//     }
// }

class Solution {
    public List<Integer> sequentialDigits(int low, int high){
        List<Integer> ans=new ArrayList<>();

        for(int i=1;i<=9;i++){
            int num=i;
            int nextNum=i+1;

            while(num<=high && nextNum<=9){
                num=num*10+nextNum;
                if(num>=low && num<=high){
                    ans.add(num);
                }
                nextNum++;
            }
        }
        Collections.sort(ans);
        return ans;

    }
}