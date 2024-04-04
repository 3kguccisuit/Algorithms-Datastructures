
public class BinaryTree {
    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        @Override
        public String toString() {
            return "(" + key.toString() + " " + value.toString() + ")";
        }
    }

    Node root;

    public BinaryTree() {
        root = null;
    }

    public void add(Integer key, Integer value) {

        Node newNode = new Node(key, value);

        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;

            Node parent;

            while (true) {
                parent = focusNode;

                if (key == focusNode.key) {
                    focusNode.value = value;
                    return;

                } else if (key < focusNode.key) {
                    focusNode = focusNode.left;

                    if (focusNode == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.right;

                    if (focusNode == null) {
                        parent.right = newNode;
                        return;
                    }

                }

            }
        }

    }

    public Node lookUp(Node branch, int key) {
        if (branch != null) {
            if (branch.key == key) {
                return branch;
            } else if (key < branch.key) {
                return lookUp(branch.left, key);
            } else if (key > branch.key) {
                return lookUp(branch.right, key);
            }
        }
        return null;
    }

    public Node lookUp2(int key) {
        Node focusNode = root;

        while (focusNode.key != key) {

            if (key < focusNode.key) {
                focusNode = focusNode.left;
                // System.out.println("Nyckel " + key);
                //System.out.print("Nyckel (" + focusNode.key + " " + focusNode.value + ")");
            } else {
                focusNode = focusNode.right;
            }
            if (focusNode == null)
                return null;
        }

        return focusNode;

    }


    public void display(Node branch) {
        if (branch != null) {
            display(branch.left);
            System.out.printf("(%d %d) ", branch.key, branch.value);
            display(branch.right);
        }
    }

    public void test() {
        add(10, 1);
        add(15, 2);
        add(20, 3);
        add(25, 4);
        add(5, 5);
        add(8, 6);
        add(9, 7);
        add(23, 7);
        add(7, 6);
        add(7, 17);

        display(root);
        // traverseRight();
        // System.out.println();
        // traverseLeft();
        // System.out.println();
        // lookUp(7);
        // lookUp(7);

        int toFind = 7;

        Node found = lookUp(root, toFind);
        if (found != null)
            System.out.printf("\nfound %s", found.toString());
            else
            System.out.printf("\n%d not found", toFind);
    }

}
