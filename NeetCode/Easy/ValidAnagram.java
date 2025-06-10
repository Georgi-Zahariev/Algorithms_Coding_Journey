class Solution {
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        if(s.length() != t.length()){
            return false;
        }

        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
            }else{
                map.put(s.charAt(i),1);
            }

            set.add(s.charAt(i));
        }

        for(int i = 0; i < t.length(); i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i)) - 1);
            }else{
                return false;
            }
        }

        for(char element : set){
            if(map.get(element)!= 0){
                return false;
            }
        }

        return true;
    }
}
