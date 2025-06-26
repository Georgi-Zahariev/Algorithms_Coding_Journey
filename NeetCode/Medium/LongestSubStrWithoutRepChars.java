class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        StringBuilder str = new StringBuilder();
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            while (str.indexOf(String.valueOf(currentChar)) != -1) {
                str.deleteCharAt(0);
            }
            str.append(currentChar);
            maxLength = Math.max(maxLength, str.length());
        }

        return maxLength;
    }
}