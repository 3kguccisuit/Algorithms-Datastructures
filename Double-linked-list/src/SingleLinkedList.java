public class SingleLinkedList {

    private ListElement list;
    private ListElement[] elementArray;


    public SingleLinkedList(int size) {
        //The list has to have elements
        if(size < 0)
            return;

        //Create root ListElemenet
        list = new ListElement(0, null, null);

        //Pointer to the list to not change the original list
        ListElement pointer = list;

        //Loop through and add next references to create the list with the size
        for(int i = 0; i < size - 1; i++) {
            pointer.SetNext(new ListElement(i + 1, null, null));
            pointer = pointer.GetNext();
        }

        //Fill an array with the node references
        if(size > 0)
            GenerateArray(size);
    }


    public ListElement GetNode(int position)
    {
    return elementArray[position];
    }

    public void GenerateArray(int size) {
        //Create an empty array with the size.
        elementArray = new ListElement[size];

        //Set the pointer to the beginning of the linked list.
        ListElement pointer = list;
        int i = 0;

        //Add all the element from the list into the array.
        while(pointer != null) {
            elementArray[i++] = pointer;
            pointer = pointer.GetNext();
        }
    }


    public void MoveToStart(int position) {
        int removedValue = Remove(position);
        Add(removedValue);
    }


    public void MoveToStart(ListElement element) {
        Remove(element);
        Add(element);
    }

    public void Remove(ListElement element) {
        //Check if it is the first element.
        if(element == list) {
            //Move the list to start at the second element.
            list = list.GetNext();

            //Clear the next reference of the element.
            element.SetNext(null);
            return;
        }

        //Set the pointer to the beginning of the linked list.
        ListElement pointer = list;

        //Go to the correct position in the linked list.
        while(pointer.GetNext() != element)
            pointer = pointer.GetNext();

        //If the next element is null, set pointer next to null.
        if(element.GetNext() == null)
            pointer.SetNext(null);
        else
            pointer.SetNext(element.GetNext());

        //Clear the next reference for the element.
        element.SetNext(null);
    }

    public int Remove(int pos) {
        //Throw exception if the inputted index is to small.
        if(pos < 0)
            throw new ArrayIndexOutOfBoundsException("Index out of bounds of the linked list.");

        //The value that should be returned.
        int value;

        //Check if it is the first element
        if(pos == 0) {
            //Get the value of the current element.
            value = list.GetValue();
            //Move the list to start at the second element.
            list = list.GetNext();

            return value;
        }

        //Set the pointer to the beginning of the linked list.
        ListElement pointer = list;

        //Go to the correct position in the linked list.
        for(int i = 0; i < pos - 1; i++) {
            //Throw exception if the inputted index is to large.
            if(pointer.GetNext() == null)
                throw new ArrayIndexOutOfBoundsException("Index out of bounds of the linked list.");

            pointer = pointer.GetNext();
        }

        //Save the value of the element getting removed.
        value = pointer.GetNext().GetValue();
        //Set the next reference to the element after the removed element.
        pointer.SetNext(pointer.GetNext().GetNext());

        //Return the value of the removed element.
        return value;
    }

    public void Add(ListElement element) {
        //Set the next ListElement to the old start
        element.SetNext(list);

        //Move the start of the linked list back to the newly added element.
        list = element;
    }


    public void Add(int value) {
        //Add a new ListElement with the inputted value and next reference to current start element.
        list = new ListElement(value, list, null);
    }


    public void PrintList() {
        //Set the pointer to the beginning of the linkedList.
        ListElement pointer = list;

        //Print all values of the elements in the linkedList.
        System.out.printf("{ %d",pointer.GetValue());
        while(pointer.GetNext() != null) {
            pointer = pointer.GetNext();
            System.out.printf(", %d",pointer.GetValue());
        }
        System.out.printf(" }");
    }


}
