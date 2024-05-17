class Solution {
    public int nextBeautifulNumber(int n) {
        while(true){
            n++;
            int num=n;
            int freq[]=new int[10];

            while(num>0){
                int curr=num%10;
                num/=10;
                freq[curr]++;
                if(freq[curr]>curr) break;
            }
            boolean ans=true;

            for(int i=0;i<10;i++){
                if(freq[i]!=i && freq[i]!=0) ans=false;
            }
            if(ans==true) return n;
        }
        
    }
}