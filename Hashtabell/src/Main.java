import java.util.Random;

class Main {

    public static void main(String[] args) {

        // benchmark2(10);
        ZipHashBuckets hashBucket = new ZipHashBuckets("postnummer.csv", 10000);
        System.out.println(hashBucket.lookUp(97232));

        ZipHashForward hashForward = new ZipHashForward("postnummer.csv", 40000);
        System.out.println(hashForward.lookUp(97232));
        // ZipHash zipHash= new ZipHash("postnummer.csv");
        // zipHash.collisions(10000);

    }

    public static void benchmark(int size) {

        Zip zInt = new Zip("postnummer.csv");
        ZipString zString = new ZipString("postnummer.csv");
        ZipIndex zIndex = new ZipIndex("postnummer.csv");
        String find = "984 99";
        int find2 = 98499;

        // int
        long t0Int = System.nanoTime();
        for (int i = 0; i < size; i++) {

            zInt.lookUp(find2);
        }
        long resInt = (System.nanoTime() - t0Int);

        // binary search
        long t0Bin = System.nanoTime();
        for (int i = 0; i < size; i++) {

            zInt.binaryLookup(find2);
        }
        long resBin = (System.nanoTime() - t0Bin);

        // String
        long t0String = System.nanoTime();
        for (int i = 0; i < size; i++) {

            zString.lookUp(find);
        }
        long resString = (System.nanoTime() - t0String);

        // Index
        long t0Index = System.nanoTime();
        for (int i = 0; i < size; i++) {

            zIndex.lookUp(find2);
        }
        long resIndex = (System.nanoTime() - t0Index);

        System.out.println("Int: " + resInt / 1000000 + " ms \t\t" + "String: " + resString / 1000000 + " ms\t\t"
                + "Index: " + resIndex + " ms" + "\t\tBinary: " + resBin / 1000000 + " ms\t\tStorlek: " + size);

    }

    public static void benchmark2(int size) {
        ZipHashBuckets hashBucket = new ZipHashBuckets("postnummer.csv", 10000);
        ZipHashForward hashForward = new ZipHashForward("postnummer.csv", 20000);
        int find2 = 98499;

        // HashBucket
        long t0Int = System.nanoTime();
        for (int i = 0; i < size; i++) {
            hashBucket.lookUp(find2);

        }
        long resInt = (System.nanoTime() - t0Int);

        // HashForward
        // Index
        long t0Index = System.nanoTime();
        for (int i = 0; i < size; i++) {
            hashForward.lookUp(find2);

        }
        long resIndex = (System.nanoTime() - t0Index);

        System.out.println(
                "Bucket: " + resInt / 1000000 + " ms\t\tForward: " + resIndex / 1000000 + " ms" + "\t\tStorlek:"
                        + size);

    }

}