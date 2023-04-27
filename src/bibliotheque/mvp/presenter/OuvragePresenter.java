package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Ouvrage;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.model.SpecialLecteur;
import bibliotheque.mvp.view.ViewInterface;

import java.util.List;

public class OuvragePresenter extends Presenter<Ouvrage> {


    public OuvragePresenter(DAO<Ouvrage> model, ViewInterface<Ouvrage> view) {
        super(model,view);
    }

}
