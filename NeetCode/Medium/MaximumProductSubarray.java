public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int result = nums[0];

        int currMin = 1;
        int currMax = 1;

        for (int num : nums) {

            int temp = currMax * num;

            currMax = Math.max(Math.max(num * currMax, num * currMin), num);
            currMin = Math.min(Math.min(temp, num * currMin), num);

            result = Math.max(result, currMax);
        }
        return result;
    }
}