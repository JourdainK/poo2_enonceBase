package bibliotheque.mvp.view;

import bibliotheque.metier.Auteur;
import bibliotheque.metier.Exemplaire;
import bibliotheque.mvp.presenter.AuteurPresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.util.*;
import static bibliotheque.utilitaires.Utilitaire.*;

public class AuteurViewConsole implements AuteurViewInterface{

    private AuteurPresenter presenter;

    private List<Auteur> lAuteur;
    private Set<Auteur> sAuteur;
    private Scanner sc = new Scanner(System.in);

    public AuteurViewConsole(){};

    @Override
    public void setPresenter(AuteurPresenter presenter) { this.presenter = presenter; }

    @Override
    public void setListDatas(List<Auteur> auteurs) {
        this.lAuteur = auteurs;
        //affListe(lAuteur);
        menu();
    }

    @Override
    public void affList(List<Exemplaire> lex) { affListe(lex);}

    @Override
    public void affMsg(String msg) {
        System.out.println("Information : " + msg);
    }

    public void menu(){
        List<String> option = new ArrayList<>(Arrays.asList("Afficher","Ajouter","Effacer","Rechercher","Modifier","special","Retour"));
        System.out.println(" -- Menu Auteur --");
        int choix = -1;

        do{
            affListe(option);
            choix = choixElt(option);

            switch (choix){
                case 1 -> affAuteur();
                case 2 -> ajoutAuteur();
                case 3 -> deleteAuteur();
                case 4 -> recherAuthorByName();
                case 5 -> modifAuteur();
                case 6 -> System.out.println("SPECIALS !!");
                case 7 -> System.out.println("");
            }

        }while(choix != 7);

    }

    public void ajoutAuteur(){
        System.out.print("\n\nSaisir le nom de l'auteur : ");
        String autName = sc.nextLine();
        System.out.print("\nSaisir le prénom de l'auteur : ");
        String autFname = sc.nextLine();
        System.out.print("\nSaisir la nationalité de l'auteur : ");
        String autNat = sc.nextLine();
        try{
            Auteur tmpAut = new Auteur(autName, autFname, autNat);
            presenter.addAuteur(tmpAut);
            lAuteur = presenter.getAll();
        }catch (Exception e){
            System.out.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
        affListe(lAuteur);
    }

    public void affAuteur(){
        affListe(lAuteur);
        System.out.println("\n");
    }

    public void deleteAuteur(){
        int choix;
        System.out.println("-- Effacer un auteur --\n");
        affListe(lAuteur);
        choix = choixElt(lAuteur);
        Auteur autDelete = lAuteur.get(choix-1);
        presenter.removeAuteur(autDelete);
        lAuteur = presenter.getAll();
        autDelete = null;
    }


    public void modifAuteur(){

        int choix;
        int keepOn = -1;
        System.out.println(" -- Modifier auteur --");
        affListe(lAuteur);
        choix = choixElt(lAuteur);
        Auteur chosenAuteur = lAuteur.get(choix-1);
        List<String> option = new ArrayList<>(Arrays.asList("Nom","Prénom","Nationalité","Retour"));
        int choixModif = -1;
        do{
            affListe(option);
            choixModif = choixElt(option);
            switch (choixModif){
                case 1 :
                    System.out.print("\nSaisir le nouveau nom : ");
                    String newName = sc.nextLine();
                    chosenAuteur.setNom(newName);
                    break;
                case 2 :
                    System.out.print("\nSaisir le nouveau prénom : ");
                    String newPren = sc.nextLine();
                    chosenAuteur.setPrenom(newPren);
                    break;
                case 3 :
                    System.out.print("\nSaisir la nouvelle nationalité : ");
                    String newNat = sc.nextLine();
                    chosenAuteur.setNationalite(newNat);
                    break;
            }

        }while(choixModif!=4);

        presenter.updateAuteur(chosenAuteur);
        lAuteur = presenter.getAll();
        System.out.println("Modification :\n" + chosenAuteur);
    }

    public void recherAuthorByName(){
        System.out.println("-- Recherche d'auteur(s) -- ");
        System.out.println("Saisir le nom :");
        String seekName = sc.nextLine();
        List<Auteur> laut = presenter.lAuthorByName(seekName);
        if(laut!=null){
            affListe(laut);
        }
    }









}
