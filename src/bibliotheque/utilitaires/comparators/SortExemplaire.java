package bibliotheque.utilitaires.comparators;

import bibliotheque.metier.Exemplaire;

import java.util.Comparator;

public class SortExemplaire implements Comparator<Exemplaire> {
    @Override
    public int compare(Exemplaire o1, Exemplaire o2) {
        return o1.getMatricule().compareToIgnoreCase(o2.getMatricule());
    }
}
