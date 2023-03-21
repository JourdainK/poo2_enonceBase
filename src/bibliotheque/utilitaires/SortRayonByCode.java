package bibliotheque.utilitaires;

import bibliotheque.metier.Rayon;

import java.util.Comparator;

public class SortRayonByCode implements Comparator<Rayon> {
    @Override
    public int compare(Rayon o1, Rayon o2) {
        return o1.getCodeRayon().compareTo(o2.getCodeRayon());
    }
}