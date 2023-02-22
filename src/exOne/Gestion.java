package exOne;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static exOne.TypeLivre.*;
import static exOne.TypeOuvrage.*;

public class Gestion {
    private static List<Auteur> lAuteurs = new ArrayList<>();
    private static List<Ouvrage> lOuvrage = new ArrayList<>();
    private static List<Exemplaire> lExemp = new ArrayList<>();
    private static List<Lecteur> lLects = new ArrayList<>();
    private static List<Location> lLocs = new ArrayList<>();
    private static List<Rayon> lRayons = new ArrayList<>();

    public static void main(String[] args) {

        populate();
        //TODO delete those after testing !
        System.out.println("Test listExamplaires (Classe Rayon)\n");
        lRayons.get(0).listerExamplaires();
        System.out.println("Test ListeExemplaires (Classe ouvrage)");
        lOuvrage.get(0).listerExemplaires();
        System.out.println("\n\nTest methods lecteurs (classe Exemplaire)");
        lExemp.get(0).lecteurs();
        System.out.println("\n\nTest method listerOuvrages (classe Auteur)");
        lAuteurs.get(0).listerOuvrages();
        System.out.println("\n\nTEst method listerOuvrages (typeOUvrage typeLivre) (classe auteur)");
        lAuteurs.get(0).listerOuvrages(LIVRE,ESSAI);
        System.out.println("\n\nTest metho liesterOuvrages (TypeLivre typlivre) (classe auteur)\n");
        lAuteurs.get(0).listerOuvrages(ESSAI);
        System.out.println("\n\nTest metho liesterOuvrages (TypeLivre typlivre) (classe auteur)\n\nV II\n\n");
        lAuteurs.get(0).listerOuvrages(ROMAN);
        DateTimeFormatter mformat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("\n\nTest method enRetard (Classe exemplaire\n");
        System.out.println("Date restit : ");
        System.out.println(lExemp.get(0).getListLocations().get(0).getDateRestitution().format(mformat));
        System.out.println("essai format date : ");


        System.out.println(lExemp.get(0).enRetard());

    }
    private static void populate(){

        Auteur aut1 = new Auteur("Carlin","George","USA");
        lAuteurs.add(aut1);


        LocalDate date = LocalDate.of(1993,2,9);
        //TODO use this for dates
        /*
        DateTimeFormatter mformat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("essai format date : ");
        System.out.println(date.format(mformat));
         */

        LocalDate dateRest = LocalDate.of(2023,06,01);
        Livre l1 = new Livre("When will Jesus Bring the porkchop",date,"English","Comédie", (byte) 18,2.5, aut1,"978-1401308216", ESSAI,"Here we go again . . . George Carlin's hilarious When Will Jesus Bring the Pork Chops!",319);
        lOuvrage.add(l1);
        /*
        System.out.println("Test livre : ");
        System.out.println(l1);
         */
        Rayon r1 = new Rayon("ra001","ESSAI");
        lRayons.add(r1);
        /*
        System.out.println("test rayon : ");
        System.out.println(r1);
         */
        Exemplaire e1 = new Exemplaire(1,l1);
        lExemp.add(e1);
        e1.setRayonExamplaire(r1);


        Lecteur lect1 = new Lecteur(2989,"Pithivier","Inconnu","12.12.1934","pithiver@gmail.com","Rue 7ème compagnie","0478/55.66.99");
        lLects.add(lect1);
        /*
        System.out.println("test lecteur : ");
        System.out.println(lect1)
         */
        Location loc1 = new Location(date, dateRest,e1,lect1);
        lLocs.add(loc1);
        /*
        System.out.println("test location : ");
        System.out.println(loc1);
         */

    }

    public void menu(){
        Scanner sc = new Scanner(System.in);
        String choice1;
        int choice;
        String option = "\n1 - Ajout Auteur\n2 - Ajout Ouvrage\n3 - Ajout Lecteur\n4 - Ajout Rayon\n5 - Ajout Exemplaire\n6 - Louer\n7 - Rendre\n8 - Quitter";

        do{
            do{
                System.out.println(option);
                System.out.println("Votre choix : ");
                choice1 = saisie("[1-8","Veuillez saisir un nombre compris entre 1 et 8\nVotre choix : ");
                choice = Integer.parseInt(choice1);
            }while(choice < 1 || choice > 8);

            switch(choice){
                //TODO create methods of the menu
                case 1 -> System.out.println("Ajout aut");
                case 2 -> System.out.println("Ajout OUvr");
                case 3 -> System.out.println("Ajout lect");
                case 4 -> System.out.println("Ajout Ray");
                case 5 -> System.out.println("Ajout exemple");
                case 6 -> System.out.println("Louer");
                case 7 -> System.out.println("Rendre");
                case 8 -> System.out.println("Au revoir.");
                default -> System.out.println("Erreur de saisie");
            }

        }while(choice != 8);

    }

    public String saisie(String regex, String message) {
        Scanner sc = new Scanner(System.in);
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


}