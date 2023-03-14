package bibliotheque.utilitaires;

import bibliotheque.metier.Auteur;

import java.util.Comparator;

public class SortAuteurByName implements Comparator<Auteur> {
    @Override
    public int compare(Auteur o1, Auteur o2) {
        return o1.getNom().compareTo(o2.getNom());
    }
}
