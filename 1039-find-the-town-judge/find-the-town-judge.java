class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length==0 && n==1) return 1;
        boolean person[]=new boolean[n+1];
        for(int i=0;i<trust.length;i++){
           person[trust[i][0]]=true;
        }

        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<trust.length;i++){
            if(!map.containsKey(trust[i][1])){
                map.put(trust[i][1],new ArrayList<>());
            }
            map.get(trust[i][1]).add(trust[i][0]);
        }

        for(int i=1;i<person.length;i++){
           if(!person[i] && map.containsKey(i)){
               ArrayList<Integer> temp=map.get(i);
               if(temp.size()==n-1) return i;
           }
        }
        return -1;
    }
}