class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // HashSet<Integer> set=new HashSet<>();
        // for(int i=0;i<flowerbed.length;i++){
        //     if(flowerbed[i]==1) set.add(i);
        // }
        // for(int i=0;i<flowerbed.length;i++){
        //     if(n==0) return true;
        //     if(flowerbed[i]==0){
        //         if(!set.contains(i-1) && !set.contains(i+1)){
        //             n--;
        //             set.add(i);
        //         }
        //     }
        // }
        // if(n==0) return true;
        // return false;

        int k=flowerbed.length;
        for(int i=0;i<k;i=i+2){
            if(flowerbed[i] == 0)
               if(i==flowerbed.length-1 || flowerbed[i]==flowerbed[i+1]){
                   n--;
               }
               else{
                   i++;
               }
        }
        return n<=0;
    }
}