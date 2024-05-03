class Solution {
    public String remove(String str){
        int i=0;
        while(i<str.length()&&str.charAt(i)=='0') i++;
        return str.substring(i);
    }
    public int compare(String str1, String str2){
        int i=str1==""?0:Integer.parseInt(str1);
        int j=str2==""?0:Integer.parseInt(str2);
        if(i==j) return 0;
        if(i>j) return 1;
        return -1;
    }
    public int compareVersion(String version1, String version2) {
        String arr1[]=version1.split("[.]");
        String arr2[]=version2.split("[.]");

        for(int i=0;i<arr1.length;i++) arr1[i]=remove(arr1[i]);
        for(int i=0;i<arr2.length;i++) arr2[i]=remove(arr2[i]);
        int ans=0;
        int j=0;
        for( j=0;j<Math.min(arr1.length,arr2.length);j++){
            int val=compare(arr1[j],arr2[j]);
            if(val!=0){
                ans=val>0?1:-1;
                return ans;
            }
        }
        while(j<arr1.length){
            if(compare(arr1[j],"0")>0) ans=1;
            j++;
        }
        while(j<arr2.length){
            if(compare(arr2[j],"0")>0) ans=-1;
            j++;
        }
        return ans;
    }
}