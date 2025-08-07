public class JumpGame {
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
 
        boolean[] reached = new boolean[nums.length];
        reached[0] = true;
        
        for(int i = 0; i < nums.length; i++){
            
            if(reached[i]==true){
                if(i == nums.length -1){
                    return true;
                }
                for(int j = 1; j <= nums[i]; j++){
                    if(i+j == nums.length){
                        break;
                    }
                    reached[i+j] = true;
                }
            }
        }

        return false;
    }
}
