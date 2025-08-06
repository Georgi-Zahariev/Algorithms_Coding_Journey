public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int cnt = 0;

        for(int i = 0; i < s.length(); i++){
            //case odd len
            int left = i;
            int right = i;

            while(left >= 0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                cnt++;
                left--;
                right++;
            }

            //case right len
            left = i;
            right = i+1;

            while(left >= 0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                cnt++;
                left--;
                right++;
            }

        }

        return cnt;
    }
}
