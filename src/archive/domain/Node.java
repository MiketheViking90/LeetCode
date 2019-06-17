package archive.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public Node(int _val) {
        this.val = _val;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> toVisit = new LinkedList<>();

        toVisit.offer(root);
        while(!toVisit.isEmpty()) {
            int breadth = toVisit.size();
            List<Integer> lvl = new ArrayList<>();

            while (breadth > 0) {
                Node visit = toVisit.poll();
                lvl.add(visit.val);
                toVisit.addAll(visit.children);
                breadth--;
            }
            res.add(lvl);
        }
        return res;
    }

    public static Node makeNode() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.addChild(n2);
        n1.addChild(n3);

        n2.addChild(n4);
        n2.addChild(n5);
        n2.addChild(n6);

        n4.addChild(n7);

        return n1;
    }
}
