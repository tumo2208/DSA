package Tree;

class AVLNode {
    int key, height;
    AVLNode left, right;

    AVLNode(int key) {
        this.key = key;
        this.height = 1;
    }
}

public class AVL {

    private AVLNode root;

    public AVL() {
        root = null;
    }

    private int height(AVLNode node) {
        if (node == null) {
            return 0;
        } else return node.height;
    }

    private int getBalance(AVLNode node) {
        if (node == null) {
            return 0;
        } else return (height(node.left) - height(node.right));
    }


    /*
         y                                x
        / \     Right Rotation          /  \
       x   T3   - - - - - - - >        T1   y
      / \       < - - - - - - -            / \
     T1  T2     Left Rotation            T2  T3
     */
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(x.left.height, x.right.height) + 1;
        y.height = Math.max(y.left.height, y.right.height) + 1;
        return y;
    }

    public AVLNode insert(int key) {
        root = insert(root, key);
        return root;
    }

    private AVLNode insert(AVLNode root, int key) {
        if (root == null) {
            return new AVLNode(key);
        } else {
            if (root.key > key) {
                root.left = insert(root.left, key);
            } else {
                root.right = insert(root.right, key);
            }

            root.height = Math.max(height(root.left), height(root.right)) + 1;
            int bal = getBalance(root);

            if (bal > 1 && key < root.left.key) {
                root = rightRotate(root);
            } else if (bal > 1 && key > root.left.key) {
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            } else if (bal < -1 && key > root.right.key) {
                root = leftRotate(root);
            } else if (bal < -1 && key < root.right.key) {
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }

            return root;
        }
    }

    public AVLNode delete(int key) {
        root = delete(root, key);
        return root;
    }

    private AVLNode delete(AVLNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.key > key) {
            root.left = delete(root.left, key);

        } else if (root.key < key) {
            root.right = delete(root.right, key);

        } else {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                AVLNode rightDelete = root;
                AVLNode newNodeDelete = root.right;
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
            }
        }

        if (root == null) {
            return null;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int bal = getBalance(root);

        if (bal > 1 && getBalance(root.left) >= 0) {
            root = rightRotate(root);
        } else if (bal > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            root = rightRotate(root);
        } else if (bal < -1 && getBalance(root.right) <= 0) {
            root = leftRotate(root);
        } else if (bal < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            root = leftRotate(root);
        }

        return root;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(AVLNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }
}
