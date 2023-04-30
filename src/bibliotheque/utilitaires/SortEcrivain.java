package bibliotheque.utilitaires;

import bibliotheque.metier.Auteur;

import java.util.Comparator;

public class SortEcrivain implements Comparator<Auteur> {
    @Override
    public int compare(Auteur o1, Auteur o2) {
        int NameCompare = o1.getNom().compareToIgnoreCase(o2.getNom());
        int PrenCompare = o1.getPrenom().compareToIgnoreCase(o2.getPrenom());

        return (NameCompare == 0)? PrenCompare: NameCompare;
    }
}
