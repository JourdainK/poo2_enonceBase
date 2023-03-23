package bibliotheque.mvp.presenter;

import bibliotheque.mvp.model.DAOAuteur;
import bibliotheque.mvp.model.DAOLecteur;
import bibliotheque.mvp.view.AuteurViewConsole;
import bibliotheque.mvp.view.LecteurViewInterface;

public class AuteurPresenter {

    private DAOAuteur model;

    private AuteurViewConsole view;

    public AuteurPresenter(DAOAuteur model, AuteurViewConsole view){
        this.model = model;
        this.view = view;


    }


}

