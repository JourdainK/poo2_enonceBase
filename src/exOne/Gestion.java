package exOne;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Gestion {
    public static void main(String[] args) {


    }

    private static void populate(){

        Auteur aut1 = new Auteur("Carlin","George","USA");
        System.out.println("\nAuteur");
        System.out.println(aut1);

        LocalDate date = LocalDate.of(1993,2,9);
        /*
        DateTimeFormatter mformat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("essai format date : ");
        System.out.println(date.format(mformat));
         */

        LocalDate dateRest = LocalDate.of(2023,06,01);
        Livre l1 = new Livre("When will Jesus Bring the porkchop",date,"English","Comédie", (byte) 18,2.5,"978-1401308216",TypeLivre.ESSAI,"Here we go again . . . George Carlin's hilarious When Will Jesus Bring the Pork Chops!",319);
        System.out.println("Test livre : ");
        System.out.println(l1);

        Rayon r1 = new Rayon("ra001","ESSAI");
        System.out.println("test rayon : ");
        System.out.println(r1);


        Exemplaire e1 = new Exemplaire(1,"Disponible",l1);
        //ajout de l'exemplaire créé au rayon
        r1.getListExemplaires().add(e1);
        e1.setRayonExamplaire(r1);
        System.out.println("test exemplaire : ");
        System.out.println(e1);

        Lecteur lect1 = new Lecteur(2989,"Pithivier","Inconnu","12.12.1934","pithiver@gmail.com","Rue 7ème compagnie","0478/55.66.99");
        System.out.println("test lecteur : ");
        System.out.println(lect1);

        Location loc1 = new Location(date, dateRest,e1,lect1);
        System.out.println("test location : ");
        System.out.println(loc1);
    }
}