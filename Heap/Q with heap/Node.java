public class Node {
    public int priority;
    public int size;
    public Node left;
    public Node right;

    public Node(int priority, int size) {
        this.priority = priority;
        this.size = size;
        this.left = this.right = null;
    }


}


// public class Node {
//     public int prio;
//     public Node left;
//     public Node right;
//     public int countLeft;
//     public int countRight;

//     public Node(int prio) {
//         this.prio = prio;
//         this.left = this.right = null;
//         countLeft =  countRight = 0;
//      }


// }

