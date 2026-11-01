class Solution {
    public List<Integer> partitionLabels(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,i);
        }
        int len =0;
        int end=0;
        int i=0;

        ArrayList<Integer> res = new ArrayList<>();

        while(i<s.length()){
            char c = s.charAt(i);
            end = Math.max(map.get(c),end);
            len++;
            if(i==end) {res.add(len);len =0;}
            i++;
        }
        return res;
    }
}
