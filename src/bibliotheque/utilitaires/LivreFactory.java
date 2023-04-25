package bibliotheque.utilitaires;

import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;
import bibliotheque.metier.TypeOuvrage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LivreFactory extends OuvrageFactory{
      public Ouvrage addDetail(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre){
        System.out.println("isbn ");
        String isbn = sc.next();
        int nbrePages;
        try{
            System.out.println("pages ");
            nbrePages = sc.nextInt();
            sc.skip("\n");
        }catch (Exception e){
            System.out.println("Erreur d'encodage du nombre de pages : " + e.getMessage());
            System.out.println("Nombre de pages adapté à : 0");
            nbrePages = 0;
            //to delete
            e.printStackTrace();
        }
        TypeLivre[] ttl = TypeLivre.values();
        List<TypeLivre> ltl = new ArrayList<>(Arrays.asList(ttl));
        int choix = Utilitaire.choixListe(ltl);
        TypeLivre tl = ttl[choix-1];
        System.out.println("résumé du livre :");
        String resume = sc.nextLine();

        //TODO ask if the code below is correct ( return inside catch ? )
        try{
            Livre l=new Livre(titre,ageMin,dateParution,prixLocation,langue,genre,isbn,nbrePages,tl,resume);
            return l;
        }catch (Exception e){
            System.out.println("Erreur : " + e.getMessage());
            //to delete for release
            e.printStackTrace();
            return null;
        }
   }
}
