class Solution {
    public void reverse(int[] arr){
        int i=0,j=arr.length-1;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public String[] findRelativeRanks(int[] score) {
        int arr[]=new int[score.length];
        for(int i=0;i<score.length;i++){
            arr[i]=score[i];
        }
        Arrays.sort(arr);
        reverse(arr);
        HashMap<Integer,String> map=new HashMap<>();
        for(int i=0;i<score.length;i++){
            map.put(arr[i],Integer.toString(i+1));
        }
        String[] ans=new String[score.length];
        for(int i=0;i<score.length;i++){
            ans[i]=map.get(score[i]);
        }
        for(int i=0;i<score.length;i++){
            if(ans[i].equals("1")){
                ans[i]="Gold Medal";
            } 
            if(ans[i].equals("2")){
                ans[i]="Silver Medal";
            } 
            if(ans[i].equals("3")){
                ans[i]="Bronze Medal";
            } 
        }
        return ans;
    }
}