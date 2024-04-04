import java.util.Random;

public class Main {

    public static double benchPush(int size) {
        Random r = new Random();
        int low = 1;
        int high = 100;
        int low2 = 10;
        int high2 = 20;
        int result = r.nextInt(high - low) + low;

        // skapa värden
        Heap h = new Heap();
        for (int i = 0; i <= 64; i++) {
            h.add(r.nextInt(high - low) + low);
        }
        double dephtBench = 0;
        double dephtBench2 = 0;
        double dephtRes = 0;
        // h.resetDepth();
        double t_dummy = Double.POSITIVE_INFINITY;

        for (int j = 0; j < 1; j++) {
            long t0 = System.nanoTime();

            for (int i = 0; i < size; i++) {
                h.resetDepth();
                dephtBench2 = h.getDepth();
                h.push(r.nextInt(high2 - low2) + low2);
                dephtBench = h.getDepth();
                // System.out.println("exakt djup: " + (dephtBench-dephtBench2));
                dephtRes += dephtBench - dephtBench2;
            }
            long t = (System.nanoTime() - t0);
            t_dummy = t;
            System.out.println("Djup: " + dephtRes / size);
            // if (t < t_dummy)
            // t_dummy = t;

        }

        return t_dummy / 1000000; // To get MS
    }

    public static double benchAdd(int size) {
        Random r = new Random();
        int low = 1;
        int high = 100;
        int low2 = 10;
        int high2 = 20;
        int result = r.nextInt(high - low) + low;

        // skapa värden
        Heap h = new Heap();

        double dephtBench = 0;
        double dephtBench2 = 0;
        double dephtRes = 0;
        // h.resetDepth();
        double t_dummy = Double.POSITIVE_INFINITY;

        for (int j = 0; j < 1; j++) {
            long t0 = System.nanoTime();

            for (int i = 0; i < size; i++) {
                 h.resetDepth();
                dephtBench2 = h.getDepth();
                h.add(r.nextInt(high - low) + low);
                dephtBench = h.getDepth();
                 //System.out.println("exakt djup: " + (dephtBench-dephtBench2));
                dephtRes += dephtBench - dephtBench2;
            }
            long t = (System.nanoTime() - t0);
            t_dummy = t;
            System.out.println("Djup: " + dephtRes / size);
            // if (t < t_dummy)
            // t_dummy = t;

        }

        return t_dummy / 1000000; // To get MS
    }

    public static double benchArrayAdd(int size) {
        Random r = new Random();
        int low = 1;
        int high = 100;


        // skapa värden
        ArrayHeap h = new ArrayHeap();
        for (int i = 0; i < size; i++) {
            h.add(r.nextInt(high - low) + low);
        }

        // h.resetDepth();
        double t_dummy = Double.POSITIVE_INFINITY;

        for (int j = 0; j < 5; j++) {
            long t0 = System.nanoTime();
                h.remove();
            long t = (System.nanoTime() - t0);
            t_dummy = t;
            // if (t < t_dummy)
            // t_dummy = t;

        }

        return t_dummy / 1000000; // To get MS
    }


    public static void main(String[] args) {

        // Heap h = new Heap();
        // h.add(4);
        // h.add(6);
        // h.add(8);
        // h.add(7);
        // h.add(10);
        // h.add(13);
        // h.add(17);
        // h.add(2);
        // h.push(2);
       // System.out.println("Storlek 100, tid(ms) " + benchAdd(100));

    //    ArrayHeap h = new ArrayHeap();
    //    h.add(5);
    //    h.add(2);
    //    h.add(3);
    //    h.add(7);
    //    System.out.println(h.remove());
    //    System.out.println(h.remove());
    //    System.out.println(h.remove());
    //    System.out.println(h.remove());

        System.out.println("Storlek 100 " + "Söktid " + benchArrayAdd(100));

        // for (int j = 10; j <= 100; j += 10) {
        //     double result = benchArrayAdd(j);
        //     System.out.println("Storlek = " + j + ", Söktiden = " + result + "ms");
        // }
    }

}
