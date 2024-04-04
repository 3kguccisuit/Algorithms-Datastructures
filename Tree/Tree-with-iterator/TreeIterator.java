import java.util.Iterator;

public class TreeIterator implements Iterator<Integer> {
    
    private Node next;
    private Stack<Node> stack;

    public TreeIterator(Node root) {
        next = root;
        stack = new Stack<Node>();
        while (next!=null)
        {
            stack.push(next);
            next=next.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Integer next() {
		Node node = stack.pop();
		int result = node.key;
		if (node.right != null) {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}