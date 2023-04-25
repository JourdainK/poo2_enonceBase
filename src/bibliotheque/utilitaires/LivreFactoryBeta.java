package bibliotheque.utilitaires;

import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LivreFactoryBeta {
    protected Scanner sc= new Scanner(System.in);
    public Ouvrage create() {

        System.out.println("titre");
        String titre= sc.nextLine();
        int ageMin;
        try{
            System.out.println("age minimum");
            ageMin= sc.nextInt();
            sc.skip("\n");
        }catch (Exception e){
            System.out.println("Erreur d'encodage de l'age : " + e.getMessage());
            ageMin=0;
            //to delete
            e.printStackTrace();
        }
        System.out.println("date de parution");
        LocalDate dp= Utilitaire.lecDate();
        double ploc;
        try{
            System.out.println("prix de location");
            ploc = sc.nextDouble();
            sc.skip("\n");
        }catch (Exception e){
            System.out.println("Erreur d'encodage du prix : " + e.getMessage());
            System.out.println("Le prix adapté à 0 ");
            ploc = 0;
            //to delete
            e.printStackTrace();
        }
        System.out.println("langue");
        String langue=sc.nextLine();
        System.out.println("genre");
        String genre=sc.nextLine();

        //détails propres à la classe Livre
        System.out.println("isbn ");
        String isbn = sc.next();
        int nbrePages;
        try{
            System.out.println("pages ");
            nbrePages = sc.nextInt();
            sc.skip("\n");
        }catch (Exception e){
            System.out.println("Erreur d'encodage du nombre de page : " + e.getMessage());
            System.out.println("nombre de pages adapté à : 0");
            nbrePages = 0;
            // to delete
            e.printStackTrace();
        }
        TypeLivre[] ttl = TypeLivre.values();
        List<TypeLivre> ltl = new ArrayList<>(Arrays.asList(ttl));
        int choix = Utilitaire.choixListe(ltl);
        TypeLivre tl = ttl[choix-1];
        System.out.println("résumé du livre :");
        String resume = sc.nextLine();
        try{
            Livre l=new Livre(titre,ageMin,dp,ploc,langue,genre,isbn,nbrePages,tl,resume);
            return l;
        }catch (Exception e){
            System.out.println("Erreur : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
