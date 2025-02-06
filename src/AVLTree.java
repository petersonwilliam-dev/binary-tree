public class AVLTree {

    private Node root;

    public AVLTree() {}

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

        balance(z);
        return z;
    }

    public void remove(Node node) {
        if (node.getLeft() == null) {
            transplant(node, node.getRight());
        } else {
            if (node.getRight() == null) {
                transplant(node, node.getLeft());
            } else {
                Node y = min(node.getRight());
                if (y.getParent() != node) {
                    transplant(y, y.getRight());
                    y.setRight(node.getRight());
                    y.getRight().setParent(y);
                }
                transplant(node, y);
                y.setLeft(node.getLeft());
                y.getLeft().setParent(y);
            }
        }
        balance(node.getParent());
    }

    public Node searchNode(int data) {
        Node x = this.root;
        while (x != null && x.getData() != data) {
            if (data < x.getData()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        return x;
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

    public int getBalanceFactor(Node node) {
        int balanceLeft = lenghtTree(node.getLeft());
        int balanceRight = lenghtTree(node.getRight());

        int balanceFactor = balanceLeft - balanceRight ;

        return balanceFactor;
    }

    public int lenghtTree(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftLenght = lenghtTree(node.getLeft());
            int righLenght = lenghtTree(node.getRight());
            if (leftLenght > righLenght) {
                return leftLenght + 1;
            } else {
                return righLenght + 1;
            }
        }
    }

    public void balance(Node node) {
        while (node != null) {
            int balanceFactor = getBalanceFactor(node);

            if (balanceFactor < -1 || balanceFactor > 1) {
                  if (balanceFactor < -1) {
                      if (node.getRight().getRight() != null) {
                            rotateLeft(node);
                      } else {
                          rotateRight(node.getRight());
                          rotateLeft(node);
                      }
                  } else {
                      if (node.getLeft().getLeft() != null) {
                          rotateRight(node);
                      } else {
                          rotateLeft(node.getLeft());
                          rotateRight(node);
                      }
                  }
            }

            node = node.getParent();
        }
    }

    public void rotateLeft(Node node) {
        Node changedNode = node.getRight();

        if (changedNode != null) {
            if (node == this.getRoot()) {
                this.setRoot(changedNode);
            }
            node.setRight(changedNode.getLeft());
            if (changedNode.getLeft() != null) {
                changedNode.getLeft().setParent(node);
            }
            changedNode.setLeft(node);
            changedNode.setParent(node.getParent());
            if (node.getParent() != null) {
                if (node.getParent().getLeft() == node) {
                    node.getParent().setLeft(changedNode);
                } else {
                    node.getParent().setRight(changedNode);
                }
            }
            node.setParent(changedNode);
        }
    }

    public void rotateRight(Node node) {
        Node changedNode = node.getLeft();

        if (changedNode != null) {
            if (node == this.getRoot()) {
                this.setRoot(changedNode);
            }
            node.setLeft(changedNode.getRight());
            if (changedNode.getRight() != null) {
                changedNode.getRight().setParent(node);
            }
            changedNode.setRight(node);
            changedNode.setParent(node.getParent());
            if (node.getParent() != null) {
                if (node.getParent().getLeft() == node) {
                    node.getParent().setLeft(changedNode);
                } else {
                    node.getParent().setRight(changedNode);
                }
            }
            node.setParent(changedNode);
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrder(node.getRight());
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void posOrder(Node node) {
        if (node != null) {
            posOrder(node.getLeft());
            posOrder(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    public void reverseOrder(Node node) {
        if (node != null) {
            reverseOrder(node.getRight());
            System.out.print(node.getData() + " ");
            reverseOrder(node.getLeft());
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
