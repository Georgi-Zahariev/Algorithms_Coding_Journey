class Node {

    boolean wordEnd = false;
    HashMap<Character, Node> map = new HashMap<>();

}
class PrefixTree {

    private Node root;

    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        Node curr = root;

        for(int i = 0; i < word.length(); i++){
            if(!curr.map.containsKey(word.charAt(i))){
                curr.map.put(word.charAt(i), new Node());
            }
            curr = curr.map.get(word.charAt(i));
        }
        curr.wordEnd = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for(int i = 0; i < word.length(); i++){
            if(!curr.map.containsKey(word.charAt(i))){
                return false;
            }
            curr = curr.map.get(word.charAt(i));
        }
        return curr.wordEnd;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;

        for(int i = 0; i < prefix.length(); i++){
            if(!curr.map.containsKey(prefix.charAt(i))){
                return false;
            }
            curr = curr.map.get(prefix.charAt(i));
        }
        return true;
    }
}
