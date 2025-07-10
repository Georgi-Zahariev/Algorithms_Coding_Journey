class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        char[] arr = s.toCharArray();

        for(char ch: arr){
            if(ch == '(' || ch == '{' || ch =='['){
                stack.push(ch);
            }else if(stack.isEmpty() == false){
                if(ch == ')' && stack.pop() == '('){
                    continue;
                }else if(ch == '}' && stack.pop() == '{'){
                    continue;
                }else if(ch ==']' && stack.pop() == '['){
                    continue;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
