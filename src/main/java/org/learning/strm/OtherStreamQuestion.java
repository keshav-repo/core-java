package org.learning.strm;

import java.util.*;
import java.util.stream.Collectors;

class City {
    private String name;
    private double temperature;

    public City(String name, double temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public Double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return name + " --> " + temperature;
    }
}

public class OtherStreamQuestion {

    static List<City> cities = prepareTemperature();

    private static List<City> prepareTemperature() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("New Delhi", 33.5));
        cities.add(new City("Mexico", 14));
        cities.add(new City("New York", 13));
        cities.add(new City("Dubai", 43));
        cities.add(new City("London", 15));
        cities.add(new City("Alaska", 1));
        cities.add(new City("Kolkata", 30));
        cities.add(new City("Sydney", 11));
        cities.add(new City("Mexico", 14));
        cities.add(new City("Dubai", 43));
        return cities;
    }

    public static void main(String[] args) {

        Map<String, Double> cityTempMap = cities
                .stream()
                .filter(city -> city.getTemperature() > 10)
                .collect(Collectors.toMap(
                        City::getName,
                        City::getTemperature,
                        (key, identicalKey) -> key));

        System.out.println(cityTempMap);

        Map<String, Integer> cityCountMap = cities
                .stream()
                .collect(Collectors.groupingBy(
                        City::getName,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                f -> f.intValue())));

        System.out.println(cityCountMap);

        Map<String, Long> cityCountsMap = cities
                .stream()
                .collect(Collectors.groupingBy(
                        City::getName,
                        Collectors.counting()));

        System.out.println(cityCountsMap);

        Map<String, List<City>> stringListMap = cities
                .stream()
                .collect(Collectors.groupingBy(City::getName));
        System.out.println(stringListMap);


        System.out.println(prepareTemperature()
                .stream()
                .filter(city -> city.getTemperature() > 10)
                .map(f -> f.getName())
                .collect(Collectors.joining(", ")));


        String join3 = cities
                .stream()
                .filter(city -> city.getTemperature() > 10)
                .map(f -> f.getName())
                .collect(Collectors.joining(" ",
                        "Prefix:", ":Suffix"));
        System.out.println(join3);

         Map<Boolean, List<City>> cityIn2GroupByTemp =  cities
                .stream()
                .collect(Collectors.partitioningBy(
                        city -> city.getTemperature() > 15));

        Map<Boolean, List<City>> cityIn2GroupByTemp2 =  cities
                .stream()
                .collect(Collectors.partitioningBy(
                        city -> city.getTemperature() > 15, Collectors.toList()));

        System.out.println(cityIn2GroupByTemp);

    }
}

