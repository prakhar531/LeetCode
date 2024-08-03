class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int max=0;
        for(int it:target){
            max=Math.max(it,max);
        }
        int count[]=new int[max+1];
        int count2[]=new int[max+1];
    
        for(int i=0;i<arr.length;i++){
            count[target[i]]++;
            if(arr[i]>max) return false;
            count2[arr[i]]++;
        }
        for(int i=1;i<max+1;i++){
            if(count[i]!=count2[i]) return false;
        }
        return true;
        
    }
}