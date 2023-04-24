package bibliotheque.utilitaires;

import bibliotheque.metier.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DVDFactory extends OuvrageFactory{
    public Ouvrage addDetail(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre){
        long code=0;
       do{
           try{
               System.out.println("code : ");
              // sc.skip("\n");
               String codes = sc.nextLine();
               code= Long.parseLong(codes);

               break;
           }catch(Exception e) {
               System.out.println("Erreur le code encodé n'est pas un nombre");
           }

       }while(true);

        System.out.println("Saisir la durée");
        LocalTime dureeTotale=Utilitaire.lecTime();
        byte nbreBonus;
        try{
            System.out.println("Saisir le nombre de bonus : ");
            nbreBonus= sc.nextByte();sc.skip("\n");
        }catch (Exception e){
            System.out.println("Erreur lors de l'encodage des bonus : " + e);
        }
        DVD dvd =new DVD(titre,ageMin,dateParution,prixLocation,langue,genre,code,dureeTotale,nbreBonus);
        System.out.println("autres langues :");
        List<String> langues = new ArrayList<>(Arrays.asList("anglais","français","italien","allemand","fin"));
        int choix;
        do{
            choix=Utilitaire.choixListe(langues);
            if(choix==langues.size())break;
            dvd.getAutresLangues().add(langues.get(choix-1));//TODO gérer msg d'erreur en cas de doublon
        }while(true);
        System.out.println("sous-titres :");
        do{
            choix=Utilitaire.choixListe(langues);
            if(choix==langues.size())break;
            dvd.getSousTitres().add(langues.get(choix-1));//TODO gérer msg d'erreur en cas de doublon
        }while(true);
        return dvd;
    }
}
