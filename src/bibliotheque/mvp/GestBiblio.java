package bibliotheque.mvp;

import bibliotheque.mvp.model.DAOLecteur;
import bibliotheque.mvp.model.LecteurModel;
import bibliotheque.mvp.presenter.LecteurPresenter;
import bibliotheque.mvp.view.LecteurViewConsole;
import bibliotheque.mvp.view.LecteurViewInterface;

public class GestBiblio {
    public static void main(String[] args) {
        DAOLecteur lm = new LecteurModel();

        LecteurViewInterface lv = new LecteurViewConsole();

        LecteurPresenter lp = new LecteurPresenter(lm, lv);//création et injection de dépendance
        lp.start();

    }

}
