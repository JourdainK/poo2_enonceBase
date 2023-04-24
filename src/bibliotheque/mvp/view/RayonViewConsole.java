package bibliotheque.mvp.view;

import bibliotheque.metier.Rayon;
import bibliotheque.mvp.presenter.RayonPresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;

public class RayonViewConsole implements RayonViewInterface{
    private RayonPresenter presenter;
    private List<Rayon> lRayons;
    private Scanner sc = new Scanner(System.in);

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
        affListe(lrayons);
    }


    public void menu(){
        List<String> loptions = new ArrayList<>(Arrays.asList("Afficher les rayons","Ajouter","Effacer","Rechercher","Modifier","Retour"));
        int choix;
        do{
            System.out.println("");
            choix = choixListe(loptions);

            switch (choix){
                case 1 -> affListe(lRayons);
                case 2 -> ajouterRayon();
                case 3 -> effacerRayon();
                case 4 -> searchRayon();
                case 5 -> modifierRayon();
            }
        }while(choix!=6);

    }

    public void ajouterRayon(){
        System.out.println("Saisir le code du rayon : ");
        String codeRayon = sc.nextLine();
        System.out.println("Saisir le genre du rayon : ");
        String genre = sc.nextLine();

        Rayon r = new Rayon(codeRayon,genre);
        presenter.addRayon(r);
        lRayons = presenter.getAll();
    }

    public void effacerRayon(){
        affListe(lRayons);
        int choix = choixElt(lRayons);
        Rayon rayToDelete = lRayons.get(choix-1);
        System.out.println("Rayon qui sera effacé : \n" + rayToDelete);
        presenter.removeRayon(rayToDelete);
        //rafraichissement
        lRayons = presenter.getAll();
        affListe(lRayons);
    }

    public void searchRayon(){
        System.out.println("Saisir le code du rayon : ");
        String codeSearch = sc.nextLine();
        presenter.readRayon(codeSearch);
    }

    public void modifierRayon(){
        affList(lRayons);
        int choix = choixElt(lRayons);
        Rayon rayonTomodif = lRayons.get(choix-1);

        System.out.println("Saisir le genre du rayon : ");
        String newGenre = sc.nextLine();
        rayonTomodif.setGenre(newGenre);
        presenter.updateRayon(rayonTomodif);
        lRayons = presenter.getAll();
        affList(lRayons);
    }

    /*
    //TODO specials rayon
    private voir special() {

    }
     */
}
