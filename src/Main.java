public class Main {
    public static void main(String[] args) {
        Node start = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        start.setPointsTo(new Node[]{two, three});
        two.setPointsTo(new Node[]{three});
        three.setPointsTo(new Node[]{four, five, six});
        six.setPointsTo(new Node[]{seven});

        System.out.println(Node.search(start, seven));
    }
}


class Node {
    int num;
    Node[] pointsTo;
    boolean visited = false;

    public Node(int num) {
        this.num = num;
        this.pointsTo = new Node[0];
    }

    public void setPointsTo(Node[] pointsTo) {
        this.pointsTo = pointsTo;
    }

    public static boolean search(Node s, Node e) {
        s.visited = true;
        for (Node adj : s.pointsTo) {
            if (adj == e) return true;
            if (!adj.visited) {
                if (search(adj, e) == true) return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return Integer.toString(num);
    }
}