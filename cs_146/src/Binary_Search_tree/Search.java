package Binary_Search_tree;

public class Search {
    public static class Node {
        String name;
        String phone;
        Node left;
        Node right;

        public Node(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }

    private Node root = null;

    public String Search(String name) {
        Node cur = root;
        int r = name.compareTo(cur.name);
        while (cur != null) {
            if (r == 0)
                return cur.phone;
            else if (r < 0)
                cur = cur.left;
            else
                cur = cur.right;
        }
        return null;
    }//search the number

    public String Update(String name, String phone) {
        Node cur = root;
        int r = name.compareTo(cur.name);
        while (cur != null) {
            if (r == 0) {
                String oldPhone = cur.phone;
                cur.phone = phone;
                return cur.phone;
            } else if (r < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }//Change the number of the contact

    public boolean insert(String name, String phone) {
        Node cur = root;
        Node parent = null;
        int r = name.compareTo(cur.name);
        while (cur != null) {
            if (r == 0) {
                return false;
            } else if (r < 0) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        Node node = new Node(name, phone);
        if (parent.left == null)
            parent.left = node;
        else
            parent.right = node;
        return true;
    }
}