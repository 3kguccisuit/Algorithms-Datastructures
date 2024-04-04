import java.util.Random;

class Main {

    public static void main(String[] args) {

        try {
            // Map map = new Map("C:\\Users\\ludwi\\OneDrive\\Skrivbord\\kth\\Algoritmer och datastrukturer\\Graphs\\trains.csv");
            Map map = new Map("C:\\Users\\ludwi\\OneDrive\\Skrivbord\\kth\\Algoritmer och datastrukturer\\Graphs\\trainsTest.csv");

            map.Display();
            System.out.printf("\n");
            String from = "Malmö";
            // String to = "Göteborg";
            String to = "Hässleholm";

            int max = 44;

            // Naive
            long t0 = System.nanoTime();
            Integer dist = shortest(map.LookUp(from), map.LookUp(to), max);
            System.out.println("Distance:" + dist);
            long time = (System.nanoTime() - t0) / 1_000_000;

            // System.out.println(map.LookUp("Stockholm"));
            // System.out.println(map.LookUp("Alvesta"));
            // System.out.println(map.LookUp("Södertälje"));
        } catch (Exception e) {
            String msg = e.getCause().toString();
            System.out.println("Exception:" + msg);
        }

    }

    private static Integer shortest(City from, City to, Integer max) {
        System.out.printf("S: %s <=> %s %d\n",from,to, max);
        if (max < 0)
            return null;
        if (from == to)
            return 0;
        Integer shrt = null;

        for (int i = 0; i < from.connections.length; i++) {
            if (from.connections[i] != null) {
                City.Connection conn = from.connections[i];

                City f;
                if (conn.endCity.name.equals(from.name))
                    f = conn.startCity;
                else
                    f = conn.endCity;

                shrt = conn.length;

                Integer r = shortest(f, to, max - conn.length);
                if (r != null)
                    shrt += r;

            }
        }
        return shrt;
    }

}