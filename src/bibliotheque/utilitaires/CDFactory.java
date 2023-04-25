package bibliotheque.utilitaires;

import bibliotheque.metier.CD;
import bibliotheque.metier.DVD;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeOuvrage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CDFactory extends OuvrageFactory{
    public Ouvrage addDetail(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre) {
        long code = 0;
        try {
            System.out.println("code : ");
            code = sc.nextLong();
        } catch (NumberFormatException e) {
            System.out.println("Erreur, nombre invalide : " + e);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erreur");
            e.printStackTrace();
        }

        System.out.println("nombre de plages :");
        byte nbrePlages = sc.nextByte();
        sc.skip("\n");
        System.out.println("durée en H M S : ");
        LocalTime dureeTotale = Utilitaire.lecTime();
        CD cd = null;
        try{
            cd = new CD(titre, ageMin, dateParution, prixLocation, langue, genre, code, nbrePlages, dureeTotale);
        }catch (Exception e){
            System.out.println("Erreur lors de la création du cd : " + e.getMessage());
            e.printStackTrace();
        }
        return cd;
    }
}
