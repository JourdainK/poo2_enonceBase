package bibliotheque.utilitaires;

import bibliotheque.metier.Exemplaire;

import java.util.Comparator;

public class SortExemByMatricule implements Comparator<Exemplaire> {
    @Override
    public int compare(Exemplaire o1, Exemplaire o2) {
        return o1.getMatricule().compareTo(o2.getMatricule());
    }
}
