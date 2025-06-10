class RemovingStarsFromString {
    public String removeStars(String s) {
        StringBuilder str = new StringBuilder();
        int index = -1;

        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) != '*'){
                index++;
                str.append(s.charAt(i));
            }else{
                str.deleteCharAt(index);
                index--;
            }
        }

        return str.toString();
    }
}
