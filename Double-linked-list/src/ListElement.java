public class ListElement {

    private int value;
    private ListElement next;
    private ListElement previous;


    public ListElement(int value, ListElement next, ListElement previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }


    public int GetValue() {
        return value;
    }

    public ListElement GetNext() {
        return next;
    }


    public void SetNext(ListElement reference)
    {
         next = reference;
    }

    public ListElement GetPrevious()
    {
        return previous;
    }

    public void SetPrevious(ListElement reference)
    {
        previous = reference;
    }
}