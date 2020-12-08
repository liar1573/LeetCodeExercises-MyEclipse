/**LC376.最长摆动序列，与LC300最长上升子序列相比，只是把单调递增的判断条件改成了正负交替的条件。
 * 
 */
package com.leetcode.dp;


public class WiggleMaxLength {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,3,3,2,5};
		WiggleMaxLength test = new WiggleMaxLength();
		System.out.println(test.wiggleMaxLength(arr));
		
	}
	
	public int wiggleMaxLength(int[] nums) {
		if (nums.length < 2) 
			return nums.length;
		
		int ans = 1;
//		int[] dp = new int[nums.length];
//		for (int i = 0; i < dp.length; i++)
//			dp[i] = 2; 
//		dp[0] = 1;
		int[][] dp = new int[nums.length][2];		
		for (int i = 1; i < dp.length; i++){
//			dp[i][0] = 2;
			dp[i][0] = 1;
			dp[i][1] = nums[i] - nums[i-1]; 
		}
		dp[0][0] = 1; dp[0][1] = 0; //第一个元素没有差值
//		if(nums[1] > nums[0]){
		if(nums[1] != nums[0]){//这里只要不等于就可以了
            dp[1][0] = 2; ans = 2;
        }
		
		for (int i = 2; i < nums.length; i++) {
			for (int j = 1; j < i; j++) {
//				if((nums[i] - nums[j]) * dp[j][1] < 0){
				if(((nums[i] - nums[j]) * dp[j][1] < 0) || ((nums[i] - nums[j]) != 0 && dp[j][1] == 0)){
					dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
					dp[i][1] = nums[i] - nums[j];
				}
			}
			ans = (ans > dp[i][0]) ? ans: dp[i][0]; 
		}
		
		
		return ans;
//		return dp[nums.length - 1];
    }
	
	public int wiggleMaxLengthMethodDPN2(int[] nums) {
		//这里官方给的解法使用两个数组来维持dp，分别记作up和down来记录上升和下降序列
		if (nums.length < 2) 
			return nums.length;
		
		int ans = 1;
		int[] up = new int[nums.length];
		int[] down = new int[nums.length];
		for (int i = 1; i < nums.length; i++){
			up[i] = 1; down[i] = 1;  
		}
		
		up[1] = (nums[1] > nums[0]) ? 2: 1;
		down[1] = (nums[1] < nums[0]) ? 2: 1;
		
		for (int i = 2; i < nums.length; i++) {
			for (int j = 1; j < i; j++) {
				if(nums[i] > nums[j]){
					up[i] = Math.max(up[i], down[j] + 1); //这里感觉是用up[i]和down[j] + 1做笔记，应该不能全部用up或者down
				}else if (nums[i] < nums[j] ) {
					down[i] = Math.max(down[i], up[j] + 1);
				}
			}
			int temp = Math.max(down[i], up[i]);
			ans = Math.max(ans, temp);
		}	
		
		return ans;
	}
	
	public int wiggleMaxLengthMethodDPLinear(int[] nums) {
		//这里官方给的解法使用两个数组来维持dp，分别记作up和down来记录上升和下降序列
		if (nums.length < 2) 
			return nums.length;
		
		int[] up = new int[nums.length];
		int[] down = new int[nums.length];
		for (int i = 0; i < nums.length; i++){
			up[i] = 1; down[i] = 1;  
		}
		
		
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] > nums[i-1]){
				up[i] = down[i-1] + 1; down[i] = down[i-1]; 
			}else if (nums[i] < nums[i-1] ) {
				up[i] = up[i-1]; down[i] = up[i-1] + 1; 
			}else{
				up[i] = up[i-1]; down[i] = down[i-1]; 
			}
		}	
		
		return (up[nums.length - 1] > down[nums.length - 1]) ? up[nums.length - 1]: down[nums.length - 1];
	}
	
	public int wiggleMaxLengthGreedy(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int prevdiff = nums[1] - nums[0];
        int count = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
            	//贪心算法的逻辑判断非常简单
            	//为什么简单的迭代diff和prediff就能保住一定取得区间最大最小值呢？
                count++;
                prevdiff = diff;
            }
        }
        return count;
    }


}
