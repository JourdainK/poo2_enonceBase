package bibliotheque.utilitaires;

import bibliotheque.metier.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static bibliotheque.utilitaires.Utilitaire.*;
public class DVDFactory extends OuvrageFactory{
    public Ouvrage addDetail(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre){
        System.out.println("code : ");
        long code= lireLong();
        LocalTime dureeTotale=lecTime();
        byte nbreBonus= (byte)lireInt();
        DVD dvd = null;
        try {
            dvd = new DVD(titre,ageMin,dateParution,prixLocation,langue,genre,code,dureeTotale,nbreBonus);
        } catch (Exception e) {
            System.out.println("erreur :"+e);
        }
        System.out.println("autres langues");
        List<String> langues = new ArrayList<>(Arrays.asList("anglais","français","italien","allemand","fin"));
        int choix;
        do{
            choix=Utilitaire.choixListe(langues);
            if(choix==langues.size())break;
            dvd.getAutresLangues().add(langues.get(choix-1));//TODO gérer msg d'erreur en cas de doublon
        }while(true);
        System.out.println("sous-titres");
        do{
            choix=Utilitaire.choixListe(langues);
            if(choix==langues.size())break;
            dvd.getSousTitres().add(langues.get(choix-1));//TODO gérer msg d'erreur en cas de doublon
        }while(true);
        return dvd;
    }
}
