// class RandomizedSet {
//     HashSet<Integer> set;
//     public RandomizedSet() {
//         set=new HashSet<>();   
//     }
    
//     public boolean insert(int val) {
//         if(set.contains(val)){
//             return false;
//         }
//         set.add(val);
//         return true;    
//     }
    
//     public boolean remove(int val) {
//         if(set.contains(val)){
//             set.remove(val);
//             return true;
//         }
//         return false;
//     }
    
//     public int getRandom() {
  
//         // Integer arr[]=set.toArray(new Integer[set.size()]);
//         // Random rm=new Random();
//         // return arr[rm.nextInt(set.size())];
//        List<Integer> list = new ArrayList<Integer>(set);
//        int r=(int)(Math.random()*set.size());
        
//        return list.get(r);
//     }
// }

class RandomizedSet {
    private final Random random = new Random();
    private final Map<Integer, Integer> map = new HashMap<>();
    private int[] vals = new int[32];
    private int i = 0;

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        Integer added = map.putIfAbsent(val, i);
        if (added != null) return false;

        if (i >= vals.length) {
            vals = Arrays.copyOf(vals, vals.length * 2);
        }
        vals[i++] = val;
        return true;
    }
    
    public boolean remove(int val) {
        Integer removed = map.remove(val);
        if (removed == null) return false;

        if (removed < i - 1) {
            vals[removed] = vals[i-1];
            map.put(vals[i-1], removed);
        }
        i--;
        return true;
    }
    
    public int getRandom() {
        int index = random.nextInt(i);
        return vals[index];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */