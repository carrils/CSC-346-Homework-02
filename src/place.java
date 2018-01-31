import java.util.Objects;

public class place {
    private static final int EARTH_RADIUS_KM = 6371; // Approx Earth radius in KM
    private static final int EARTH_RADIUS_MILES = 3959;//Approx Earth radius in Miles

    String name;
    String state;
    String country;
    double distanceFromOriginKM;
    double distanceFromOriginMiles;
    int population;
    int housingunits;
    int zipcode;


    //default constructor
    public place(){
        name = "";
        state = "";
        country = "";
        distanceFromOriginKM = 0.0;
        distanceFromOriginMiles = 0.0;
        zipcode = 0;
        housingunits = 0;
        population = 0;
    }

    //constructor
    public place(String name, String state, int zipcode, String country, int housingunits, int population, double distanceFromOriginKM, double distanceFromOriginMiles) {
        this.name = name;
        this.state = state;
        this.country = country;
        this.distanceFromOriginKM = distanceFromOriginKM;
        this.distanceFromOriginMiles = distanceFromOriginMiles;
        this.population = population;
        this.housingunits = housingunits;
        this.zipcode = zipcode;
    }

    public static double distanceKM(double startLat, double startLong,
                                  double endLat, double endLong) {
        /**
         * Jason Winn
         * http://jasonwinn.org
         * Created July 10, 2013
         */
        double dLat  = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat   = Math.toRadians(endLat);

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(startLat) * Math.cos(endLat) * Math.pow(Math.sin(dLong / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_KM * c; // <-- distance in km
    }

    public static double distanceMiles(double startLat, double startLong,
                                    double endLat, double endLong) {
        double dLat  = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat   = Math.toRadians(endLat);

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(startLat) * Math.cos(endLat) * Math.pow(Math.sin(dLong / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_MILES* c; // <-- distance in miles
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String region) {
        this.state = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getDistanceFromOriginKM() {
        return distanceFromOriginKM;
    }

    public void setDistanceFromOriginKM(double distanceFromOrigin) {
        this.distanceFromOriginKM = distanceFromOrigin;
    }

    public double getDistanceFromOriginMiles() {
        return distanceFromOriginMiles;
    }

    public void setDistanceFromOriginMiles(double distanceFromOrigin) {
        this.distanceFromOriginMiles = distanceFromOrigin;
    }

    @Override
    public String toString() {
        return name + '\'' + state + '\'' +
                zipcode +  '\'' + country +
                '\'' + distanceFromOriginKM +  '\''  +
                distanceFromOriginMiles+   '\''   + housingunits +
                '\''   + population +   '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        place place = (place) o;
        return Double.compare(place.distanceFromOriginKM, distanceFromOriginKM) == 0 &&
                Double.compare(place.distanceFromOriginMiles, distanceFromOriginMiles) == 0 &&
                population == place.population &&
                housingunits == place.housingunits &&
                zipcode == place.zipcode &&
                Objects.equals(name, place.name) &&
                Objects.equals(state, place.state) &&
                Objects.equals(country, place.country);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, state, country, distanceFromOriginKM, distanceFromOriginMiles, population, housingunits, zipcode);
    }
}
