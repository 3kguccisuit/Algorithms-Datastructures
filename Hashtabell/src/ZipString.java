import java.io.BufferedReader;
import java.io.FileReader;

public class ZipString {
    Node[] data;
    int max;

    public class Node {
        String postCode;
        String name;
        int value;
        Node next;

        public Node(String code, String name, int pop) {
            this.postCode = code;
            this.name = name;
            this.value = pop;
        }

        @Override
        public String toString() {
            return this.name + "Postnummer: " + this.postCode + ", Värde:" + this.value;
        }
    }

    public ZipString(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2])); //sträng på nodens postcode
            }
            max = i - 1;

        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    // O(n)
    public Node lookUp(String postNum) {
        Node ret = data[1];

        for (int i = 0; i < data.length - 1; i++) {
            if (data[i].postCode.equals(postNum)) {
                ret = data[i];
                return ret;
            }
        }
        return ret;
    }

}