import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class Solution {

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Map<Integer, Node> map = new HashMap<>();
        map.put(node.val, new Node(node.val));

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            Node current = queue.removeFirst();

            for (Node n : current.neighbors) {
                if (!map.containsKey(n.val)) {
                    map.put(n.val, new Node(n.val));
                    queue.add(n);
                }
                map.get(current.val).neighbors.add(map.get(n.val));
            }
        }
        return map.get(node.val);
    }
}

class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
