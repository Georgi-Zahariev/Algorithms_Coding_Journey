class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int cnt = 1;
        int k = 0;

        if(nums.length == 0){return 0;}

        for(int i = 1; i < nums.length; i++){
            
            if(nums[i] == nums[i-1]){
                cnt++;
                if(cnt == 2){
                    k++;
                    nums[k] = nums[i];
                }
            }else{
                cnt = 1;
                k++;
                nums[k] = nums[i];
            }
        }

        k++;
        return k;
    }
}
