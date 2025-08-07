public class MaximumSubarray {
    public int maxSubArray(int[] nums) {

        int[] dp = nums.clone();
        for(int i = 1; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }
        
        int maxSum = dp[0];
        for(int i = 1; i < dp.length; i++){
            maxSum = Math.max(maxSum, dp[i]);
        }
        
        return maxSum;
    }
}
