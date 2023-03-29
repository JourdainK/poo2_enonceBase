package bibliotheque.mvp.view;

import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeOuvrage;
import bibliotheque.mvp.presenter.OuvragePresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static bibliotheque.utilitaires.Utilitaire.*;
import static bibliotheque.metier.TypeOuvrage.*;

public class OuvrageViewConsole implements OuvrageViewInterface{

    private OuvragePresenter presenter;

    private List<Ouvrage> lOuvr;

    private Scanner sc = new Scanner(System.in);

    public OuvrageViewConsole(){

    }

    @Override
    public void setPresenter(OuvragePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Ouvrage> listOuvrages) {
        this.lOuvr = listOuvrages;
        affListe(lOuvr);
        //TODO delete after menu done
        menu();
    }

    @Override
    public void affMsg(String msg) {
        System.out.println("Information : " + msg);
    }

    @Override
    public void affList(List<Ouvrage> louv) {
       affListe(louv);
    }

    public void menu(){
        affMsg("-- menu Ouvrage --");
        int choix = -1;
        List options = new ArrayList<>(Arrays.asList("Ajouter","Retirer","Rechercher","Modifier","Retour"));
        do{
            affListe(options);
            choix = choixElt(options);

            switch (choix){
                case 1 -> ajouter();
                case 2 -> remove();
                case 3 -> rechercher();
                case 4 -> modif();
            }
        }while(choix != 5);

    }

    public void ajouter(){

        System.out.print("\nEntrer un titre : ");
        String title = sc.nextLine();

        int ageMini = -1;
        do{
            System.out.print("\nEntrer l'âge minimum : ");
            String ageMin = saisie("[0-9]*","Veuillez saisir un nombre");
            ageMini = Integer.parseInt(ageMin);
            if(ageMini < 0) System.out.println("l'age doit être supérieur à 1");
        }while(ageMini < 0);

        System.out.print("\nEntrer la date de parution : ");
        LocalDate dateParu = lecDate();
        //LocalDate dateParuFr = LocalDate.parse(getDateFrench(dateParu));

        TypeOuvrage to=null;
        int choiceTyOuv = -1;
        do{
            System.out.println("Choix du type d'ouvrage : ");
            System.out.println("1." + LIVRE + "\n2." + CD + "\n3." + DVD);
            String choiceTo = saisie("[1-3]{1}","Veuillez saisir un nombre compris entre 1 et 3");
            choiceTyOuv = Integer.parseInt(choiceTo);
        }while(choiceTyOuv < 1 || choiceTyOuv > 3);

        switch (choiceTyOuv){
            case 1 -> to = LIVRE;
            case 2 -> to = CD;
            case 3 -> to = DVD;
        }
        double price = -1;

        do{
            System.out.print("\nSaisir le prix de la location : ");
            String price1 = saisie("[0-9]{0,10}[.][0-9]{0,2}|[0-9]{0,10}","Veuillez saisir un nombre réels :");
            price = Double.parseDouble(price1);
        }while(price < 0);

        Set<String> langue = new HashSet<>(Arrays.asList("anglais","français","italien","allemand"));
        String chosenLang = getLangInHashset(langue);

        System.out.print("\nSaisir le genre : ");
        String genre = sc.nextLine();

        //TODO check teacher version -> understand why to was causing problem...
        //followed suggestions of IntelliJ (must be wrong)

        Ouvrage ouvrage = new Ouvrage(title, ageMini, dateParu, to, price, chosenLang, genre) {
            @Override
            public double amendeRetard(int njours) {
                if(to.equals(DVD)){
                    return 2;
                } else if (to.equals(CD)) {
                    return 1.5;

                }
                else return 1;
            }

            @Override
            public int njlocmax() {
                if(to.equals(DVD)){
                    return 5;
                } else if (to.equals(CD)) {
                    return 7;

                }
                else return 14;
            }
        };

        presenter.addOuvrage(ouvrage);
        lOuvr = presenter.getAll();
        affList(lOuvr);
    }


    public void remove(){
        int choix;
        affListe(lOuvr);
        choix = choixElt(lOuvr);
        Ouvrage toRemove = lOuvr.get(choix-1);
        presenter.removeOuvrage(toRemove);
        lOuvr = presenter.getAll();
        affListe(lOuvr);
    }

    public void modif(){
        int choix;
        int keepOn = -1;
        affListe(lOuvr);
        choix = choixElt(lOuvr);
        Ouvrage toModif = lOuvr.get(choix-1);
        List<String> option = new ArrayList<>(Arrays.asList("Age minimum","Date de parution : ","Prix de la location","Langue","Genre"));
        do{
            affListe(option);
            int choixModif = choixElt(option);
            switch (choixModif){
                case 1 :
                    System.out.print("\nSaisir le nouvel age minimum : ");
                    String newAge = saisie("[0-9]*","Veuillez saisir un nombre : ");
                    int newAg = Integer.parseInt(newAge);
                    toModif.setAgeMin(newAg);
                    break;
                case 2 :
                    System.out.print("\nSaisir la nouvelle date de parution : ");
                    LocalDate newDate = lecDate();
                    toModif.setDateParution(newDate);
                    break;
                case 3 :
                    System.out.print("\nSaisir le nouveau prix : ");
                    String newPrix = saisie("[0-9]{0,10}[.][0-9]{0,2}|[0-9]{0,10}","Veuillez saisir un nombre réels : ");
                    Double newPrice = Double.parseDouble(newPrix);
                    toModif.setPrixLocation(newPrice);
                    break;
                case 4 :
                    System.out.println("choix de la nouvel langue : ");
                    Set<String> langue = new HashSet<>(Arrays.asList("anglais","français","italien","allemand"));
                    String chosenLang = getLangInHashset(langue);
                    toModif.setLangue(chosenLang);
                    break;
                case 5 :
                    System.out.println("Saisir le genre du livre : ");
                    String newGenre = sc.nextLine();
                    toModif.setGenre(newGenre);
                    break;
            }
            System.out.println("Voulez- vous continuer les modifications\n1. Continuer\n2. Arrêter ");
            String keepOn1 = saisie("[1-2]{1}","Erreur, veuillez saisir 1 pour continue, 2 pour arreter");
            keepOn = Integer.parseInt(keepOn1);
        }while(keepOn!=2);

        presenter.updateOuvrage(toModif);
        lOuvr = presenter.getAll();
        affList(lOuvr);
    }

    public void rechercher(){

        System.out.println("Saisir le titre de l'ouvrage recherché : ");
        String seekOuv = sc.nextLine();
        Ouvrage ouv = presenter.readOuvrage(seekOuv);
       if(ouv!=null){
           System.out.println("\n" + ouv + "\n");
       }
    }

}
