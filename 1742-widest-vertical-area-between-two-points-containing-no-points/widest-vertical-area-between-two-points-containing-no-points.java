class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        // Arrays.sort(points, (a, b) -> Integer.compare(a[0],b[0]));
        // int ans=Integer.MIN_VALUE;
        // for(int i=1;i<points.length;i++){
        //     ans=Math.max(ans,points[i][0]-points[i-1][0]);
        // }
        // return ans;

        int arr[]=new int[points.length];
        for(int i=0;i<points.length;i++){
            arr[i]=points[i][0];
        }
        Arrays.sort(arr);
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<points.length;i++){
            if(ans<arr[i]-arr[i-1]) ans=arr[i]-arr[i-1];
        }
        return ans;
    }
}