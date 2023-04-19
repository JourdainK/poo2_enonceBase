package bibliotheque.mvp.view;

import bibliotheque.metier.Rayon;
import bibliotheque.mvp.presenter.RayonPresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.choixListe;
import static bibliotheque.utilitaires.Utilitaire.saisie;

public class RayonViewConsole implements RayonViewInterface{
    private RayonPresenter presenter;
    private List<Rayon> lRayons;
    private Scanner sc = new Scanner(System.in);

    //TODO Rayon view Console
    public RayonViewConsole(){

    }
    @Override
    public void setPresenter(RayonPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Rayon> lrayons) {
        this.lRayons = lrayons;
        menu();
    }

    @Override
    public void affMsg(String msg) {
        System.out.println("Information : " + msg );
    }

    @Override
    public void affList(List<Rayon> lrayons) {
        Utilitaire.affListe(lrayons);
    }


    public void menu(){
        List<String> loptions = new ArrayList<>(Arrays.asList("Afficher les rayons","Ajouter","Effacer","Rechercher","Modifier","Retour"));
        int choix;
        do{
            Utilitaire.affListe(loptions);
            choix = choixListe(loptions);

            switch (choix){
                case 1 -> affList(lRayons);
                case 2 -> System.out.println("Ajouter");
                case 3 -> System.out.println("effacer");
                case 4 -> System.out.println("rechercher");
                case 5 -> System.out.println("modifier");
            }
        }while(choix!=6);

    }

    public void ajouterRayon(){
        System.out.println("Saisir le code du rayon : ");
        String codeRayon = saisie("[0-9]{0,3},[a-zA-Z]{0,2}","Veuillez saisir un code de rayon type (1A, 10B ect)\nSaisir le code du rayon : ");
        System.out.println("Saisir le genre du rayon : ");
        String genre = sc.nextLine();

        Rayon r = new Rayon(codeRayon,genre);
        presenter.addRayon(r);
        lRayons = presenter.getAll();
    }

    /*
    private voir special() {

    }
     */


    
}
