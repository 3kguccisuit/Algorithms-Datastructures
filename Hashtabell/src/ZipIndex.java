import java.io.BufferedReader;
import java.io.FileReader;

public class ZipIndex {
    Node[] data;
    int [] keys;
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

    public ZipIndex(String file) {
        data = new Node[100000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i=0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
                i++;
            }
            max= i-max;

        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }


    // O(1)
    public Node lookUp(int postNum) {

        return data[postNum];
    }

    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }

}