class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxVolume = 0;

        while(left<right){
            if( (right-left) * Math.min(heights[left], heights[right]) > maxVolume){
                maxVolume = (right-left) * Math.min(heights[left], heights[right]);
            }else{
                if(heights[left]<heights[right]){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return maxVolume;
    }
}
