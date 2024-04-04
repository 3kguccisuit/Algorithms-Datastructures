import java.util.Iterator;

public class BinaryTree implements Iterable<Integer> {

    public Iterator<Integer> iterator() {
        return new TreeIterator(root);
    }

    Node root;

    public BinaryTree() {
        root = null;
    }

    public Node add(Integer key, Integer value) {

        Node newNode = new Node(key, value);

        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;

            Node futureNode;

            while (true) {
                futureNode = focusNode;

                if (key == focusNode.key) {
                    focusNode.value = value;
                    return focusNode;

                } else if (key < focusNode.key) {
                    focusNode = focusNode.left;

                    if (focusNode == null) {
                        futureNode.left = newNode;
                        return futureNode.left;
                    }
                } else {
                    focusNode = focusNode.right;

                    if (focusNode == null) {
                        futureNode.right = newNode;
                        return futureNode.right;
                    }

                }

            }
        }
        return null;

    }

    public Node find(Node branch, int key) {
        if (branch != null) {
            if (branch.key == key) {
                return branch;
            } else if (key < branch.key) {
                return find(branch.left, key);
            } else if (key > branch.key) {
                return find(branch.right, key);
            }
        }
        return null;
    }

    public Node lookUp(int key) {
        Node focusNode = root;

        while (focusNode.key != key) {

            if (key < focusNode.key) {
                focusNode = focusNode.left;
                // System.out.println("Nyckel " + key);
                System.out.print("Nyckel (" + focusNode.key + " " + focusNode.value + ")");
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
            //System.out.printf("(%d %d) ", branch.key, branch.value);
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

        int toFind = 7;

        Node found = find(root, toFind);
        if (found != null)
            System.out.printf("\nfound %s", found.toString());
        else
            System.out.printf("\n%d not found", toFind);
    }

    public void testIterator(){
        
        
        
        Stack<Node> stack = new Stack<Node>();
        stack.push(new Node(10, 1));
        stack.push(new Node(15, 2));
        stack.push(new Node(20, 3));
        stack.push(new Node(8, 6));
        stack.push(new Node(9, 7));

        add(10, 1);
        add(15, 2);
        add(20, 3);
        add(8, 6);
        add(9, 7);



        //System.out.println("Stack: " + stack);
        //TreeIterator itr = new TreeIterator(root);

        stack.showStack();
        System.out.println("Tree: ");
        display(root);

        // while(itr.hasNext()){
        //     System.out.println(itr.next());
        // }

    }



}
