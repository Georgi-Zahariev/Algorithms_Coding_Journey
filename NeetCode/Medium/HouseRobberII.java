public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int[] nums1 = new int[nums.length -1];
        int[] nums2 = new int[nums.length -1];

        for(int i = 0; i < nums.length -1; i++){
            nums1[i] = nums[i];
        }

        for(int i = 0; i < nums.length -1; i++){
            nums2[i] = nums[i+1];
        }

        return Math.max(robHelp(nums1), robHelp(nums2));
    }

    private int robHelp(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[nums.length - 1];
    }
}