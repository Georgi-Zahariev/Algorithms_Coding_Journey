public class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<List<Integer>>();

        List<Integer> current = new ArrayList<>();
        backtrack(nums, target, current, 0);
        return result;
    }

    public void backtrack(int[] nums, int target, List<Integer> current, int i){
        if(target == 0){
            result.add(new ArrayList(current));
            return;
        }
        if(target < 0 || i >= nums.length){
            return;
        }

        current.add(nums[i]);
        backtrack(nums, target - nums[i], current, i);
        current.remove(current.size()-1);
        backtrack(nums, target, current, i+1);
    }
}
