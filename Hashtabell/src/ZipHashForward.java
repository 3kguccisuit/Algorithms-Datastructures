import java.io.BufferedReader;
import java.io.FileReader;
import java.text.MessageFormat;

public class ZipHashForward {
    private int size;
    private final int mod = 10000;
    private Node[] data;

    private class Node {
        int postCode;
        String name;
        int value;

        public Node(int code, String name, int pop) {
            this.postCode = code;
            this.name = name;
            this.value = pop;
        }

        @Override
        public String toString() {
            return this.name + " Postnummer: " + this.postCode + ", Värde:" + this.value;
        }
    }
    private class NodeIntTuple
    {
        public Node node;
        public int depth;
        public int index;
        public NodeIntTuple(int index, Node node, int depth) {
            this.node = node;
            this.depth = depth;
            this.index = index;
        }

        @Override
        public String toString() {
            return (MessageFormat.format("Index: {0}, Node [{1}], depth {2}",index, node, depth));
        }
    }

    // Vår egen
    public ZipHashForward(String file, int size) {
        data = new Node[this.size = size];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                int code = Integer.valueOf(row[0].replaceAll("\\s", ""));

                // Beräkna hash
                int index = code % mod;
                Node newNode = new Node(code, row[1].trim(), Integer.valueOf(row[2]));

                if (data[index] == null) {
                    data[index] = newNode;
                } else {

                    while (index < size && data[index] != null) {
                        index++;
                    }

                    if (index >= size)
                        throw new ArrayIndexOutOfBoundsException(MessageFormat.format("Hamnat utanför code {0} index {1} >= size {2}!",code, index,size));

                    data[index] = newNode;
                }
            }
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("!" + e.toString());
        }

        catch (Exception e) {
            System.out.println(" file " + file + " not found" + e.getMessage());
        }
    }

    public NodeIntTuple lookUp(int postNum) {
        int index = postNum % mod;
        int depth = 0;
        while (data[index] != null && index < size) {
            if (data[index].postCode == postNum){
                System.out.println(depth);
            return new NodeIntTuple(index, data[index], depth);
            //return data[index];
            }
               
            else{
                index++;
                depth++;
            }
        }
        return null;
    }

}