import java.util.Random;

public class Main {

    public static double benchLookUp(int size) {
        Random r = new Random();
        int low = 1;
        int high = 1000;
        int result = r.nextInt(high - low) + low;

        BinaryTree bt = new BinaryTree();
        // skapa värden
        for (int i = 0; i < size; i++) {
            bt.add(r.nextInt(high - low) + low, i);
        }

        double t_dummy = Double.POSITIVE_INFINITY;

        for (int j = 0; j < 250; j++) {
            long t0 = System.nanoTime();

            for (int i = 0; i < size; i++) {
                int key = r.nextInt(high - low) + low;
                bt.lookUp(bt.root,key);
            }
            long t = (System.nanoTime() - t0);
            if (t < t_dummy)
                t_dummy = t;
        }

        // long sum = 0;
        // long timeStart = System.nanoTime();
        // for (int i = 0; i < 1000000; i++) {
        // int key = r.nextInt(size);
        // bt.lookUp(bt.root, key);
        // }
        // long searchTime = (long) (System.nanoTime() - timeStart);
        // sum += searchTime;
        return t_dummy / 1000000; // To get MS
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        double result = 0;
        System.out.println("Storlek = " + "100 000" + ", Söktiden = " + benchLookUp(100_000) + "ms");
        System.out.println("Storlek = " + "250 000" + ", Söktiden = " + benchLookUp(250_000) + "ms");
        System.out.println("Storlek = " + "500 000" + ", Söktiden = " + benchLookUp(500_000) + "ms");
        System.out.println("Storlek = " + "750 000" + ", Söktiden = " + benchLookUp(750_000) + "ms");
        System.out.println("Storlek = " + "1 000 000" + ", Söktiden = " + benchLookUp(1_000_000) + "ms");

        // for (int j = 50000; j <= 1000000; j += 50000) {
        // result = benchLookUp(j);
        // System.out.println("Storlek = " + j + ", Söktiden = " + result +
        // "ms");
        // }
        // bt.test();
    }

}
