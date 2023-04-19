package bibliotheque.utilitaires;


import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeOuvrage;

import java.time.LocalDate;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.saisie;

public  abstract class OuvrageFactory {
   protected Scanner sc= new Scanner(System.in);
   public Ouvrage create() {

       System.out.println("titre");
       String titre= sc.nextLine();
       System.out.println("age minimum");
       int ageMin= sc.nextInt();
       sc.skip("\n");
       System.out.println("date de parution");

       LocalDate dp= Utilitaire.lecDate();
       double ploc = Double.MIN_VALUE;
       do{
           System.out.println("prix de location");
           String newPrice = saisie("[0-9]{0,10}[.][0-9]{0,2}|[0-9]{0,10}", "Erreur de saisie, veuillez saisir un nombre réel (séparée d'un point) supérieur à 0\nSaisir le prix de la location : ");
           ploc = Double.parseDouble(newPrice);
       }while(ploc < 0);
       System.out.println("langue");
       String langue=sc.nextLine();
       System.out.println("genre");
       String genre=sc.nextLine();
       return addDetail(titre, ageMin,dp,ploc, langue,  genre);
    }

    public abstract Ouvrage addDetail(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre);
}