class Solution {
    public int getValue(int[][] img,int row,int col){
        int sum=0;
        int count=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int rowidx=row+i;
                int colidx=col+j;
                if(rowidx<0 || colidx<0 || rowidx>=img.length || colidx>=img[0].length) continue;
                sum+=img[rowidx][colidx];
                count++; 
            }
        }
        return (sum)/count;
    }

    public int[][] imageSmoother(int[][] img) {
        int ans[][]=new int[img.length][img[0].length];

        for(int i=0;i<img.length;i++){
            for(int j=0;j<img[0].length;j++){
                ans[i][j]=getValue(img,i,j);
            }
        }

        return ans;
    }
}