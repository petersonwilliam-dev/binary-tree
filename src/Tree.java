public class Tree {

    private Node root;

    public Tree() {}

    public Node insert(int data) {
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

        return z;
    }

    public Node min(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public Node max(Node node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    public Node predecessor(Node node) {
        if (node.getLeft() != null) {
            return max(node.getLeft());
        }
        Node y = node.getParent();
        while (y != null && node == y.getLeft()) {
            node = y;
            y = y.getParent();
        }
        return y;
    }

    public Node successor(Node node) {
        if (node.getRight() != null) {
            return min(node.getRight());
        }
        Node y = node.getParent();
        while (y != null && node == y.getRight()) {
            node = y;
            y = y.getParent();
        }
        return y;
    }

    public void transplant(Node u, Node v) {
        if (u.getParent() == null) {
            this.root = v;
        } else {
            if (u == u.getParent().getLeft()) {
                u.getParent().setLeft(v);
            } else {
                u.getParent().setRight(v);
            }
        }
        if (v != null) {
            v.setParent(u.getParent());
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
