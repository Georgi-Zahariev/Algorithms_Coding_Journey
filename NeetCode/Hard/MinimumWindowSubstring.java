class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        
        int[] targer = new int[128]; // ASCII size
        for(char c : t.toCharArray()){
            targer[c]++;
        }
        
        int[] window = new int[128];
        int required = 0;
        for(int i = 0; i < 128; i++){
            if(targer[i] > 0){
                required++;
            }
        }
        
        int formed = 0;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            window[c]++;
            
            if(window[c] == targer[c]){
                formed++;
            }
            
            while(formed == required){
                int windowLen = right - left + 1;
                if(windowLen < minLen){
                    minLen = windowLen;
                    minStart = left;
                }
                
                char lchar = s.charAt(left);
                window[lchar]--;
                if(window[lchar] < targer[lchar]){
                    formed--;
                }
                left++;
            }
            right++;
        }
        
        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(minStart, minStart + minLen);
    }
}
