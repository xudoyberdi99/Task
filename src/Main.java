

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<City> cities = readFromCSV("task/myFile0.csv");

       // b)Sort the loaded data numerically for the numeric data
        cities.sort(Comparator.comparing(City::getCityCode));
        System.out.println(cities);

        // b) descending Sort the loaded data numerically for the numeric data
        cities.sort((o1, o2) -> {
            if (o1.getCityCode()<o2.getCityCode()){
                return 1;
            }else if (o1.getCityCode()>o2.getCityCode()){
                return -1;
            }else {
                return 0;
            }
        });
        System.out.println(cities);

      //  a)Sort the loaded data alphabetically for the string data
        cities.sort(Comparator.comparing(City::getCity));
        System.out.println(cities);

       // c)Write the unit test that prints the a) and b)
        cities.sort(Comparator.comparing(City::getCityCode).thenComparing(City::getCity));
        System.out.println(cities);

        cities.sort(Comparator.comparing(City::getCity).thenComparing(City::getCityCode));
        System.out.println(cities);
    }

    // read from csv
    private static List<City> readFromCSV(String fileName) {
        List<City> cities=new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(pathToFile)))){

            String line = reader.readLine();

            while (line != null){
                String[] attributes = line.split(",");
                City cities1=createCity(attributes);
                System.out.println();
                cities.add(cities1);
                line = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return cities;
    }

    // create new city
    private static City createCity(String[] metadata) {
        int city_code = Integer.parseInt(metadata[0]);
        String city = metadata[1];
        return new City(city_code,city);
    }

}