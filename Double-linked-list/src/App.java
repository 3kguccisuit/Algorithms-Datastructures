import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        // Prefix for the output to convert from nanoseconds
        int prefix = 1000;
        // Minimum size to test from
        int minSize = 2;
        // The size of the linkedList
        int maxSize = 132000;
        // The amount of times to run the tests
        int runAmount = 1000;
        // The amount of moveToStart operations that should be made
        int moveAmount = 1000;

        Random random = new Random();

        System.out.printf("Antal noder i listan; Tid Double; Tid Single; Tid Double/Tid Single\n");
        
        for (int i = minSize; i < maxSize; i *= 2) {
            long doubleMinTime = Long.MAX_VALUE;
            long singleMinTime = Long.MAX_VALUE;

            // Create the lists
            LinkedList list = new LinkedList(i);
            SingleLinkedList singleList = new SingleLinkedList(i);

            // Sequence of references to the elements that should be moved
            ListElement[] sequence = new ListElement[moveAmount];
            ListElement[] singleSequence = new ListElement[moveAmount];

            // Fill upp the sequence of which elements should be removed and readded.
            for (int j = 0; j < moveAmount; j++) {
                sequence[j] = list.GetNode(random.nextInt(i - 1));
                singleSequence[j] = singleList.GetNode(random.nextInt(i - 1));
            }

            for (int j = 0; j < runAmount; j++) {
                // DoubleLinkedList
                long doubleT0 = System.nanoTime();

                // Move all the elements from the sequence
                for (int k = 0; k < moveAmount; k++)
                    list.MoveToStart(sequence[k]);

                long doubleT1 = System.nanoTime();

                long doubleTime = doubleT1 - doubleT0;

                // Check if it is a new minimum time for the doubleLinkedList
                if (doubleTime < doubleMinTime)
                    doubleMinTime = doubleTime;

                // SingleLinkedList
                long singleT0 = System.nanoTime();

                // Move all the elements from the sequence
                for (int k = 0; k < moveAmount; k++)
                    singleList.MoveToStart(singleSequence[k]);

                long singleT1 = System.nanoTime();

                long singleTime = singleT1 - singleT0;

                // Check if it is a new minimum time for the singleLinkedList
                if (singleTime < singleMinTime)
                    singleMinTime = singleTime;
            }                         
            System.out.printf("                    %d;         %d;         %d;                   %f       \n", i, doubleMinTime / prefix, singleMinTime / prefix,
                    doubleMinTime / (double) singleMinTime);
        }
    }

}
