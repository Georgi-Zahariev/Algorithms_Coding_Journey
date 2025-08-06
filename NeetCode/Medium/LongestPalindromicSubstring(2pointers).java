class Solution {
    public String longestPalindrome(String s) {
        int result = 0;
        int index = 0;

        for(int i = 0; i < s.length(); i++){
            //case odd len
            int left = i;
            int right = i;

            while(left >= 0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                if(right - left +1 > result){
                    result = right - left +1;
                    index = left;
                }

                left--;
                right++;
            }

            //case right len
            left = i;
            right = i+1;

            while(left >= 0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                if(right - left +1 > result){
                    result = right - left +1;
                    index = left;
                }

                left--;
                right++;
            }

        }

        return s.substring(index, index+result);
    }
}
