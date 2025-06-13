class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        Arrays.sort(nums);

        int cnt = 1;
        int maxCnt = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1] + 1){
                cnt++;
            }else if(nums[i] == nums[i - 1]){
                continue;
            }else{
                maxCnt = Math.max(maxCnt, cnt);
                cnt = 1;
            }
        }

        maxCnt = Math.max(maxCnt, cnt);

        return maxCnt;
    }
}
