class Solution {
    public int hammingWeight(int n) {
        int cnt = 0;
        int result;
        for(int i = 0; i < 32; i++){
            result = n & (1<<i);
            if(result != 0){
                cnt++;
            }
        }
        return cnt;
    }
}
