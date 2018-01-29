import java.util.Objects;

public class place {
    String name;
    String region;
    String country;
    double latitude;
    double longitude;
    double distanceFromOrigin;//optional

    //default constructor
    public place(){
        name = "";
        region = "";
        country = "";
        latitude = 0.0;
        longitude = 0.0;
        distanceFromOrigin = 0.0;
    }

    //constructor
    public place(String name, String region, String country, double latitude, double longitude) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        //this.distanceFromOrigin = distanceFromOrigin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getDistanceFromOrigin() {
        return distanceFromOrigin;
    }

    public void setDistanceFromOrigin(double distanceFromOrigin) {
        this.distanceFromOrigin = distanceFromOrigin;
    }

    @Override
    public String toString() {
        return "place{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", distanceFromOrigin=" + distanceFromOrigin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        place place = (place) o;
        return Double.compare(place.latitude, latitude) == 0 &&
                Double.compare(place.longitude, longitude) == 0 &&
                Double.compare(place.distanceFromOrigin, distanceFromOrigin) == 0 &&
                Objects.equals(name, place.name) &&
                Objects.equals(region, place.region) &&
                Objects.equals(country, place.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region, country, latitude, longitude, distanceFromOrigin);
    }
}
