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
        System.out.println("age minimum");
        int ageMin= sc.nextInt();
        sc.skip("\n");
        System.out.println("date de parution");
        LocalDate dp= Utilitaire.lecDate();
        System.out.println("prix de location");
        double ploc = sc.nextDouble();
        sc.skip("\n");
        System.out.println("langue");
        String langue=sc.nextLine();
        System.out.println("genre");
        String genre=sc.nextLine();

        //détails propres à la classe CD
        System.out.println("code : ");
        long code= sc.nextLong();
        System.out.println("nombre de plages :");
         byte nbrePlages= sc.nextByte();sc.skip("\n");
        System.out.println("durée en H M S : ");
        LocalTime dureeTotale = Utilitaire.lecTime();
        CD cd =new CD(titre,ageMin,dp,ploc,langue,genre,code,nbrePlages,dureeTotale);
        return cd;
    }
}
