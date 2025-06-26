class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int target = (-1) * nums[i];

            int right = nums.length - 1;
            int left = i + 1;

            while(left<right){
                if(nums[left] + nums[right] > target){
                    right--;
                }else if(nums[left] + nums[right] < target){
                    left++;
                }else{
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }

                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}
