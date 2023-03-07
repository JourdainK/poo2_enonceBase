package bibliotheque.gestion;

import bibliotheque.metier.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Gestion {
    Scanner sc = new Scanner(System.in);

    private static List<Auteur> laut = new ArrayList<>();
    private static List<Lecteur> llect = new ArrayList<>();
    private static List<Ouvrage> louv = new ArrayList<>();
    private static List<Exemplaire> lex = new ArrayList<>();
    private static List<Rayon> lrayon = new ArrayList<>();
    private static List<Location> lloc = new ArrayList<>();


    public void populate() {
        Auteur a = new Auteur("Verne", "Jules", "France");
        laut.add(a);

        Livre l = new Livre("Vingt mille lieues sous les mers", 10, LocalDate.of(1880, 1, 1), 1.50, "français", "aventure", "a125", 350, TypeLivre.ROMAN, "histoire de sous-marin");
        louv.add(l);

        a.addOuvrage(l);

        a = new Auteur("Spielberg", "Steven", "USA");
        laut.add(a);

        DVD d = new DVD("AI", 12, LocalDate.of(2000, 10, 1), 2.50, "anglais", "SF", 4578l, "120 min", (byte) 2);
        d.getAutresLangues().add("français");
        d.getAutresLangues().add("italien");
        d.getSousTitres().add("néerlandais");
        louv.add(d);

        a.addOuvrage(d);

        a = new Auteur("Kubrick", "Stanley", "GB");
        laut.add(a);

        a.addOuvrage(d);


        CD c = new CD("The Compil 2023", 0, LocalDate.of(2023, 1, 1), 2, "English", "POP", 1245, (byte) 20, "100 min");
        louv.add(c);

        Rayon r = new Rayon("r12", "aventure");
        lrayon.add(r);

        Exemplaire e = new Exemplaire("m12", "état neuf", l);
        lex.add(e);
        e.setRayon(r);


        r = new Rayon("r45", "science fiction");
        lrayon.add(r);

        e = new Exemplaire("d12", "griffé", d);
        lex.add(e);

        Exemplaire e2 = new Exemplaire("d13", "Parfait", d);
        e2.setRayon(r);
        lex.add(e2);

        e.setRayon(r);


        Lecteur lec = new Lecteur(1, "Dupont", "Jean", LocalDate.of(2000, 1, 4), "Mons", "jean.dupont@mail.com", "0458774411");
        llect.add(lec);

        Lecteur lec2 = new Lecteur(2, "Pithivier", "Inconnu", LocalDate.of(1978, 1, 4), "Paris", "pithivier@mail.com", "0555555");
        llect.add(lec2);

        Location loc = new Location(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 3, 1), lec, e);
        lloc.add(loc);
        loc.setDateRestitution(LocalDate.of(2023, 2, 4));

        Location loc2 = new Location(LocalDate.of(2023, 3, 2), LocalDate.of(2023, 3, 16), lec2, e);
        lloc.add(loc2);
        loc2.setDateRestitution(LocalDate.of(2023, 4, 21));


        lec = new Lecteur(3, "Durant", "Aline", LocalDate.of(1980, 10, 10), "Binche", "aline.durant@mail.com", "045874444");
        llect.add(lec);

        loc = new Location(LocalDate.of(2023, 2, 5), LocalDate.of(2022, 3, 5), lec, e);
        lloc.add(loc);
    }

    private void menu() {
        List options = new ArrayList<>(Arrays.asList("auteurs", "ouvrages", "exemplaires", "rayons", "lecteurs", "locations", "fin"));

        do {
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + "." + options.get(i));
            }

            int choix;
            do {
                System.out.println("choix :");
                choix = sc.nextInt();
                sc.skip("\n");
            } while (choix < 1 || choix > options.size());
            switch (choix) {
                case 1:
                    gestAuteurs();
                    break;
                case 2:
                    gestOuvrages();
                    break;
                case 3:
                    gestExemplaires();
                    break;
                case 4:
                    gestRayons();
                    break;
                case 5:
                    gestLecteurs();
                    break;
                case 6:
                    gestLocations();
                    break;
                default:
                    System.exit(0);
            }
        } while (true);
    }

    private void gestLocations() {
//TODO lister exemplaires,lister lecteurs,créer la location avec le constructeur à deux paramètres(loueur,exemplaire)

    }

    private void gestLecteurs() {
        System.out.println("numéro");
        int num = sc.nextInt();
        sc.skip("\n");
        System.out.println("nom ");
        String nom = sc.nextLine();
        System.out.println("prénom ");
        String prenom = sc.nextLine();
        System.out.println("date de naissance");
        String[] jma = sc.nextLine().split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        LocalDate dn = LocalDate.of(a, m, j);
        System.out.println("adresse");
        String adr = sc.nextLine();
        System.out.println("mail");
        String mail = sc.nextLine();
        System.out.println("tel ");
        String tel = sc.nextLine();
        Lecteur lect = new Lecteur(num, nom, prenom, dn, adr, mail, tel);
        llect.add(lect);
        System.out.println("lecteur créé");
    }

    private void gestRayons() {
        System.out.println("code ");
        String code = sc.next();
        System.out.println("genre ");
        String genre = sc.next();
        Rayon r = new Rayon(code, genre);
        System.out.println("rayon créé");
    }

    private void gestExemplaires() {
        System.out.println("matricule ");
        String mat = sc.next();
        System.out.println("etat  ");
        String etat = sc.next();
        System.out.println("ouvrage ");
        for (int i = 0; i < louv.size(); i++) {
            System.out.println((i + 1 + "." + louv.get(i)));
        }
        int choix;
        do {
            System.out.println("choix :");
            choix = sc.nextInt();
            sc.skip("\n");
        } while (choix < 1 || choix > louv.size());
        Exemplaire ex = new Exemplaire(mat, etat, louv.get(choix - 1));
        lex.add(ex);
        System.out.println("exemplaire créé");
    }

    private void gestOuvrages() {
        Ouvrage o = null;
        System.out.println("titre");
        String titre = sc.nextLine();
        System.out.println("age minimum");
        int ageMin = sc.nextInt();
        sc.skip("\n");
        System.out.println("date de parution");
        String[] jma = sc.nextLine().split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        LocalDate dp = LocalDate.of(a, m, j);
        System.out.println("prix de location");
        double ploc = sc.nextDouble();
        sc.skip("\n");
        System.out.println("langue");
        String langue = sc.nextLine();
        System.out.println("genre");
        String genre = sc.nextLine();
        TypeOuvrage[] to = TypeOuvrage.values();

        for (int i = 0; i < to.length; i++) {
            System.out.println((i + 1) + "." + to[i]);
        }

        int choix;
        do {
            System.out.println("choix :");
            choix = sc.nextInt();
            sc.skip("\n");
        } while (choix < 1 || choix > to.length);
        switch (choix) {
            case 1:
                String optionLivre = "\n1.Roman\n2.Nouvelle\n3.Essai\n4.Documentaire\n5.Biographie";
                String choixLivre1;
                int choixLivre;
                System.out.println("isbn ");
                String isbn = sc.next();
                System.out.println("pages ");
                int nbrePages = sc.nextInt();
                sc.skip("\n");
                System.out.println("Choisir le type de livre : ");
                do {
                    choixLivre1 = saisie("[1-5]{1}", "Veuillez saisir un nombre compris entre 1 et 5\nChoisir le type de livre : ");
                    choixLivre = Integer.parseInt(choixLivre1);
                } while (choixLivre < 1 || choixLivre > 5);
                TypeLivre tl;
                if (choixLivre == 1) {
                    tl = TypeLivre.ROMAN;
                } else if (choixLivre == 2) {
                    tl = TypeLivre.NOUVELLE;
                } else if (choixLivre == 3) {
                    tl = TypeLivre.ESSAI;
                } else if (choixLivre == 4) {
                    tl = TypeLivre.DOCUMENTAIRE;
                } else {
                    tl = TypeLivre.BIOGRAPHIE;
                }
                System.out.println("Saisir le résumé : ");
                String resume = sc.nextLine();
                o = new Livre(titre, ageMin, dp, ploc, langue, genre, isbn, nbrePages, tl, resume);
                louv.add(o);
                break;

            case 2:
                long code;
                String codeD, nbrBonusD;
                String durTot;
                byte nbrBonus;

                System.out.println("Saisir le code : ");
                codeD = saisie("[0-9]*","Veuillez saisir un nombre (positif)\nSaisir le code : ");
                code = Long.parseLong(codeD);
                System.out.println("Saisir la durée du film : ");
                durTot = sc.nextLine();
                do{
                    System.out.println("Saisir le nombre de bonus : ");
                    nbrBonusD = saisie("[0-9]*","Saisir un nombre positif\nSaisir le nombre de bonus : ");
                    nbrBonus = Byte.parseByte(nbrBonusD);
                }while(nbrBonus < 1);
                o = new DVD(titre,ageMin,dp,ploc,langue,genre,code,durTot,nbrBonus);
                louv.add(o);
                break;

            case 3:   //TODO gérer création CD


                break;
        }
        louv.add(o);
        System.out.println("ouvrage créé");
    }

    private void gestAuteurs() {
        System.out.println("nom ");
        String nom = sc.nextLine();
        System.out.println("prénom ");
        String prenom = sc.nextLine();
        System.out.println("nationalité");
        String nat = sc.nextLine();
        Auteur a = new Auteur(nom, prenom, nat);
        laut.add(a);
        System.out.println("écrivain créé");
    }

    public static void main(String[] args) {
        Gestion g = new Gestion();
        g.populate();
        /*
        //Test envoiMailLecteurActuel(Mail mail) --> classe Exemplaire
        Mail m1 = new Mail("Plop","test test", "01/01/0001");
        lex.get(1).envoiMailLecteurActuel(m1);
         */

        /*
            //test envoiMailLecteurs(Mail mail) --> classe Exemplaire
            Mail m1 = new Mail("Plop","test test", "01/01/0001");
            lex.get(1).envoiMailLecteurs(m1);
         */


        /*

        //test enRetard --> classe Exemplaire
        System.out.println("\nTEST enRetard ---\n");
        System.out.println(lex.get(1).enRetard());

         */

        /*

        //test enRetard --> classe exemplaire

        System.out.println(lex.get(1).enRetard());
        if(lex.get(1).enRetard()){
            System.out.println("En retard de +/- " + lex.get(1).joursRetard() + " jours ");
        }

         */


        g.menu();

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
