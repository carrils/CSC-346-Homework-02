import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class placeTest {

    @Test
    void distanceKM() {
        //the distance from kansas city to saint joseph in km
        assertEquals(78.02660617514064, place.distanceKM(39.09, -94.58, 39.76, -94.85));
        //the distance from kansas city to los angeles in km
        assertEquals(2182.3462045229703, place.distanceKM(39.09,-94.58,33.97, -118.24));
        //the distance from kansas city to houston texas in km
        assertEquals(1040.0265175762927,place.distanceKM(39.09, -94.58,29.76, -95.38) );
    }

    @Test
    void distanceMiles() {
        //the distance from kansas city to saint joseph in miles
        assertEquals(48.48647525465104, place.distanceMiles(39.09,-94.58,39.76, -94.85));
        //the distance from kansas city to los angeles in miles
        assertEquals(1356.1306896415695, place.distanceMiles(39.09,-94.58, 33.97, -118.24));
        //the distance from kansas city to houston texas in miles
        assertEquals(646.2823705987353, place.distanceMiles(39.09, -94.58,29.76, -95.38));
    }
}