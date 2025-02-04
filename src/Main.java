import java.net.HttpRetryException;

public class Main {
    public static void main(String[] args) {
        AVLTree AVLTree = new AVLTree();

        AVLTree.insert(35);
        AVLTree.insert(24);
        AVLTree.insert(67);
        AVLTree.insert(15);
        AVLTree.insert(45);
        AVLTree.insert(52);
        Node node =  AVLTree.insert(90);
        AVLTree.insert(75);
        AVLTree.insert(86);
        AVLTree.insert(79);
        AVLTree.insert(78);

        AVLTree.rotateRight(node);

        AVLTree.preOrder(AVLTree.getRoot());

    }
}