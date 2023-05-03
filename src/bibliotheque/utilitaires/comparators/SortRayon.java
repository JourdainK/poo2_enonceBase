package bibliotheque.utilitaires.comparators;

import bibliotheque.metier.Rayon;

import java.util.Comparator;

public class SortRayon implements Comparator<Rayon> {
    @Override
    public int compare(Rayon o1, Rayon o2) {
        return o1.getCodeRayon().compareToIgnoreCase(o2.getCodeRayon());
    }
}
