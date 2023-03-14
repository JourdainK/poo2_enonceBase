package bibliotheque.utilitaires;

import bibliotheque.metier.Exemplaire;

import java.util.Comparator;

public class SortExempByName implements Comparator<Exemplaire> {
    @Override
    public int compare(Exemplaire o1, Exemplaire o2) {
        return o1.getOuvrage().getTitre().compareTo(o2.getOuvrage().getTitre());
    }
}
