import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Map {
    Bucket[] cities;
    int mod;

    private class Bucket {
        City city;
        private Bucket next;

        public Bucket(String name) {
            city = new City(name);
            next = null;
        }

    }

    public Map(String file) throws Exception, IOException {
        mod = 541;
        cities = new Bucket[mod];

        try{

        Path path = Paths.get(file);
        List<String> list = Files.readAllLines(path, StandardCharsets.UTF_8);

        for (String line : list) {
            String[] row = line.split(",");
            // Create or find the two cities
            City city1 = LookUp(row[0]);
            City city2 = LookUp(row[1]);

            int length = Integer.valueOf(row[2]);

            city1.AddConnection(city2, length);
            city2.AddConnection(city1, length);
        
        }
    } catch (Exception e) {
        System.out.println(" file " + file + " not found" + e.getMessage());
    }

        // try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        //     String line;
        //     while ((line = br.readLine()) != null) {
        //         String[] row = line.split(",");
        //         // Create or find the two cities
        //         City city1 = LookUp(row[0]);
        //         City city2 = LookUp(row[1]);

        //         int length = Integer.valueOf(row[2]);

        //         city1.AddConnection(city2, length);
        //         city2.AddConnection(city1, length);
        //     }
        // } catch (Exception e) {
        //     System.out.println(" file " + file + " not found" + e.getMessage());
        // }
    }
    public void Display() {
        for (int i=0; i<541;i++)
        {
            if (cities[i]!=null)
            {
                System.out.printf("%d %s \n",i,cities[i].city);
            }
        }

    }

    private Integer Hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

    public City LookUp(String name) {
        int index = Hash(name);

        // Create a city if there are no yet
        if (cities[index] == null) {
            cities[index] = new Bucket(name);
            return cities[index].city;
        }

        // If there already is a city at the position check through the linked Buckets
        if (cities[index].city.name != name) {
            // Pointer to look through the linked buckets
            Bucket pointer = cities[index];

            // Go to the last linked Buckets or stop if name is found
            while (!pointer.city.name.equals(name) && pointer.next != null) {
                pointer = pointer.next;
            }

            // Set the new City to the next bucket if it does not exist
            if (!pointer.city.name.equals(name)) {
                pointer.next = new Bucket(name);
                return pointer.next.city;
            } else
                return pointer.city;
        }

        // Return the city.
        return cities[index].city;
    }

}