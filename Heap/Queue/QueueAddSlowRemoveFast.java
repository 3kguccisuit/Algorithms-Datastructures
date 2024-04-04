
public class QueueAddSlowRemoveFast {
    Node head;
    int pointer;

    public QueueAddSlowRemoveFast() {
        this.head = null;
        pointer = 0;

    }

    // O(n)
    public void add(Integer prio) {

        Node newNode = new Node(prio);

        // int returnNodeItem = head.item;

        // Inget elm
        if (head == null) {
            head = newNode;
            return;
        }

        // Det finns minst ett element
        Node current = head;
        Node prev = head;
        Node newPos = head;

        // Kolla om det nya elm ska sättas först
        if (head.item > prio) {
            newNode.next = head;
            head = newNode;
            return;
        }

        while (current.next != null) {
            Node t = current;
            current = current.next;
            if (current.item > prio) {
                newPos = current;
                prev = t;
                prev.next = newNode;
                newNode.next = current;
                return;
            }
            
        }

        current.next=newNode;
        // newPos.next = current.next;
        // prev.next = newNode;

    }

    // O(1)
    public Integer remove() {
        Node highest = head;
        head = head.next;
        return highest.item;
    }

    public void display() {
        System.out.println();
        if (head == null) {
            System.out.println("Listan är tom!");
            return;
        }
        System.out.println("Items:\n" + head.item);
        Node current = head;
        while (current.next != null) {
            current = current.next;
            System.out.println(current.item);
        }

    }

    public void displayV2() {
        System.out.println();
        if (head == null) {
            System.out.println("-");
            return;
        }
        System.out.print("Items:" + head.item);
        Node current = head;
        while (current.next != null) {
            current = current.next;
            System.out.print(" " + current.item);
        }
        System.out.println();

    }

    public Node getHead() {
        return this.head;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            System.out.println("list is null");
            return false;
        } else {
            return true;
        }
    }

}
