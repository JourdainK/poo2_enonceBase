package exOne;

import java.time.LocalDate;

public class Gestion {
    public static void main(String[] args) {

        Auteur aut1 = new Auteur("Carlin","George","USA");
        System.out.println("\nAuteur");
        System.out.println(aut1);
        LocalDate date = LocalDate.of(1993,2,9);
        Livre l1 = new Livre("When will Jesus Bring the porkchop",date,"English","Comédie", (byte) 18,2.5,"978-1401308216",TypeLivre.ESSAI,"Here we go again . . . George Carlin's hilarious When Will Jesus Bring the Pork Chops!",319);
        System.out.println("Livre test \n");
        System.out.println(l1);

    }
}
