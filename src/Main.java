public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(35);
        tree.insert(24);
        tree.insert(67);
        tree.insert(15);
        tree.insert(45);
        tree.insert(90);
        tree.insert(75);
        Node node = tree.insert(86);
        tree.insert(79);

        System.out.println(tree.successor(node).getData());
    }
}