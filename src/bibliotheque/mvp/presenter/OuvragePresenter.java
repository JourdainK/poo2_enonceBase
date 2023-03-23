package bibliotheque.mvp.presenter;

import bibliotheque.metier.Ouvrage;
import bibliotheque.mvp.model.DAOOuvrage;
import bibliotheque.mvp.view.OuvrageViewInterface;

import java.util.List;

public class OuvragePresenter {

    private DAOOuvrage model;

    private OuvrageViewInterface view;

    public OuvragePresenter(DAOOuvrage model, OuvrageViewInterface view){
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start() { view.setListDatas(getAll());}

    public List<Ouvrage> getAll() { return model.getOuvrages(); }


    //todo implements all methods
}
