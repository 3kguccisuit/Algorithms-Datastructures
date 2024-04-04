public class LinkedList {

    private ListElement list;
    private ListElement[] elementArray;


    public LinkedList(int size) {
        //The list has to have elements
        if(size < 0)
            return;

        //Create root ListElemenet
        list = new ListElement(0, null, null);

        //Pointer to the list to not change the original list
        ListElement pointer = list;

        //Loop through and add next references to create the list with the size
        for(int i = 0; i < size - 1; i++) {
            pointer.SetNext(new ListElement(i + 1, null, pointer));
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

    public void MoveToStart(ListElement element) {
        Remove(element);
        Add(element);
    }

    public void MoveToStart(int position) {
        int removedValue = Remove(position);
        Add(removedValue);
    }

    public void Remove(ListElement element) {
        //Check if it is the first element
        if(element.GetPrevious() == null) {
            //Move the list to start at the second element.
            list = list.GetNext();
            //Remove the reference to the element before.
            list.SetPrevious(null);
        }
        else if(element.GetNext() == null)
            //Remove the reference to the removed element on the previous element.
            element.GetPrevious().SetNext(null);
        else {
            //Remove the references on the surrounding elements.
            element.GetPrevious().SetNext(element.GetNext());
            element.GetNext().SetPrevious(element.GetPrevious());
        }

        //Clear the removed elements next and previous element references.
        element.SetNext(null);
        element.SetPrevious(null);
    }

    public int Remove(int pos) {
        //Throw exception if the inputted index is to small.
        if(pos < 0)
            throw new ArrayIndexOutOfBoundsException ("Index out of bounds of the linked list.");

        //Check if it is the first element
        if(pos == 0) {
            //Get the value of the current element.
            int value = list.GetValue();
            //Move the list to start at the second element.
            list = list.GetNext();
            //Remove the reference to the element before.
            list.SetPrevious(null);

            return value;
        }

        //Set the pointer to the beginning of the linked list.
        ListElement pointer = list;

        //Go to the correct position in the linked list.
        for(int i = 0; i < pos; i++) {
            //Throw exception if the inputted index is to large.
            if(pointer.GetNext() == null)
                throw new ArrayIndexOutOfBoundsException("Index out of bounds of the linked list.");

            pointer = pointer.GetNext();
        }

        //Check if it is the last element
        if(pointer.GetNext() == null)
            //Remove the reference on the previous element
            pointer.GetPrevious().SetNext(null);
        else {
            //Remove the references on the surrounding elements.
            pointer.GetPrevious().SetNext(pointer.GetNext());
            pointer.GetNext().SetPrevious(pointer.GetPrevious());
        }

        //Return the value of the removed element.
        return pointer.GetValue();
    }

    public void Add(ListElement element) {
        //Set the next ListElement to the old start
        element.SetNext(list);

        //Set the previous ListElement of the current start element.
        list.SetPrevious(element);

        //Move the start of the linked list back to the newly added element.
        list = element;
    }

    public void Add(int value) {
        //Add a new ListElement with the inputted value and next reference to current start element.
        ListElement newList = new ListElement(value, list, null);

        //Set the previous ListElement of the current start element.
        list.SetPrevious(newList);

        //Move the start of the linked list back to the newly added element.
        list = list.GetPrevious();
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
