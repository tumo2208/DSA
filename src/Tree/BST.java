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
        Node node = root;
        if (node == null) {
            return new Node(key);
        } else {
            if (node.key > key) {
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

    public Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        } else if (root.key > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public Node delete(int key) {
        root = delete(root, key);
        return root;
    }

    private Node delete(Node root, int key) {
        if (root == null) {
            return null;
        } else if (root.key > key) {
            root.left = delete(root.left, key);
            return root;
        } else if (root.key < key) {
            root.right = delete(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node rightDelete = root;
                Node newNodeDelete = root.right;
                while (newNodeDelete.left != null) {
                    rightDelete = newNodeDelete;
                    newNodeDelete = newNodeDelete.left;
                }
                if (rightDelete == root) {
                    rightDelete.right = newNodeDelete.right;
                } else {
                    rightDelete.left = newNodeDelete.right;
                }
                root.key = newNodeDelete.key;
                return root;
            }
        }
    }
}
