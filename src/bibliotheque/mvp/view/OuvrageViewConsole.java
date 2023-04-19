package bibliotheque.mvp.view;

import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Ouvrage;
import bibliotheque.metier.TypeOuvrage;
import bibliotheque.mvp.presenter.OuvragePresenter;
import bibliotheque.utilitaires.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static bibliotheque.utilitaires.Utilitaire.*;
import static bibliotheque.metier.TypeOuvrage.*;
import static java.util.Arrays.*;

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
        List options = new ArrayList<>(asList("Ajouter","Effacer","Rechercher","Modifier","Retour"));
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

    //had help from Jayson Desclin -> understanding factories
    public void ajouter(){
        List<TypeOuvrage> typeOuv = new ArrayList<>(asList(TypeOuvrage.values()));
        int choix;
        choix = Utilitaire.choixListe(typeOuv);
        Ouvrage ouv;

        List<OuvrageFactory> lOuvrages = new ArrayList<>(asList(new LivreFactory(),new CDFactory(),new DVDFactory()));
        ouv = lOuvrages.get(choix-1).create();

        presenter.addOuvrage(ouv);
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
        List<String> option = new ArrayList<>(asList("Age minimum","Date de parution : ","Prix de la location","Langue","Genre"));
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
                    Set<String> langue = new HashSet<>(asList("anglais","français","italien","allemand"));
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
