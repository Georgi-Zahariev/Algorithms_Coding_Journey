class Node {
    HashMap<Character, Node> childMap = new HashMap<>();
    boolean wordEnd = false;
}
class WordDictionary {

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;

        for(int i = 0; i < word.length(); i++){
            if(!curr.childMap.containsKey(word.charAt(i))){
                curr.childMap.put(word.charAt(i), new Node());
            }
            curr = curr.childMap.get(word.charAt(i));

        }
        curr.wordEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Node root) {
        Node curr = root;

        for(int i = index; i < word.length(); i++){
            char ch = word.charAt(i);

            if(ch == '.'){
                for(Node val : curr.childMap.values()){
                    if(dfs(word, i + 1, val)){
                        return true;
                    }
                }
                return false;
            }else{
                if(!curr.childMap.containsKey(word.charAt(i))){
                    return false;
                }
                curr = curr.childMap.get(word.charAt(i));
            }
        }

        return curr.wordEnd;
    }
}
