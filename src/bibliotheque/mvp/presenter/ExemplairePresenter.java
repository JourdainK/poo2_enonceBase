package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.model.SpecialLecteur;
import bibliotheque.mvp.view.ViewInterface;

import java.util.List;

public class ExemplairePresenter extends Presenter<Exemplaire> {


    public ExemplairePresenter(DAO<Exemplaire> model, ViewInterface<Exemplaire> view) {
        super(model,view);
    }


}
