class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];

        for(int i = 0; i <= n; i++){
            int cnt = 0;
            int result;
            
            for(int j = 0; j < 32; j++){
                result = i & (1<<j);
                if(result != 0){
                    cnt++;
                }
            }
            arr[i] = cnt;
        }
        return arr;
    }
}
