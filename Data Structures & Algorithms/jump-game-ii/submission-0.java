class Solution {
    public int jump(int[] nums) {
        int l =0;
        int r=0;
        int farthest =0;
        int res=0;

        while(r<nums.length -1){
            
            for(int i=l;i<=r;i++){
                farthest = Math.max(farthest,i+nums[i]);
            }
            l=r+1;
            r=farthest;
            res+=1;
            
        }
        return res;
        
    }
}