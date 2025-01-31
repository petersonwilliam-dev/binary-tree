public class Tree {

    private Node root;

    public Tree() {}

    public void insert(int data) {
        Node y = null;
        Node x = this.getRoot();

        while (x != null) {
            y = x;
            if (data < x.getData()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }

        Node z = new Node();

        z.setData(data);
        z.setParent(y);
        if (y == null) {
            this.root = z;
        } else {
            if (z.getData() < y.getData()) {
                y.setLeft(z);
            } else {
                y.setRight(z);
            }
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrder(node.getRight());
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
