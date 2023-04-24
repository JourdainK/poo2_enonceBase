package bibliotheque.mvp.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Ouvrage;
import bibliotheque.mvp.presenter.ExemplairePresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.affListe;
import static bibliotheque.utilitaires.Utilitaire.choixListe;

public class ExemplaireViewConsole implements ExemplaireViewInterface{
    private ExemplairePresenter presenter;
    private List<Exemplaire> lExemplaires;
    private List<Ouvrage> lOuvrages;
    private Scanner sc = new Scanner(System.in);

    public void ExemplaireViewConsole(){

    }


    @Override
    public void setPresenter(ExemplairePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Exemplaire> lexemp) {
        this.lExemplaires = lexemp;
        menu();
    }

    public void affMsg(String msg){
        System.out.println("Information : " + msg);
    }

    public void menu(){
        List<String> option = new ArrayList<>(Arrays.asList("Afficher les exemplaires","Ajouter","Effacer","Modifier","Rechercher","Retour"));
        int choix;

        do{
            System.out.println("");
            choix = choixListe(option);

            switch (choix){
                case 1 -> affListe(lExemplaires);
                case 2 -> System.out.println("ajouter");
                case 3 -> System.out.println("Effacer");
                case 4 -> System.out.println("Modifier");
                case 5 -> System.out.println("Rechercher");
            }
        }while(choix!=option.size());
    }

    public void ajoutExemplaire(){

    }
}
