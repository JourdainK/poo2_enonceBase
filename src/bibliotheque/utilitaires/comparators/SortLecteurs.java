package bibliotheque.utilitaires.comparators;

import bibliotheque.metier.Lecteur;

import java.util.Comparator;

public class SortLecteurs implements Comparator<Lecteur> {
    @Override
    public int compare(Lecteur o1, Lecteur o2) {
        int nameCompare = o1.getNom().compareToIgnoreCase(o2.getNom());
        int prenCompare = o2.getPrenom().compareToIgnoreCase(o2.getPrenom());
        return (nameCompare==0)? prenCompare : nameCompare;
    }
}
