package bibliotheque.mvp;

import bibliotheque.mvp.model.*;
import bibliotheque.mvp.presenter.AuteurPresenter;
import bibliotheque.mvp.presenter.LecteurPresenter;
import bibliotheque.mvp.presenter.OuvragePresenter;
import bibliotheque.mvp.view.*;
import bibliotheque.utilitaires.Utilitaire;

import java.util.Arrays;
import java.util.List;


// got help from Jayson Desclin (Explanation about MVP system)
// https://www.youtube.com/watch?v=XHw4bBLM8Vk&t=1s
public class GestBiblio {

    private DAOLecteur lm;
    private LecteurViewInterface lv;
    private LecteurPresenter lp;

    private DAOOuvrage om;
    private OuvrageViewInterface ov;
    private OuvragePresenter op;

    private DAOAuteur am;
    private AuteurViewInterface av;
    private AuteurPresenter ap;

    public void gestion(){
        lm = new LecteurModel();
        lv = new LecteurViewConsole();
        lp = new LecteurPresenter(lm, lv);//création et injection de dépendance
        om = new OuvrageModel();
        ov = new OuvrageViewConsole();
        op = new OuvragePresenter(om, ov);
        am = new AuteurModel();
        av = new AuteurViewConsole();
        ap = new AuteurPresenter(am,av);


        List<String> loptions = Arrays.asList("Lecteurs","Ouvrages","Auteurs" ,"fin");
        do {
            int ch = Utilitaire.choixListe(loptions);
            switch (ch){
                case 1: lp.start();
                    break;
                case 2 : op.start();
                    break;
                case 3 : ap.start();
                    break;
                case 4 : System.exit(0);
            }
        }while(true);
    }
    public static void main(String[] args) {
        GestBiblio gb = new GestBiblio();
           gb.gestion();
    }
}
