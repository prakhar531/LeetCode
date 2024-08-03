// class Solution {
//     public boolean canBeEqual(int[] target, int[] arr) {
//         int max=0;
//         for(int it:target){
//             max=Math.max(it,max);
//         }
//         int count[]=new int[max+1];
//         int count2[]=new int[max+1];
    
//         for(int i=0;i<arr.length;i++){
//             count[target[i]]++;
//             if(arr[i]>max) return false;
//             count2[arr[i]]++;
//         }
//         for(int i=1;i<max+1;i++){
//             if(count[i]!=count2[i]) return false;
//         }
//         return true;
        
//     }
// }

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n = target.length, m = arr.length;

        if (n != m) return false;

        int[] map = new int[1001];

        for (int i = 0; i < n; i++) {
            map[target[i]]++;
            map[arr[i]]--;
        }

        for (int i = 0; i < n; i++) {
            if (map[target[i]] != 0 || map[arr[i]] != 0) {
                return false;
            }
        }

        return true;
    }
}