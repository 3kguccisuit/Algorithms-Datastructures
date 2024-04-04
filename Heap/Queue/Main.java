import java.util.Random;

public class Main {

    public static double benchLookUp(int size) {
        Random r = new Random();
        QueueAddSlowRemoveFast q = new QueueAddSlowRemoveFast();
        int low = 1;
        int high = 100;
        int result = r.nextInt(high - low) + low;

        // skapa värden


        double t_dummy = Double.POSITIVE_INFINITY;

        for (int j = 0; j < 1; j++) {


            long t0 = System.nanoTime();
            for (int i = 0; i < size; i++) {

                q.add(r.nextInt(high - low) + low);
            }
            long t = (System.nanoTime() - t0);
            t_dummy=t;
            // if (t < t_dummy)
            //     t_dummy = t;
        }
        q.display();
        return t_dummy / 1000000; // To get MS
    }

    public static void main(String[] args) {

        //DemoQueueAddFastRemoveSlow();
        System.out.println("storlek 100 " + benchLookUp(100));

        DemoQueueAddSlowRemoveFast();
        double result = 0;

        for (int j = 1000; j <= 10000; j += 1000) {
            result = benchLookUp(j);
            System.out.println("Storlek = " + j + ", Söktiden = " + result +"ms");
        }

    }

    public static void DemoQueueAddFastRemoveSlow() {
        QueueAddFastRemoveSlow q = new QueueAddFastRemoveSlow();

        Random r = new Random();
        int low = 1;
        int high = 1000000;
        int result = r.nextInt(high - low) + low;

        for (int i = 0; i < 10; i++) {
            q.add(i);
        }
        q.displayV2();

        for (int i = 0; i < 10; i++) {
            q.remove();
            q.displayV2();
        }

        for (int i = 10; i > 0; i--) {
            q.add(i);
        }
        q.displayV2();

        for (int i = 0; i < 10; i++) {
            q.remove();
            q.displayV2();
        }

    }

    public static void DemoQueueAddSlowRemoveFast() {
        QueueAddSlowRemoveFast q = new QueueAddSlowRemoveFast();

        for (int i = 0; i < 10; i++) {
            q.add(i);
        }
        q.displayV2();

        for (int i = 0; i < 10; i++) {
            q.remove();
            q.displayV2();
        }

        for (int i = 20; i > 0; i = i - 2) {
            q.add(i);
        }
        q.displayV2();
        q.add(15);
        q.displayV2();

        for (int i = 0; i < 10; i++) {
            q.remove();
            q.displayV2();
        }

    }

}
