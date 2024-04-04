import java.io.BufferedReader;
import java.io.FileReader;

public class ZipHash {
    Node[] data;
    int[] keys = new int[9675 + 1]; // Vi har 9675 postnummer
    int max;

    public class Node {
        int postCode;
        String name;
        int value;
        Node next;

        public Node(int code, String name, int pop) {
            this.postCode = code;
            this.name = name;
            this.value = pop;
        }

        @Override
        public String toString() {
            return this.name + "Postnummer: " + this.postCode + ", Värde:" + this.value;
        }
    }

    // Vår egen
    public ZipHash(String file, int mod) {
        int[] data = new int[mod];
        // int[] cols = new int[10];
        int cols = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                Integer index = code % mod;
                // cols[data[index]]++;
                // data[index]++;
                if (data[index] == 0)
                    data[index] = code;
                else {
                    cols++;
                    // System.out.printf("Collision: postnummer: %d index: %d tidigare
                    // postnummer:%d\n", code, index, data[index]);
                }
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
        System.out.printf("collisions: %d: size: %d\n", cols, mod);

        // return cols;

    }

    public void collisions(int mod) {

        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        System.out.println(mod);
        System.out.println("Antal kollisioner typ 0ggr, 1ggr, 2ggr...");
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
        for (int i = 0; i < mod; i++) {
            if (data[i] == 9) {
                System.out.printf("Index: %d\n", i);
                for (int j = 0; j < max; j++) {
                    Integer index = keys[j] % mod;
                    if (index == i) {
                        System.out.printf("\t%d\n", keys[j]);
                    }
                }
            }
        }
        System.out.println();
    }

    public void collisions2(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
        Integer index = keys[i] % mod;
        cols[data[index]]++;
        data[index]++;
        }
        System.out.print("Storlek: " + mod);
        for (int i = 0; i < 10; i++) {
        System.out.print("\t" + cols[i]);
        }
        System.out.println();
        }

    public ZipHash(String file) {

        int i = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));

                keys[i++] = code;
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    // O(1)
    public Node lookUp(int postNum) {

        return data[postNum];
    }
}