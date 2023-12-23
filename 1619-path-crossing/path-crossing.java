class Solution {
    public boolean isPathCrossing(String path) {
        Set<Pair<Integer,Integer>> visited=new HashSet<>();
        visited.add(new Pair(0,0));

        int x=0;
        int y=0;

        for(char c:path.toCharArray()){
            if(c=='N'){
                y++;
            }else if(c=='S'){
                y--;
            }else if(c=='E'){
                x++;
            }else{
                x--;
            }

            Pair<Integer,Integer> curr=new Pair(x,y);
            
            if(visited.contains(curr)) return true;
            visited.add(curr);
        }
        return false;
    }
}