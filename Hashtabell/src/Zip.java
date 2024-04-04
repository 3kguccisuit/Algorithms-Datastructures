import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {
    Node[] data;
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

    public Zip(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                // data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2])); //sträng på
                // nodens postcode
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i - 1;

        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    // O(n)
    public Node lookUp(int postNum) {
        Node ret = data[1];

        for (int i = 0; i < data.length - 1; i++) {
            if (data[i].postCode == postNum) {
                ret = data[i];
                return ret;
            }
        }
        return ret;
    }

    public Node binaryLookup(Integer zip) {
        int min = 0;
        int mx = this.max;
        while (true) {
            int index = (min + mx) / 2;
            int compare = zip.compareTo(data[index].postCode);// returns 0 if they are equal
            if (compare == 0) {
                return data[index];
            }
            if (compare > 0 && index < mx) {
                min = index + 1;
                continue;
            }
            if (compare < 0 && index > min) {
                mx = index - 1;
                continue;
            }
            break;
        }
        return null;
    }
    
}