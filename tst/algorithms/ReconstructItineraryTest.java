package algorithms;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ReconstructItineraryTest {

    ReconstructItinerary recon = new ReconstructItinerary();

    @Test
    public void testFindItinerary() {
        List<List<String>> trips = new ArrayList<>();
        trips.add(Lists.newArrayList("MUC", "LHR"));
        trips.add(Lists.newArrayList("JFK", "MUC"));
        trips.add(Lists.newArrayList("SFO", "SJC"));
        trips.add(Lists.newArrayList("LHR", "SFO"));
        trips.add(Lists.newArrayList("SFO", "SEA"));

        List<String> itin = recon.findItinerary(trips);
        System.out.println(itin);
    }
}