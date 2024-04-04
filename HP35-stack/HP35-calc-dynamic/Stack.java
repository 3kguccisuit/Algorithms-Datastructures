public class Stack {

    private int arr[];
    private int size;
    private int index = 0;
    private int counter;

    public Stack(int size) {
        this.size = size;
        arr = new int[size];
    }

    public void push(int element) {
        counter++;
        if (this.isFull()) {
            this.size();
        }
        arr[index] = element;
        index++;
        
    }

    public int pop() {
        counter++;
        if(counter>10)
        this.shrinkSize();
        return arr[--index];
    }

    public boolean isEmpty() {
        if (index == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (index == size) {
            return true;
        }
        return false;
    }

    public int getSize() {

        return index;
    }

    private void size() {
        int[] newStack = new int[this.size * 2];
        for (int i = 0; i < size; i++) {
            newStack[i] = this.arr[i];
        }
        this.arr = newStack;
        this.size = this.size * 2;
    }

    public void shrinkSize() {

        int[] newStack = new int[index];
        for (int i = 0; i < index; i++) {
            newStack[i] = this.arr[i];
        }
        this.arr = newStack;
        this.size =index;
        counter=0;

}

}