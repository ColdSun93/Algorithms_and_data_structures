package hw_4;

class RedBlackTree {
    Node root;

    class Node {
        int value;
        Color color;
        Node left;
        Node right;
    }

    private boolean addNode(Node node, int value){
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.left != null){
                    boolean result = addNode(node.left, value);
                    node.left = rebalnce(node.left);
                    return result;
                }   else {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
            }
        } else {
                if (node.right != null) {
                    boolean result = addNode(node.right, value);
                    node.right = rebalnce(node.right);
                    return result;
                } else {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return true;
                }
        }

        }
    }

    public boolean add(int value) {
        if (root !=null){
            boolean result = addNode(root, value);
            root = rebalnce(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }




    private void colorSwap(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node leftSwap(Node node) {
        Node left = node.left;
        Node tempNode = left.right;
        left.right = node;
        node.left = tempNode;
        left.color = node.color;
        node.color = Color.RED;
        return left;

    }
    private Node rightSwap(Node node) {
        Node right = node.right;
        Node tempNode = right.left;
        right.left = node;
        node.right = tempNode;
        right.color = node.color;
        node.color = Color.RED;
        return right;
    }

    private Node rebalnce(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.right != null && result.right.color == Color.RED && (result.left==null || result.left.color == Color.BLACK)){
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED && result.left.left != null && result.left.left.color == Color.RED){
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED && result.right != null && result.right.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        }
        while (needRebalance);
        return result;
    }
}
