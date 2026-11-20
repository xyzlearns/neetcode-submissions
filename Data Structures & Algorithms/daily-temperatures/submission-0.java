class Solution {
        public int[] dailyTemperatures(int[] t) {
                int n=t.length;

                        int[] ans = new int[n];
                                Stack<Integer> stack =new Stack<>();

                                        for(int i=0;i<n;i++){
                                                    while(!stack.isEmpty() && t[stack.peek()]<t[i]){
                                                                    int idx = stack.pop();
                                                                                    ans[idx] = i-idx;
                                                                                                }
                                                                                                            stack.push(i);
                                                                                                                    }
                                                                                                                            return ans;
                                                                                                                                }
                                                                                                                                }

