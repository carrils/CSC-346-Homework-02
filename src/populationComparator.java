import java.util.Comparator;

public class populationComparator implements Comparator<place> {
    public int compare(place p1, place p2){
        return p1.getPopulation() - p2.getPopulation();
    }
}
