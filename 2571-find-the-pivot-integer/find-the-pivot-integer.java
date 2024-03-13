// class Solution {
//     public int pivotInteger(int n) {
//         int arr1[]=new int[n];
//         int arr2[]=new int[n];
//         arr1[0]=1;
//         for(int i=1;i<n;i++) arr1[i]=arr1[i-1]+i+1;

//         arr2[n-1]=n;
        
//         for(int i=n-2;i>=0;i--) arr2[i]=arr2[i+1]+i+1;

//         for(int i=0;i<n;i++) if(arr1[i]==arr2[i]) return i+1;

//         return -1;
//     }
// }

// class Solution {
//     public int pivotInteger(int n) {
//         int[] prefs = new int[n + 1];
//         for (int i = 1; i < n + 1; i++) {
//             prefs[i] = prefs[i - 1] + i;
//         }

//         for (int i = 1; i < n + 1; i++) {
//             if (prefs[i] == prefs[n] - prefs[i - 1])
//                 return i;
//         }

//         return -1;
//     }
// }

class Solution {
    public int pivotInteger(int n) {
        int y = n*(n+1)/2;
        int x = (int)Math.sqrt(y);
        if(x*x==y) return x;
        else return -1;
    }
}