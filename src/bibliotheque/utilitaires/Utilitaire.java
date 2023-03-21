package bibliotheque.utilitaires;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Utilitaire {
    private static Scanner sc = new Scanner(System.in);
    public static int choixListe(List l){
       affListe(l);
       return choixElt(l);
    }

    public static void affListe(List l){
        int i =1;
        for(Object o :l) {
            System.out.println((i++)+"."+o);
        }
    }

    public static int choixElt(List l){
        int choix;
        String choix1;
        do {
            System.out.println("choix :");
            choix1 = saisie("[0-9]*","Veuillez saisir un nombre");
            choix = Integer.parseInt(choix1);
            if(choix <1 || choix > l.size()){
                System.out.println("Erreur le nombre doit être compris entre 1 et " + l.size());
            }
        } while(choix <1 || choix > l.size());
        return choix;
    }

    public static String saisie(String regex, String message) {
        boolean check = false;
        String phrase;

        do {
            phrase = sc.nextLine();
            if (phrase.matches(regex)) {
                check = true;
            } else {
                System.out.println(message);
            }

        } while (!check);
        return phrase;
    }

    public static LocalDate lecDate(){
        String[] jma = sc.nextLine().split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        return LocalDate.of(a,m,j);
    }

    public static LocalTime lecTime(){
        String[] hms = sc.nextLine().split(" ");
        int h = Integer.parseInt(hms[0]);
        int m = Integer.parseInt(hms[1]);
        int s = Integer.parseInt(hms[2]);
        return LocalTime.of(h,m,s);
    }
}
