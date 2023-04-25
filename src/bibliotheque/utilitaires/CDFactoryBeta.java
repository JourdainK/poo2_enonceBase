package bibliotheque.utilitaires;

import bibliotheque.metier.CD;
import bibliotheque.metier.Livre;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeLivre;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CDFactoryBeta {
    protected Scanner sc= new Scanner(System.in);
    public Ouvrage create() {

        System.out.println("titre");
        String titre= sc.nextLine();
        int ageMin=0;
        try{
            System.out.println("age minimum");
            ageMin= sc.nextInt();
            sc.skip("\n");
        }catch (Exception e){
            System.out.println("Erreur lors de l'encodage de l'âge : " + e);
            //delete for release
            e.printStackTrace();
        }
        System.out.println("date de parution");
        LocalDate dp= Utilitaire.lecDate();

        double ploc=0;
        try{
            System.out.println("prix de location");
            ploc = sc.nextDouble();
            sc.skip("\n");

        }catch (NumberFormatException e){
            System.out.println("Erreur lors de l'encodage du prix de la location " + e);
            //delete for release
            e.printStackTrace();
        }
        System.out.println("langue");
        String langue=sc.nextLine();
        System.out.println("genre");
        String genre=sc.nextLine();

        //détails propres à la classe CD
        long code = 0;
        try{
            System.out.println("code : ");
            String code1 = sc.nextLine();
            code= Long.parseLong(code1);
        }catch (NumberFormatException e){
            System.out.println("Erreur lors de l'encodage du code : " + e);
            //to delete
            e.printStackTrace();
        }
        byte nbrePlages = 0;
        try{
            System.out.println("nombre de plages :");
            nbrePlages= sc.nextByte();sc.skip("\n");
        }catch (NumberFormatException e){
            System.out.println("Erreur, nombre invalide : " + e);
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("Erreur " + e);
            e.printStackTrace();
        }
        System.out.println("durée en H M S : ");
        LocalTime dureeTotale = Utilitaire.lecTime();
        CD cd = null;
        try{
            cd =new CD(titre,ageMin,dp,ploc,langue,genre,code,nbrePlages,dureeTotale);
        }catch (Exception e){
            System.out.println("Erreur lors de la création du cd : " +e.getMessage());
            e.printStackTrace();
        }
        return cd;
    }
}
