import java.security.InvalidParameterException;

public class Heap {
    Node root;
    double depht =0;

    public Heap() {
        root = null;
    }

    // private void addRec(Integer prio, Node current) {
    // if (current == null) {
    // if (root == null)
    // root = new Node(prio);
    // else
    // current = new Node(prio);
    // return;
    // }

    // // sätta det nya värdet till roten
    // if (prio < current.prio) {
    // int newPrio = current.prio;
    // current.prio = prio;

    // if (current.countLeft <= current.countRight) {
    // current.countLeft++;
    // if (current.left == null) {
    // current.left = new Node(newPrio);
    // } else {
    // current = current.left;
    // addRec(newPrio, current);
    // }

    // } else {
    // current.countRight++;
    // if (current.right == null) {
    // current.right = new Node(newPrio);
    // } else {

    // current = current.right;
    // addRec(newPrio, current);
    // }
    // }
    // } else {

    // if (current.left == null) {
    // current.countLeft++;
    // current.left = new Node(prio);
    // return;
    // } else if (current.right == null) {
    // current.countRight++;
    // current.right = new Node(prio);
    // return;
    // }

    // if (current.countLeft <= current.countRight) {
    // current.countLeft++;
    // current = current.left;
    // addRec(prio, current);
    // } else {
    // current.countRight++;
    // current = current.right;
    // addRec(prio, current);
    // }
    // }
    // }

    private void addRec(int prio, Node current) {

        // we want to move the current and prio of the current node down if the current
        // we
        // want to add has lower priority than the node we're in
        if (prio < current.priority) {
            int tempPriority = current.priority;
            current.priority = prio;
            prio = tempPriority;
        }
        current.size++;
        depht++;
        if (current.left == null) {
            current.left = new Node(prio, 1);
        } else if (current.right == null) {
            current.right = new Node(prio, 1);
        } else if (current.right.size < current.left.size) {
            addRec(prio, current.right);
        } else {
            addRec(prio, current.left);
        }

    }

    public void add(Integer prio) {
        if (root == null) {
            root = new Node(prio, 1);
        } else
            addRec(prio, root);
    }

    public int remove() {
        if (root == null) {
            System.out.println("Heap is empty");
            return -1;
        } else if (root.left == null && root.right == null) {
            int oldRootToBeReturned = (int) this.root.priority;
            root = null;
            return oldRootToBeReturned;
        } else {
            int oldRootToBeReturned = (int) this.root.priority;
            removeRec(root);
            return oldRootToBeReturned;
        }
    }

    private Node removeRec(Node current) {
        // if the left branch is empty we promote the right branch to root.
        if (current.left == null) {
            current.priority = current.right.priority;
            current.right = null;
            current.size--;
            return current;
        }
        // if the right branch is empty we promote the left branch to root
        if (current.right == null) {
            current.priority = current.left.priority;
            current.left = null;
            current.size--;
            return current;
        }
        if (current.left.priority < current.right.priority) {
            current.priority = current.left.priority;
            current.size--;
            if (current.left.size == 1) {
                current.left = null;
            } else {
                current.left = removeRec(current.left);
            }
            return current;
        } else {
            current.priority = current.right.priority;
            current.size--;
            if (current.right.size == 1) {
                current.right = null;
            } else {
                current.right = removeRec(current.right);
            }
        }
        return current;
    }

    public void push(Integer increment, Node current) {
        Integer holder = null;
        current.priority += increment;
        if (current.left != null && current.left.priority < current.priority) {
            if (current.right != null && current.right.priority < current.left.priority) {
                holder = current.right.priority;
                current.right.priority = current.priority;
                current.priority = holder;
                depht++;
                push(0, current.right);
            } else {
                holder = current.left.priority;
                current.left.priority = current.priority;
                current.priority = holder;
                depht++;
                push(0, current.left);
            }
        } else if (current.right != null && current.right.priority < current.priority) {
            if (current.left != null && current.left.priority < current.right.priority) {
                holder = current.left.priority;
                current.left.priority = current.priority;
                current.priority = holder;
                depht++;
                push(0, current.left);
            } else {
                holder = current.right.priority;
                current.right.priority = current.priority;
                current.priority = holder;
                depht++;
                push(0, current.right);
            }
        }
    }

    public void push(Integer increment) {
        if (root == null) {
            return;
        } else {
            push(increment, root);
        }

    }


    public double getDepth(){
        return this.depht;
    }

    public void resetDepth(){
        this.depht=0;
    }
}
