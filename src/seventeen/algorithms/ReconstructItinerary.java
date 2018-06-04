package seventeen.algorithms;

import java.util.*;
import java.util.LinkedList;

public class ReconstructItinerary {

    private Map<String, List<String>> cityToDest = new HashMap<>();

    public List<String> findItinerary(String[][] tickets) {
        for (String[] ticket : tickets) {
            String city = ticket[0];
            List<String> destinations = cityToDest.getOrDefault(city, new ArrayList<>());

            String destination = ticket[1];
            destinations.add(destination);
            cityToDest.put(city, destinations);
        }

        System.out.println(cityToDest);

        List<String> intinerary = new java.util.LinkedList<>();
        dfs(intinerary);
        return intinerary;
    }

    private void dfs(List<String> intinerary) {
        Deque<String> toVisit = new LinkedList<>();
        toVisit.add("JFK");

        while (!toVisit.isEmpty()) {
            String nextCity = toVisit.poll();
            intinerary.add(nextCity);

            List<String> destinations = cityToDest.get(nextCity);
            if (destinations == null) {
                break;
            }

            for (String destination : destinations) {
                toVisit.push(destination);
            }
        }
    }

    public static void main(String[] args) {
        ReconstructItinerary ri = new ReconstructItinerary();
        String[][] tickets = {
                {"SEA", "PDX"},
                {"PDX", "IAD"},
                {"JFK", "SEA"},
                {"IAD", "DFW"},
                {"GC0", "GC1"}
        };

        List<String> initerary = ri.findItinerary(tickets);
        System.out.println(initerary);
    }
}
