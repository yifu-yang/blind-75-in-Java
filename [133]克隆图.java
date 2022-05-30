/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node,Node> map = new HashMap<>();
    Set<Node> marked = new HashSet<>();
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        if(map.containsKey(node)){
            return map.get(node);
        }else{
            Node clone = new Node(node.val);
            map.put(node,clone);
            for(Node subNode : node.neighbors){
                Node subClone = cloneGraph(subNode);
                clone.neighbors.add(subClone);
                map.put(subNode,subClone);
            }
            return clone; 
        }
    }
}