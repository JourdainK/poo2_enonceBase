package bibliotheque.utilitaires;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Utilitaire {
    private static Scanner sc = new Scanner(System.in);

    public static int choixListe(List l) {

        int i = 1;
        for (Object o : l) {
            System.out.println((i++) + "." + o);
        }
        String choice;
        int choix;
        do {
            System.out.println("choix :");
            choice = saisie("[0-9]*","Veuillez saisir un nombre");
            choix = Integer.parseInt(choice);
        } while (choix < 1 || choix > l.size());
        return choix;
    }

    public static LocalDate lecDate() {
        String[] jma = sc.nextLine().split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        return LocalDate.of(a, m, j);
    }

    public static LocalTime lecTime() {
        String[] hms = sc.nextLine().split(" ");
        int h = Integer.parseInt(hms[0]);
        int m = Integer.parseInt(hms[1]);
        int s = Integer.parseInt(hms[2]);
        return LocalTime.of(h, m, s);
    }

    public static boolean isStrInList(String str, List<String> list) {
        boolean isIn = false;

        for (String l : list) {
            if (l.equals(str)) {
                isIn = true;
            }
        }

        return isIn;
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
}
