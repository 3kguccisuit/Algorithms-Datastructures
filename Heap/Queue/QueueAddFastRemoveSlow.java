
public class QueueAddFastRemoveSlow {
    Node head;
    int pointer;

    public QueueAddFastRemoveSlow() {
        this.head = null;
        pointer = 0;

    }

    // O(1)
    public void add(Integer item) {
        Node newNode = new Node(item);
        Node next = head;
        newNode.next = next;
        head = newNode;
    }

    // O(n)
    public Integer remove() {
        Node current = head;
        Node prev = null;
        Node highest = current;
        // Inget elm
        if (head == null)
            return -1;

        // bara ett elm
        if (head.next == null) {
            int ret = head.item;
            head = null;
            return ret;
        }

        // Minst två elm
        while (current.next != null) {
            Node t = current;
            current = current.next;
            if (current.item < highest.item) {
                highest = current;
                prev = t;
            }
        }
        if (prev == null) // Sätt head
            head = highest.next;
        else
            prev.next = highest.next;
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
