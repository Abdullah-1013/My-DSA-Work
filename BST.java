 import java.util.LinkedList;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BST {
    private Node root;

    public BST() {
        root = null;
    }

    public void insertNode(int key) {
        root = insertNodeRecursive(root, key);
    }

    private Node insertNodeRecursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data) {
            root.left = insertNodeRecursive(root.left, key);
        } else if (key > root.data) {
            root.right = insertNodeRecursive(root.right, key);
        }

        return root;
    }

    public void deleteNode(int key) {
        root = deleteNodeRecursive(root, key);
    }

    private Node deleteNodeRecursive(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = deleteNodeRecursive(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNodeRecursive(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleteNodeRecursive(root.right, root.data);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public Node searchRecursive(int key) {
        return searchRecursive(root, key);
    }

    private Node searchRecursive(Node root, int key) {
        if (root == null || root.data == key) {
            return root;
        }

        if (key < root.data) {
            return searchRecursive(root.left, key);
        } else {
            return searchRecursive(root.right, key);
        }
    }

    public void dfs() {
        dfs(root);
    }

    private void dfs(Node root) {
        if (root != null) {
            dfs(root.left);
            System.out.print(root.data + " ");
            dfs(root.right);
        }
    }

    public void bfs() {
        if (root == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public void print() {
        print(root, 0);
    }

    private void print(Node root, int level) {
        if (root != null) {
            print(root.right, level + 1);
            String spaces = "   ".repeat(level);
            System.out.println(spaces + root.data);
            print(root.left, level + 1);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();

        tree.insertNode(50);
        tree.insertNode(30);
        tree.insertNode(70);
        tree.insertNode(20);
        tree.insertNode(40);
        tree.insertNode(60);
        tree.insertNode(80);

        System.out.println("Tree structure:");
        tree.print();

        System.out.println("\nDFS (In-order traversal):");
        tree.dfs();

        System.out.println("\n\nBFS (Level-order traversal):");
        tree.bfs();

        int searchKey = 100;
        Node result = tree.searchRecursive(searchKey);
        if (result != null) {
            System.out.println("\n\nSearch for key " + searchKey + ": Node found with data " + result.data);
        } else {
            System.out.println("\n\nSearch for key " + searchKey + ": Node not found");
        }

        int deleteKey = 30;
        tree.deleteNode(deleteKey);
        System.out.println("\n\nTree after deleting node with key " + deleteKey + ":");
        tree.print();
    }
}
