class Solution {
        public int maxArea(int[] height) {
                int l=0;
                        int r= height.length-1;
                                int max = 0;
                                        while(l<r){
                                                    int curr = Math.min(height[l],height[r])*(r-l);
                                                                max = Math.max(curr,max);
                                                                            if(height[l]>height[r]) r--;
                                                                                        else l++;
                                                                                                }
                                                                                                        return max;
                                                                                                            }
                                                                                                            }

