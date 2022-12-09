package Binary_Search_tree;

public class BinarySearchTree {
    public static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    private Node root = null;

    public Node Search(int key) {
        Node cur = root;
        while (cur != null) {
            if (key == cur.key)
                return cur;
            else if (key < cur.key)
                cur = cur.left;//find the left tree
            else
                cur = cur.right;//find the left tree
        }//comparing
        return null;
    }
    public boolean insert(int key) {
        Node cur = root;
        Node parent = null;
        if (root == null) {
            root = new Node(key);
            return true;
        }
        while (cur != null) {
            if (key == cur.key)
                return false;
            else if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        Node node = new Node(key);
        if (key < parent.key)
            parent.left = node;
        else
            parent.right = node;
        return true;
    }//insert

    public boolean remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (key == cur.key)
                removeNode(parent, cur);
            else if (key < cur.key)
                cur = cur.left;
            else
                cur = cur.right;
        }
        return false;
    }

    private void removeNode(Node parent, Node cur) {
        if (cur.left == null) {
            if (cur == parent)
                parent = cur.right;
            else if (parent.left == cur) {
                parent.left = cur.right;
            } else
                parent.right = cur.right;
        }
        else if (cur.right == null) {
            if (cur == parent)
                parent = cur.left;
            else if (parent.left == cur)
                parent.left = cur.left;
            else
                parent.right = cur.left;
        }//the empty situation if the left tree is empty
        else {
            Node goatParent = null;
            Node goat = cur.right;
            while (goat != null) {
                goatParent = goat;
                goat = goat.left;
            }
            cur.key = goat.key;
            if (goatParent.left == goat)
                goatParent.left = goat.right;
            else
                goatParent.right = goat.right;
        }
    }

    private static void inOrderInsert(Node root) {
        if (root != null) {
            inOrderInsert(root.left);
            System.out.println(root.key);
            inOrderInsert(root.right);
        }
    }

    private static void preOrderInsert(Node root) {
        if (root != null) {
            System.out.println(root.key);
            preOrderInsert(root.left);
            preOrderInsert(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] keys = {3, 9, 7, 4, 1, 6, 2, 8, 5};
        for (int key : keys) {
            System.out.println(tree.insert(key));
        }
        System.out.println("inserting the repeating data");
        System.out.println(tree.insert(7));
        System.out.println("preorder traversal:");
        preOrderInsert(tree.root);
        System.out.println("inorder traversal:");
        inOrderInsert(tree.root);
        System.out.println("===========================");
        System.out.println(tree.Search(7).key);
        System.out.println(tree.Search(8).key);
        System.out.println(tree.Search(5).key);
    }
}
