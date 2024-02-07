class Solution {
    class Solve implements Comparable<Solve>{
        char s;
        int freq;
        public Solve(char c,int freq){
            this.s=c;
            this.freq=freq;
        }

        @Override
        public int compareTo(Solve s2){
            return s2.freq-this.freq;
        }
    }
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        PriorityQueue<Solve> pq=new PriorityQueue<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(Character ch:map.keySet()){
            pq.add(new Solve(ch,map.get(ch)));
        }
        StringBuilder sb=new StringBuilder("");
        while(!pq.isEmpty()){
            Solve ans=pq.poll();
            int times=ans.freq;
            char ch=ans.s;
            while(times>0){
                sb.append(ch);
                times--;
            }
            
        }
        return sb.toString();
    }
}