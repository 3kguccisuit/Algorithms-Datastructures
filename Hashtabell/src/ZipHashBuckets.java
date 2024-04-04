import java.io.BufferedReader;
import java.io.FileReader;

public class ZipHashBuckets {
    final int size = 9675 + 1; // Vi har 9675 postnummer
    private Bucket[] data;
    // private int[] keys = new int[size];
    private int max;
    int cols=0;

    private class Node {
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

    private class Bucket {
        private Node code;
        private Bucket next;

        public Bucket(int code, String location, int population) {
            this.code = new Node(code, location, population);
            next = null;
        }

        public Bucket(Node node) {
            this.code = node;
            next = null;
        }

        public Node GetCode() {
            return code;
        }

        public void SetCode(Node node) {
            code = node;
        }

        public Bucket GetNext() {
            return next;
        }

        public void SetNext(Bucket bucket) {
            next = bucket;
        }
    }

    // Vår egen
    public ZipHashBuckets(String file, int mod) {
        data = new Bucket[mod];
        max=mod;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                int code = Integer.valueOf(row[0].replaceAll("\\s", ""));

                // Beräkna hash
                int index = code % mod;

                if (data[index] == null){
                    data[index] = new Bucket(code, row[1], Integer.valueOf(row[2]));
                }
                else {
                    Bucket prev = data[index];
                    Bucket iterator = data[index].GetNext();
                    while (iterator != null)
                    {
                        prev = iterator;
                        iterator = iterator.GetNext();
                    }
                    prev.SetNext(new Bucket(code, row[1], Integer.valueOf(row[2])));
                    
                }
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found" + e.getMessage());
        }
    }

public Node lookUp(int postNum){
    int index = postNum % max;
    Bucket iterator = data[index];
    int depth=0;

    while(iterator!=null){
        if(iterator.code.postCode !=postNum) {
            iterator = iterator.next;
            depth++;
        } else{
            System.out.println(depth);
            return iterator.GetCode();
        }
    }
    return null;
}


}