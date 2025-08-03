class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for(int i =0; i < 32; i++){
            int val = n & (1<<i);
            if(val != 0){
                res = res | (1<<(31-i));
            }
        }
        return res;
    }
}
