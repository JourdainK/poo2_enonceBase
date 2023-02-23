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
    private static List<Ouvrage> louv= new ArrayList<>();
    private static List<Exemplaire> lex = new ArrayList<>();
    private static List<Rayon> lrayon= new ArrayList<>();
    private static List<Location> lloc = new ArrayList<>();


    public void populate(){
        Auteur a = new Auteur("Verne","Jules","France");
        laut.add(a);

        Livre l = new Livre("Vingt mille lieues sous les mers",10, LocalDate.of(1880,1,1),1.50,"français","aventure","a125",350,TypeLivre.ROMAN,"histoire de sous-marin");
        louv.add(l);

        a.addOuvrage(l);

        a = new Auteur("Spielberg","Steven","USA");
        laut.add(a);

        DVD d = new DVD("AI",12,LocalDate.of(2000,10,1),2.50,"anglais","SF",4578l,"120 min",(byte)2);
        d.getAutresLangues().add("français");
        d.getAutresLangues().add("italien");
        d.getSousTitres().add("néerlandais");
        louv.add(d);

        a.addOuvrage(d);

         a = new Auteur("Kubrick","Stanley","GB");
        laut.add(a);

        a.addOuvrage(d);


        CD c = new CD("The Compil 2023",0,LocalDate.of(2023,1,1),2,"English","POP",1245,(byte)20,"100 min");
        louv.add(c);

        Rayon r = new Rayon("r12","aventure");
        lrayon.add(r);

        Exemplaire e = new Exemplaire("m12","état neuf",l);
        lex.add(e);
        e.setRayon(r);


        r = new Rayon("r45","science fiction");
        lrayon.add(r);

        e = new Exemplaire("d12","griffé",d);
        lex.add(e);

        e.setRayon(r);


        Lecteur lec = new Lecteur(1,"Dupont","Jean",LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
        llect.add(lec);

        Location loc = new Location(LocalDate.of(2023,2,1),LocalDate.of(2023,3,1),lec,e);
        lloc.add(loc);
        loc.setDateRestitution(LocalDate.of(2023,2,4));

        lec = new Lecteur(1,"Durant","Aline",LocalDate.of(1980,10,10),"Binche","aline.durant@mail.com","045874444");
        llect.add(lec);

        loc = new Location(LocalDate.of(2023,2,5),LocalDate.of(2023,3,5),lec,e);
        lloc.add(loc);
    }

    private void menu() {
        List options = new ArrayList<>(Arrays.asList("auteurs","ouvrages","exemplaires","rayons","lecteurs","locations","fin"));

        do{
            for(int i=0;i<options.size();i++){
                System.out.println((i+1)+"."+options.get(i));
            }
           
            int choix;
          do {
              System.out.println("choix :");
              choix = sc.nextInt();
              sc.skip("\n");
          } while(choix <1 || choix > options.size());
            switch (choix){
                case 1 :gestAuteurs(); break;
                case 2 : gestOuvrages();break;
                case 3 : gestExemplaires();break;
                case 4 : gestRayons();break;
                case 5 : gestLecteurs();break;
                case 6 : gestLocations();break;
                default:System.exit(0);
            }
        }  while (true);
    }

    private void gestLocations() {
//TODO lister exemplaires,lister lecteurs,créer la location avec le constructeur à deux paramètres(loueur,exemplaire)

    }

    private void gestLecteurs() {
        System.out.println("numéro");
        int num=sc.nextInt();
        sc.skip("\n");
        System.out.println("nom ");
        String nom=sc.nextLine();
        System.out.println("prénom ");
        String prenom=sc.nextLine();
        System.out.println("date de naissance");
        String[] jma = sc.nextLine().split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        LocalDate dn= LocalDate.of(a,m,j);
        System.out.println("adresse");
        String adr=sc.nextLine();
        System.out.println("mail");
        String mail=sc.nextLine();
        System.out.println("tel ");
        String tel=sc.nextLine();
        Lecteur lect = new Lecteur(num,nom,prenom,dn,adr,mail,tel);
        llect.add(lect);
        System.out.println("lecteur créé");
    }

    private void gestRayons() {
        System.out.println("code ");
        String code=sc.next();
        System.out.println("genre ");
        String genre=sc.next();
        Rayon r = new Rayon(code,genre);
        System.out.println("rayon créé");
    }

    private void gestExemplaires() {
        System.out.println("matricule ");
        String mat=sc.next();
        System.out.println("etat  ");
        String etat=sc.next();
        System.out.println("ouvrage ");
        for(int i=0;i<louv.size();i++){
            System.out.println((i+1+"."+louv.get(i)));
        }
        int choix;
        do {
            System.out.println("choix :");
            choix = sc.nextInt();
            sc.skip("\n");
        } while(choix <1 || choix > louv.size());
        Exemplaire ex = new Exemplaire(mat,etat,louv.get(choix-1));
        lex.add(ex);
        System.out.println("exemplaire créé");
    }

    private void gestOuvrages() {
        Ouvrage o = null;
        System.out.println("titre");
        String titre= sc.nextLine();
        System.out.println("age minimum");
        int ageMin= sc.nextInt();
        sc.skip("\n");
        System.out.println("date de parution");
        String[] jma = sc.nextLine().split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        LocalDate dp= LocalDate.of(a,m,j);
        System.out.println("prix de location");
        double ploc = sc.nextDouble();
        sc.skip("\n");
        System.out.println("langue");
        String langue=sc.nextLine();
        System.out.println("genre");
        String genre=sc.nextLine();
        TypeOuvrage[] to = TypeOuvrage.values();

            for(int i =0;i<to.length;i++){
                System.out.println((i+1)+"."+to[i]);
            }

            int choix;
            do {
                System.out.println("choix :");
                choix = sc.nextInt();
                sc.skip("\n");
            } while(choix <1 || choix > to.length);
            switch (choix){
                case 1 :
                           System.out.println("isbn ");
                           String isbn = sc.next();
                           System.out.println("pages ");
                           int nbrePages = sc.nextInt();
                           sc.skip("\n");
                           TypeLivre tl= TypeLivre.ROMAN; //TODO lire le type de livre
                           String resume = "résumé du livre"; //TODO lire le résumé
                           o=new Livre(titre,ageMin,dp,ploc,langue,genre,isbn,nbrePages,tl,resume);
                           ;break;
                case 2 :     //TODO gérer création DVD

                            ;break;
                case 3 :   //TODO gérer création CD

                             ;break;
            }
           louv.add(o);
        System.out.println("ouvrage créé");
    }

       private void gestAuteurs() {
        System.out.println("nom ");
        String nom=sc.nextLine();
        System.out.println("prénom ");
        String prenom=sc.nextLine();
        System.out.println("nationalité");
        String nat=sc.nextLine();
        Auteur a  = new Auteur(nom,prenom,nat);
        laut.add(a);
        System.out.println("écrivain créé");
    }

    public static void main(String[] args) {
        Gestion g = new Gestion();
        g.populate();
        g.menu();
    }

  
}
