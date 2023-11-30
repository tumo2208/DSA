package Tree;

class Node {
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

public class BST {

    private Node root;

    public BST() {
        root = null;
    }

    public BST(int key) {
        root = new Node(key);
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        } else {
            Node node = root;
            if (key < node.key) {
                node.left = insert(node.left, key);
            } else {
                node.right = insert(node.right, key);
            }
            return root;
        }
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public Node search(int key) {
        return search(root, key);
    }

    private Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        } else if (key < root.key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public Node delete(int key) {
        return delete(root, key);
    }

    private Node delete(Node root, int key) {
        System.out.println(root.key);
        if (key < root.key) {
            root.left = delete(root.left, key);
            return root;
        } else if (key > root.key) {
            root.right = delete(root.right, key);
            return root;
        }

        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            Node nodeDelete = root;
            Node rightDelete = root.right;
            System.out.println(nodeDelete.key + " " + rightDelete.key);
            while (rightDelete.left != null) {
                nodeDelete = rightDelete;
                rightDelete = rightDelete.left;
                System.out.println(nodeDelete.key + " " + rightDelete.key);
            }
            if (nodeDelete != root) {
                nodeDelete.left = rightDelete.right;
            } else {
                nodeDelete.right = rightDelete.right;
            }
            root.key = rightDelete.key;
            return root;
        }
    }
}
