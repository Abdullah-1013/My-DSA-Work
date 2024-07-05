class Node {
    int key, height;
    Node left, right;

    Node(int value) {
        key = value;
        height = 1;
    }
}

public class AVL {
    Node root;

    int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // Duplicate keys are not allowed in AVL trees

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && key < node.left.key) {
            System.out.println("Left Left Case: " + node.key);
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && key > node.right.key) {
            System.out.println("Right Right Case: " + node.key);
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            System.out.println("Left Right Case: " + node.key);
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            System.out.println("Right Left Case: " + node.key);
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void printTreeValuesBeforeTraversal() {
        printTreeValuesBeforeTraversal(root);
    }

    private void printTreeValuesBeforeTraversal(Node node) {
        if (node != null) {
            printTreeValuesBeforeTraversal(node.left);
            System.out.print(node.key + " ");
            printTreeValuesBeforeTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        AVL tree = new AVL();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Values of the AVL Tree before Preorder traversal:");
        tree.printTreeValuesBeforeTraversal();

        System.out.println("\nPreorder traversal of the constructed AVL tree is:");
        tree.preOrder(tree.root);
    }
}
