package bibliotheque.utilitaires;

import bibliotheque.metier.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static bibliotheque.utilitaires.Utilitaire.isStrInList;

public class DVDFactory extends OuvrageFactory {
    public Ouvrage addDetail(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre) {
        System.out.println("code : ");
        long code = sc.nextLong();
        LocalTime dureeTotale = Utilitaire.lecTime();
        byte nbreBonus = sc.nextByte();
        DVD dvd = new DVD(titre, ageMin, dateParution, prixLocation, langue, genre, code, dureeTotale, nbreBonus);
        System.out.println("autres langues");
        List<String> langues = new ArrayList<>(Arrays.asList("anglais", "français", "italien", "allemand", "fin"));
        int choix;
        do {
            choix = Utilitaire.choixListe(langues);
            if (choix == langues.size()) break;
            if (!isStrInList(langues.get(choix - 1), dvd.getAutresLangues())) {
                dvd.getAutresLangues().add(langues.get(choix - 1));
            } else {
                System.out.println(langues.get(choix - 1) + "  : déja présent présent dans la liste des langues");
            }

        } while (true);
        System.out.println("sous-titres");
        do {
            choix = Utilitaire.choixListe(langues);
            if (choix == langues.size()) break;
            if (!isStrInList(langues.get(choix - 1), dvd.getSousTitres())) {
                dvd.getSousTitres().add(langues.get(choix - 1));
            } else {
                System.out.println(langues.get(choix - 1) + "  : déja présent présent dans la liste des sous-titres");
            }
        } while (true);
        return dvd;
    }
}
