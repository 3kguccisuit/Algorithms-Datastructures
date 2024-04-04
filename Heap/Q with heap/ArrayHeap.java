public class ArrayHeap {
    private Integer[] heap;
    private Integer capacity;
    private Integer pos;

    public ArrayHeap() {
        capacity = 1000000;
        pos = 0;
        heap = new Integer[capacity];
    }

    /**
     * Adds item to heap
     * @param value to be added
     */
    public void add(Integer value) {
        
        if (pos == capacity)
            System.out.println("Heap is full!");

        else{
            heap[pos++] = value;
            
            //int child = getChild(pos);
            int child=pos-1;
            int parent = getParent(child);

            swap(child, parent); 
        }
    }

    /**
     * Swaps child and parent, if child is less than parent
     * @param child index
     * @param parent index
     */
    private void swap(int child, int parent) {
        
        while (heap[parent] > heap[child]) {
             
            int temp = heap[child];
            heap[child] = heap[parent];
            heap[parent] = temp;

            child = parent;
            parent = getParent(child);
        }
    }

    /**
     * Gets parent based on odd or even index
     * @param child to find parent of
     * @return position of parent node
     */
    private int getParent(int child) {
    
        if (child % 2 == 0 && child  > 1) 
            return (child - 2) / 2;
        else if (child % 2 == 1)
            return (child - 1) / 2;
        else 
            return 0;
    }

    /**
     * Removes the root and rebalances the tree
     * @return root
     */
    public Integer remove() {
        if (pos == 0){
            System.out.println("Heap is empty, can not retrieve value!");
            return null;
        }
        else{
            pos--;
            int value = heap[0];
            heap[0] = heap[pos];
            heap[pos] = null;
            sink();
            return value;
        }
    }

    /**
     * Lets root sink to its correct position
     */
    private void sink() {
        int parent = 0;
        int child1 = 2 * parent + 1;
        int child2 = 2 * parent + 2;
        
        while (((heap[child2] != null && pos > 2) && heap[child1] != null) && (heap[parent] > heap[child1] || heap[parent] > heap[child2])) {

            if (heap[child1] > heap[child2]) {
                int temp = heap[child2];
                heap[child2] = heap[parent];
                heap[parent] = temp;
            
                parent++;
                child1 = 2 * parent + 1;
                child2 = 2 * parent + 2;

            }
            else if (heap[child1] < heap[child2]) {
                int temp = heap[child1];
                heap[child1] = heap[parent];
                heap[parent] = temp;

                parent++;
                child1 = 2 * parent + 1;
                child2 = 2 * parent + 2;
            }
        }

        if ((pos == 2 && heap[child2] == null) && (heap[parent] > heap[child1])){
            int tmp = heap[child1];
            heap[child1] = heap[parent];
            heap[parent] = tmp;
        }
    }

    /**
     * Prints out an heap-array
     */
    public void printHeap() {
        for (int i = 0; i < heap.length; i++) {
            System.out.print("[" + heap[i] + "] ");
        }
        System.out.println("\n");
    }
}