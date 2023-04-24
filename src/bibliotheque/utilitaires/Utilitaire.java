package bibliotheque.utilitaires;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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

    //no particular order -> choose by their id / other unique attr
    public static void affSet(Set set){
        for(Object s : set){
            System.out.println("\t - " + s);
        }
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
        try{
            String[] jma = sc.nextLine().split(" ");
            int j = Integer.parseInt(jma[0]);
            int m = Integer.parseInt(jma[1]);
            int a = Integer.parseInt(jma[2]);

            return LocalDate.of(a,m,j);
        }catch (Exception e){
            System.out.println("Erreur lors de l'encodage de la date : " + e);
            return null;
        }
    }

    public static LocalTime lecTime(){
        try{
            String[] hms = sc.nextLine().split(" ");
            int h = Integer.parseInt(hms[0]);
            int m = Integer.parseInt(hms[1]);
            int s = Integer.parseInt(hms[2]);

            return LocalTime.of(h,m,s);
        }catch (Exception e){
            System.out.println("Erreur lors de l'encodage " + e);
            return null;
        }
    }

    public static void printLangues(Set<String> langues){
        int i=1;
        for(String l : langues){
            System.out.println((i++) + " - " + l);
        }
    }

    public static String getLangInHashset(Set<String> langues){
        int i = 1;
        int choix;
        String choice;
        boolean check=false;
        StringBuffer err = new StringBuffer("Veuillez saisir un nombre compris entre 1 et " + langues.size());
        String errMess = String.valueOf(err);


        do{
            printLangues(langues);
            System.out.println("Votre choix : ");
            choice = saisie("[0-9]*",errMess);
            choix = Integer.parseInt(choice);
            for(String l : langues){
                if(choix == i){
                    check = true;
                    return l;
                }
                i++;
            }
        }while(!check);

        return null;
    }


    public static String getDateFrench(LocalDate d){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MM yyyy");
        return dtf.format(d);
    }

    public static String modifyIfNotBlank(String label,String oldValue){
        System.out.println(label+" : "+oldValue);
        System.out.print("nouvelle valeur (enter si pas de changement) : ");
        String newValue= sc.nextLine();
        if(newValue.isBlank()) return oldValue;
        return newValue;
    }
}
