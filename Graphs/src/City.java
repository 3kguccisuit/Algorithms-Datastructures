public class City {
    String name;
    Connection[] connections;

    public class Connection {
        City startCity;
        City endCity;
        int length;

        public Connection(City start, City destination, int distance) {
            startCity = start;
            endCity = destination;
            length = distance;
        }

        @Override
        public String toString() {
            return "Start: " + this.startCity + " End: " + this.endCity + " length: " + this.length;
        }
    }

    public City(String name) {
        this.name = name;
        connections = new Connection[3];
    }

    public void AddConnection(City destination, int distance) {
        int i = 0;
        // Go to the first empty location in the array
        while (connections[i] != null)
            i++;

        // Create a new connection
        connections[i] = new Connection(this, destination, distance);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(this.name + ":");

        for (Connection connection : connections) {
            if (connection != null) {
                str.append(" [" + connection.startCity.name);
                str.append("-");
                str.append(connection.endCity.name);
                str.append(" ");
                str.append(connection.length + "] ");
            }
        }
        return str.toString();
    }

}